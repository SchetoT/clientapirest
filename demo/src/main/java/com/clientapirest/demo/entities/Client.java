package com.clientapirest.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="clients")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Client {
    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Getter @Setter private String name;

    @Getter @Setter private String lastname;

    @Getter @Setter private Integer dni;

}
