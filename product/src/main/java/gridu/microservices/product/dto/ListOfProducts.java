package gridu.microservices.product.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class ListOfProducts {
    private Collection<Product> products;
}
