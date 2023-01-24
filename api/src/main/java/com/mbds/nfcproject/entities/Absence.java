package com.mbds.nfcproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Absence implements Serializable {

    private static final long serialVersionUID = 4941969918734551096L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long absenceId;

    private Boolean justifie; // true si yep

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "student_id" )
    private Student student;

    @ManyToOne
    @JoinColumn(name = "cour_id")
    private Cour cour;
}
