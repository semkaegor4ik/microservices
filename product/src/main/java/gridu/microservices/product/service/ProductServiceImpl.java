package gridu.microservices.product.service;

import gridu.microservices.product.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final RestTemplate restTemplate;

    @Override
    public Optional<Product> getAvailabileProduct(String id) {
        Product product;
        try {
            product = restTemplate.getForObject("http://CATALOG/catalog/id/" + id, Product.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode().value() == 404) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "product Not Found");
            } else {
                throw ex;
            }
        }
        boolean availability = restTemplate.getForObject("http://INVENTORY/inventory/" + product.getUniqId(), Boolean.class);

        return availability ? Optional.of(product) : Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAvailabileProducts(String sku) {
        Product[] products;
        try {
            products = restTemplate.getForObject("http://CATALOG/catalog/sku/" + sku, Product[].class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode().value() == 404) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "product Not Found");
            } else {
                throw ex;
            }
        }
        return Optional.of(Arrays.stream(products)
                .filter(product -> restTemplate.getForObject("http://INVENTORY/inventory/" + Objects.requireNonNull(product).getUniqId(), Boolean.class))
                .collect(Collectors.toList()));
    }
}
