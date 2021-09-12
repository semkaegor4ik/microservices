package gridu.microservices.catalog.service;

import gridu.microservices.catalog.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(String id);

    Optional<Collection<Product>> getBySku(String sku);
}