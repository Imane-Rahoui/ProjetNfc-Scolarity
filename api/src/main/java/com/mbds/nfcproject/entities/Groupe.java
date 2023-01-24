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
public class Groupe implements Serializable {

    private static final long serialVersionUID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupeId;

    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER)
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER)
    private List<Cour> cours;

    public Groupe(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "groupeId=" + groupeId +
                ", nom='" + nom + '\'' +
                '}';
    }
}
