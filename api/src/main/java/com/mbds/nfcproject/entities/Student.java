package com.mbds.nfcproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student implements Serializable {

    private static final long serialVersionUID = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String matricule;

    private String firstName;

    private String lastName;

    private String email;

    private Date dateDeNaissance;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Absence> absences;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", matricule='" + matricule + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", groupe=" + groupe.getNom() +
                '}';
    }
}
