package com.diaz.egoist_engine_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "arcs")
public class Arc {

    @Id
    @Column(name = "arc_id")
    private Integer arcId;

    @Column(name = "arc_name")
    private String arcName;

}
