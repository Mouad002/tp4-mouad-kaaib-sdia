package org.example.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    private String id;

    private LocalDateTime date;
    private String test;
    private int note;

    @ManyToOne
    private Conference conference;
}

