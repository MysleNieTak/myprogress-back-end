package com.pp.myprogress.component;

import com.pp.myprogress.exception.IllegalValueException;
import com.pp.myprogress.model.SportActivity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportActivityResultsComponentTest {
private final SportActivityResultsComponent sportActivityResultsComponent = new SportActivityResultsComponent();
    @Test
    @DisplayName("Calculates the speed of the activity correctly, if the object - sportActivity - contains the values of: distance and time")
    void testSpeedCalculation(){

        //GIVEN
        final var sportActivity = new SportActivity(null, null, 1000.0, null, 25.0,null, null, null);

        //THEN
        final var result = sportActivityResultsComponent.calculateSpeed(sportActivity);

        //ASSERT
        assertEquals(1000/25, result);
    }

    @Test
    @DisplayName("Shows InvalidArgumentException, if the object - sportActivity - does not contain the values of: distance or time")
    void testSpeedCalculationThrowsExceptionOnNull(){

        //GIVEN
        final var sportActivity = new SportActivity(null, null, null, null, null, null, null, null);

        //THEN ASSERT
        assertThrows(IllegalValueException.class, () ->{
            sportActivityResultsComponent.calculateSpeed(sportActivity);
        });


    }

}