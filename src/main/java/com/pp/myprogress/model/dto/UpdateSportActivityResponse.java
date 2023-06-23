package com.pp.myprogress.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSportActivityResponse {
    private String titleDTO;
    private Long identifierDTO;
    private LocalDate dateDTO;
    private double distanceInMetresDTO;
    private double timeInMinutesDTO;
    private String userNameDTO;
    private String activityTypeDTO;
    private String howDoYouFeelDTO;
}
