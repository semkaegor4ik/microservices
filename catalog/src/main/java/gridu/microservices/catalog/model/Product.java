package gridu.microservices.catalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
@NoArgsConstructor
public class Product {
    @Id
    private String uniqId;

    private String sku;

    private String nameTitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double listPrice;

    private Double salePrice;

    private String category;

    private String categoryTree;

    private String averageProductRating;

    @Column(columnDefinition = "TEXT")
    private String productUrl;

    @Column(columnDefinition = "TEXT")
    private String productImageUrls;

    private String brand;

    private Integer totalNumberReviews;

    @Column(columnDefinition = "TEXT")
    private String reviews;
}
