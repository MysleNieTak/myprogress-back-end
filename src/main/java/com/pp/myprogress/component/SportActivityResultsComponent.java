package com.pp.myprogress.component;

import com.pp.myprogress.exception.IllegalValueException;
import com.pp.myprogress.model.SportActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SportActivityResultsComponent {

    public Double calculateSpeed (SportActivity sportActivity){
        if(sportActivity.getDistanceInMetres()==null || sportActivity.getTimeInMinutes()==null){
            throw new IllegalValueException("Distance or time is null");
        }

    return sportActivity.getDistanceInMetres()/ sportActivity.getTimeInMinutes();
    }






   // public int calculateKcalBurnt(SportActivity sportActivity){

   //


}
