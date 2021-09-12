package gridu.microservices.product.controller;

import gridu.microservices.product.dto.Product;
import gridu.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/sku/{sku}")
    public ResponseEntity<List<Product>> getAvailabileProducts(@PathVariable String sku) {
        Optional<List<Product>> optionalProducts =  productService.getAvailabileProducts(sku);
        return optionalProducts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getAvailabileProduct(@PathVariable String id) {
        Optional<Product> optionalProduct =  productService.getAvailabileProduct(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
