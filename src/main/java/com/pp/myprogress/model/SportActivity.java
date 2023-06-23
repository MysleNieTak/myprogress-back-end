package com.pp.myprogress.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Builder
@Entity
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class SportActivity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private LocalDate date;
    @Setter
    @Getter
    private Double distanceInMetres;

    @Setter
    @Getter
    private Double timeInMinutes;

    @Setter
    @Getter
    private String userName;
    @Setter
    @Getter
    private String activityType;

    // make activityType ENUM -> swimming / walk / run -> different kcal burn
    @Setter
    @Getter
    private String howDoYouFeel;


    //private double kcal - depends on:

    // - activity type
    //   walk: 250 kcal / 1 h etc...
    // - weight of the user
    // - timeInMinutes


    // METHODS

    // averageSpeed
    // kcalBurnt
    // averageBurnt

    //
    // mood, well-being
    // observations

}


