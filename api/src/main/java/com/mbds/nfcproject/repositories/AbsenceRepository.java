package com.mbds.nfcproject.repositories;

import com.mbds.nfcproject.entities.Absence;
import com.mbds.nfcproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AbsenceRepository extends JpaRepository<Absence,Long> {

    List<Absence> findAbsenceByStudent(Student s);

}