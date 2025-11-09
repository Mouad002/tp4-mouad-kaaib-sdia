package org.example.conferenceservice;

import org.example.conferenceservice.entity.Conference;
import org.example.conferenceservice.entity.ConferenceType;
import org.example.conferenceservice.entity.Keynote;
import org.example.conferenceservice.feignclient.KeynoteRestClient;
import org.example.conferenceservice.repository.ConferenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ConferenceRepository conferenceRepository, KeynoteRestClient keynoteRestClient) {
        return args -> {
            Collection<Keynote> keynotes = keynoteRestClient.findAllKeynotes().getContent();
            keynotes.stream().forEach(keynote -> {
                Conference conference = Conference.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDateTime.now())
                        .duration(new Random().nextInt(1000))
                        .title("conference de %s".formatted(keynote.getFirstName()))
                        .keynoteId(keynote.getId())
                        .type(Math.random() > 0.5 ? ConferenceType.ACADEMIC : ConferenceType.COMMERCIAL)
                        .inscriptionNumber(new Random().nextInt(1000))
                        .score(Math.random()*100)
                        .build();
                conferenceRepository.save(conference);
            });
            System.out.println("✅ Sample keynotes inserted.");
        };
    }
}
