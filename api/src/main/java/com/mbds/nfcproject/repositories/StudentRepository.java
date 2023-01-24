package com.mbds.nfcproject.repositories;

import com.mbds.nfcproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentByMatricule(String matricule);
}
