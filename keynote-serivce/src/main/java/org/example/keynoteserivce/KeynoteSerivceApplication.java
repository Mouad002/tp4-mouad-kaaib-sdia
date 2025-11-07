package org.example.keynoteserivce;

import org.example.keynoteserivce.entities.Keynote;
import org.example.keynoteserivce.repository.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class KeynoteSerivceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteSerivceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(KeynoteRepository keynoteRepository) {
        return args -> {
            Keynote k1 = Keynote.builder()
                    .id("K1")
                    .firstName("Alice")
                    .lastName("Johnson")
                    .email("alice.johnson@example.com")
                    .function("Professor of AI")
                    .build();

            Keynote k2 = Keynote.builder()
                    .id("K2")
                    .firstName("Bob")
                    .lastName("Smith")
                    .email("bob.smith@example.com")
                    .function("CTO at FutureTech")
                    .build();

            keynoteRepository.saveAll(List.of(k1, k2));
            System.out.println("✅ Sample keynotes inserted.");

        };
    }
}
