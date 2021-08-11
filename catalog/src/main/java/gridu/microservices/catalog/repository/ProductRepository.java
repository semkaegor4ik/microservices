package gridu.microservices.catalog.repository;

import gridu.microservices.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Collection<Product> getProductsBySku(String sku);
}