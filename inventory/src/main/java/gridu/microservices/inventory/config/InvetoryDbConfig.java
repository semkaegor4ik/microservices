package gridu.microservices.inventory.config;

import gridu.microservices.inventory.model.ProductAvailability;
import gridu.microservices.inventory.service.ProductAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class InvetoryDbConfig {
    private final ProductAvailabilityService productAvailabilityService;

    @Value(value = "${file.csv.data.set.path}")
    private String filePath;

    @EventListener(value = ContextRefreshedEvent.class)
    public void fillInventoryTable() throws Exception {
        try (Scanner scanner = new Scanner(new File(filePath));) {
            while (scanner.hasNextLine()) {
                String id = getRecordFromLine(scanner.nextLine()).get(0);
                if (id.length()==32) {
                    productAvailabilityService.save(new ProductAvailability(id, getRandomAvailability()));
                }
            }
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    private boolean getRandomAvailability() {
        return Math.random() > 0.3;
    }
}
