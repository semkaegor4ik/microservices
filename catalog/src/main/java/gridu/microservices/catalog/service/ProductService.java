package gridu.microservices.catalog.service;

import gridu.microservices.catalog.model.Product;

import java.util.Collection;

public interface ProductService {
    Product getById(String id);

    Collection<Product> getBySku(String sku);

    Collection<Product> getAll();
}