package gridu.microservices.inventory.repository;

import gridu.microservices.inventory.model.ProductAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAvailabilityRepository extends JpaRepository<ProductAvailability, String> {
}
