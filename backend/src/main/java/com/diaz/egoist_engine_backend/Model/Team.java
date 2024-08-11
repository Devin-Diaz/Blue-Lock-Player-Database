package com.diaz.egoist_engine_backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "arc_id")
    private Arc arc;

}
