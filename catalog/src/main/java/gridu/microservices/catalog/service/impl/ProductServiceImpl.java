package gridu.microservices.catalog.service.impl;

import gridu.microservices.catalog.model.Product;
import gridu.microservices.catalog.repository.ProductRepository;
import gridu.microservices.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product getById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Collection<Product> getBySku(String sku) {
        return repository.getProductsBySku(sku);
    }

    @Override
    public Collection<Product> getAll() {
        return repository.findAll();
    }
}