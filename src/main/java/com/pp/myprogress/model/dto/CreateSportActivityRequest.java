package com.pp.myprogress.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

// Data Transfer Object
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSportActivityRequest {
    private String titleDTO;
    private LocalDate dateDTO;
    private Double distanceInMetresDTO;
    private Double timeInMinutesDTO;

    private String userNameDTO;
    private String activityTypeDTO;
    private String howDoYouFeelDTO;
}
