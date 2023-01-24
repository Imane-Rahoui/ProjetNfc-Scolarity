package com.mbds.nfcproject;

import com.mbds.nfcproject.entities.*;
import com.mbds.nfcproject.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class NfcProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NfcProjectApplication.class, args);
    }


    @Bean
    CommandLineRunner start(StudentRepository studentRepository,
                            GroupeRepository groupeRepository,
                            MatiereRepository matiereRepository,
                            CourRepository coursRepository,
                            AbsenceRepository absenceRepository
                            ) {
        System.out.println("Holla");
        return args -> {
            Groupe g = groupeRepository.save(new Groupe("G1"));
            System.out.println(g.getNom());
            Student s=studentRepository.save(new Student(null, "AAAA11", "Imane", "Rahoui", "imi@gmail.com", new Date(), g,null));
            studentRepository.save(new Student(null, "AAAA22", "Touria", "Kassimi", "touta@gmail.com", new Date(), g,null));
            studentRepository.save(new Student(null, "AAAA33", "Amine", "Jsp", "aminu@gmail.com", new Date(), g,null));
            studentRepository.findAll().forEach(
                    c -> {
                        System.out.println(c.toString());
                    }
            );
            Matiere m=matiereRepository.save(new Matiere(null,"J2EE",null));
            matiereRepository.save(new Matiere(null,"DATA MINING",null));
            Cour c=coursRepository.save(new Cour(null,new Date(),2,g,m,null));
            absenceRepository.save(new Absence(null,Boolean.FALSE,s,c));

        };
    }


}
