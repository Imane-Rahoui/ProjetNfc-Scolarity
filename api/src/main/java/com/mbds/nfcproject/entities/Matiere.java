package com.mbds.nfcproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Matiere implements Serializable {

    private static final long serialVersionUID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matiereId;

    private String intitule;

    @JsonIgnore
    @OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
    private List<Cour> cours;

}
