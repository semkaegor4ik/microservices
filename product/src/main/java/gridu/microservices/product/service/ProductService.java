package gridu.microservices.product.service;

import gridu.microservices.product.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getAvailabileProduct(String id);

    Optional<List<Product>> getAvailabileProducts(String sku);
}
