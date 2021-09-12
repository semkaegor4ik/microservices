package gridu.microservices.inventory.service;

import gridu.microservices.inventory.model.ProductAvailability;

public interface ProductAvailabilityService {
    Boolean getAvailabilityById(String id);

    ProductAvailability save(ProductAvailability productAvailability);
}
