package org.example.keynoteserivce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Keynote {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String function;

}
