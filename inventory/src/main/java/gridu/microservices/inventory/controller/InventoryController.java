package gridu.microservices.inventory.controller;

import gridu.microservices.inventory.service.ProductAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final ProductAvailabilityService service;

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(service.getAvailabilityById(id));
    }
}
