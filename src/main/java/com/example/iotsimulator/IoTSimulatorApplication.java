package com.example.iotsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IoTSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IoTSimulatorApplication.class, args);
    }

}
