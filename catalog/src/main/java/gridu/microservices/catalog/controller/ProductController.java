package gridu.microservices.catalog.controller;

import gridu.microservices.catalog.model.Product;
import gridu.microservices.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = service.getById(id);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<Collection<Product>> getProductsBySky(@PathVariable String sku) {
        Collection<Product> products = service.getBySku(sku);
        if (products == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        Collection<Product> products = service.getAll();
        if (products == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}