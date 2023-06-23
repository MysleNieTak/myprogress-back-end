package com.pp.myprogress.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSportActivityRequest {
    private String titleDTO;
    private double distanceInMetresDTO;
    private double timeInMinutesDTO;
    private String activityTypeDTO;

    private String howDoYouFeelDTO;
}
