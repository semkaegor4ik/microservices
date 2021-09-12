package gridu.microservices.catalog.service.impl;

import gridu.microservices.catalog.model.Product;
import gridu.microservices.catalog.repository.ProductRepository;
import gridu.microservices.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Optional<Product> getById(String id) {

        return repository.findById(id);
    }

    @Override
    public Optional<Collection<Product>> getBySku(String sku) {
        return Optional.ofNullable(repository.getProductsBySku(sku));
    }
}