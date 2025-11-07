package org.example.conferenceservice.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Keynote {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;

}