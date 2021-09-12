package gridu.microservices.cloudgateaway.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FallBackController {

    @GetMapping("/productFallBack")
    public String productFallBack() {
        return "Product service doesn't work. Please, try again later";
    }

    @GetMapping("/catalogFallBack")
    public String catalogFallBack() {
        return "Catalog service doesn't work. Please, try again later";
    }

    @GetMapping("/inventoryFallBack")
    public String inventoryFallBack() {
        return "Inventory service doesn't work. Please, try again later";
    }

}
