package com.mbds.nfcproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Cour implements Serializable {

    private static final long serialVersionUID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courId;

    private Date jour;

    private int volume;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "groupeId")
    private Groupe groupe;

    @ManyToOne
    @JoinColumn(name = "matiereId")
    private Matiere matiere;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "absenceId")
    private Absence absence;
}
