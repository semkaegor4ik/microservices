package gridu.microservices.inventory.db;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class DBConfig {

    @EventListener(value = ContextRefreshedEvent.class)
    public void crateAndFillTable() {
        RestTemplate restTemplate = new RestTemplate();
        Random random = new Random();

        restTemplate.getForObject("local")
    }
}
