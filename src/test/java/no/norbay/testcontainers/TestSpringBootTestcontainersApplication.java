package no.norbay.testcontainers;

import org.springframework.boot.SpringApplication;

public class TestSpringBootTestcontainersApplication {

    public static void main(String[] args) {
        SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
