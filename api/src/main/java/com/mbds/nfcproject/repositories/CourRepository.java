package com.mbds.nfcproject.repositories;

import com.mbds.nfcproject.entities.Cour;
import com.mbds.nfcproject.entities.Groupe;
import com.mbds.nfcproject.entities.Matiere;
import com.mbds.nfcproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourRepository extends JpaRepository<Cour,Long> {

    Cour findCourByMatiereAndGroupe(Matiere m, Groupe g);

}
