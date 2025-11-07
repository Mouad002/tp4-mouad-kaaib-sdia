package org.example.keynoteserivce.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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
