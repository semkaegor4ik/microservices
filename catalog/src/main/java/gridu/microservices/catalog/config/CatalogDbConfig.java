package gridu.microservices.catalog.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
@Setter
public class CatalogDbConfig {
    @Value(value = "${spring.datasource.driverClassName}")
    private String driverDB;

    @Value(value = "${spring.datasource.url}")
    private String urlDB;

    @Value(value = "${spring.datasource.password}")
    private String passwordDb;

    @Value(value = "${spring.datasource.username}")
    private String userDB;

    @Value(value = "${file.csv.data.set.path}")
    private String filePath;

    @EventListener(value = ContextRefreshedEvent.class)
    public void creatrProductTable() throws Exception {
        Class.forName(driverDB);
        Connection connection = DriverManager.getConnection(urlDB, userDB, passwordDb);
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE PRODUCT AS SELECT * FROM CSVREAD('" + filePath + "');");

        statement.close();
    }
}
