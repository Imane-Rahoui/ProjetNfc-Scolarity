package com.mbds.nfcproject.service;

import com.mbds.nfcproject.dto.InfosAbs;
import com.mbds.nfcproject.entities.Absence;
import com.mbds.nfcproject.entities.Cour;
import com.mbds.nfcproject.entities.Matiere;
import com.mbds.nfcproject.entities.Student;
import com.mbds.nfcproject.repositories.AbsenceRepository;
import com.mbds.nfcproject.repositories.CourRepository;
import com.mbds.nfcproject.repositories.MatiereRepository;
import com.mbds.nfcproject.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllServices {

    MatiereRepository matiereRepository;
    CourRepository courRepository;
    StudentRepository studentRepository;
    AbsenceRepository absenceRepository;

    public AllServices(MatiereRepository matiereRepository, CourRepository courRepository, StudentRepository studentRepository, AbsenceRepository absenceRepository) {
        this.matiereRepository = matiereRepository;
        this.courRepository = courRepository;
        this.studentRepository = studentRepository;
        this.absenceRepository = absenceRepository;
    }

    public Student searchStudent(String matricule) {
        return studentRepository.findStudentByMatricule(matricule);
    }

    public List<Absence> searchAbsencesOfStudent( String matricule) {
        Student s=searchStudent(matricule);
        if(s==null)
            throw new RuntimeException("student doesn't exist");
        return absenceRepository.findAbsenceByStudent(s);
    }

    public Absence addAbsence(InfosAbs i) {
        Student s=searchStudent(i.getMatricule());
        if(s==null)
            throw new RuntimeException("student doesn't exist");
        Matiere m=matiereRepository.findMatiereByIntitule(i.getIntitule());

        if(m==null)
            throw new RuntimeException("matiere doesn't exist");
        Cour c=courRepository.findCourByMatiereAndGroupe(m,s.getGroupe());

        if(c==null)
            throw new RuntimeException("cour doesn't exist");

        return absenceRepository.save(new Absence(null,i.getJustifie(),s,c));
    }

}
