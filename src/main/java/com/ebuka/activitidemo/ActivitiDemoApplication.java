package com.ebuka.activitidemo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ActivitiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final RepositoryService repositoryService,
                           final RuntimeService runtimeService,
                           final TaskService taskService) {

        return strings -> {
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("buyerPays", "false");
            variables.put("sellerShips", "false");
            variables.put("userVerifies", "false");
            variables.put("sellerGetsPaid", "false");
            runtimeService.startProcessInstanceByKey("ulinzi-simple-process", variables);
        };
    }

}
