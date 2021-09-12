package gridu.microservices.catalog.controller;

import gridu.microservices.catalog.model.Product;
import gridu.microservices.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Optional<Product> product = service.getById(id);
        if (product.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found");
        }
        return ResponseEntity.ok(product.get());
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<Collection<Product>> getProductsBySky(@PathVariable String sku) {
        Optional<Collection<Product>> products = service.getBySku(sku);
        if (products.isEmpty() || products.get().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Products Not Found");
        }
        return ResponseEntity.ok(products.get());
    }
}