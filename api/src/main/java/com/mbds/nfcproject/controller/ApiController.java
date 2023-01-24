package com.mbds.nfcproject.controller;

import com.mbds.nfcproject.dto.InfosAbs;
import com.mbds.nfcproject.entities.Absence;
import com.mbds.nfcproject.entities.Student;
import com.mbds.nfcproject.repositories.StudentRepository;
import com.mbds.nfcproject.service.AllServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    AllServices allServices;

    public ApiController(AllServices allServices) {
        this.allServices = allServices;
    }

    @GetMapping("/searchStudent")
    public ResponseEntity<Student> searchStudent(@RequestParam String matricule) {
        return new ResponseEntity<Student>(allServices.searchStudent(matricule), HttpStatus.OK);

    }

    @GetMapping("/searchAbsStu")
    public ResponseEntity<List<Absence>> searchAbsencesOfStudent(@RequestParam String matricule) {
        return new ResponseEntity<List<Absence>>(allServices.searchAbsencesOfStudent(matricule), HttpStatus.OK);
    }

    @PostMapping ("/addAbs")
    public ResponseEntity<Absence> addAbsence(@RequestBody InfosAbs i) {
        return new ResponseEntity<Absence>(allServices.addAbsence(i), HttpStatus.CREATED);

    }
}
