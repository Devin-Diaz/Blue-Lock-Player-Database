package com.diaz.egoist_engine_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "height")
    private String height;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

}
