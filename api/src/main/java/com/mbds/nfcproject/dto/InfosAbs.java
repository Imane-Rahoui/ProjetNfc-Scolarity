package com.mbds.nfcproject.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InfosAbs {

    private String intitule;
    private String matricule;
    private Boolean justifie;
}
