package org.example.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {

    @Id
    private String id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ConferenceType type;

    private LocalDateTime date;
    private int duration;
    private int inscriptionNumber;
    private double score;

    @OneToMany(mappedBy = "conference")
    private List<Review> reviews;

    @Transient
    private Keynote keynote;
}