package gridu.microservices.inventory.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class ProductAvailability {
    @Id
    private String uniqId;

    private Integer number;
}
