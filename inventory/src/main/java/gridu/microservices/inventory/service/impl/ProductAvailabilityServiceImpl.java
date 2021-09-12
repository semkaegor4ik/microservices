package gridu.microservices.inventory.service.impl;

import gridu.microservices.inventory.model.ProductAvailability;
import gridu.microservices.inventory.repository.ProductAvailabilityRepository;
import gridu.microservices.inventory.service.ProductAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductAvailabilityServiceImpl implements ProductAvailabilityService {
    private final ProductAvailabilityRepository repository;

    @Override
    public Boolean getAvailabilityById(String id) {
        Optional<ProductAvailability> productAvailability = repository.findById(id);
        if (productAvailability.isPresent()) {
            return productAvailability.get().getAvailability();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @Override
    public ProductAvailability save(ProductAvailability productAvailability) {
        return repository.save(productAvailability);
    }
}
