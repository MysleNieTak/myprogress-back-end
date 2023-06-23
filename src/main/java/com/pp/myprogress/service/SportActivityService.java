package com.pp.myprogress.service;

import com.pp.myprogress.component.SportActivityResultsComponent;
import com.pp.myprogress.model.SportActivity;
import com.pp.myprogress.model.dto.CreateSportActivityRequest;
import com.pp.myprogress.model.dto.UpdateSportActivityRequest;
import com.pp.myprogress.model.dto.UpdateSportActivityResponse;
import com.pp.myprogress.repository.ActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SportActivityService {


    // repository
    private final ActivityRepository activityRepository;
    // component
    private SportActivityResultsComponent activitySpeedComponent;

    public SportActivityService(ActivityRepository activityRepository, SportActivityResultsComponent activitySpeedComponent) {
        this.activityRepository = activityRepository;
        this.activitySpeedComponent = activitySpeedComponent;
    }


    public List<SportActivity> getAll() {
        return activityRepository.findAll();
    }

    public void delete(Long sportActivityId) {
        activityRepository.deleteById(sportActivityId);
    }

    public Double getSpeedOfSportActivityWithId(Long sportActivityId){

       // Optional<SportActivity> sportActivityOptional = iActivityRepository.findById(sportActivityId);
       // if(sportActivityOptional.isPresent()){
       //     SportActivity sportActivity = sportActivityOptional.get();
       //     return activitySpeedComponent.calculateSpeed(sportActivity);
       // }
       // throw new EntityNotFoundException("Sport activity with id:" + id + " not found.");

        SportActivity sportActivity = activityRepository.findById(sportActivityId)
                .orElseThrow(()  -> new EntityNotFoundException("Sport activity with following id not found: " + sportActivityId));
        return activitySpeedComponent.calculateSpeed(sportActivity);
    }

    public SportActivity findById(Long sportActivityId) {
        return activityRepository.findById(sportActivityId)
                .orElseThrow(()  -> new EntityNotFoundException("Sport activity with following id not found: " + sportActivityId));

    }

    public void createSportActivity(CreateSportActivityRequest request) {
        SportActivity sportActivity = SportActivity.builder()
                .title(request.getTitleDTO())
                .activityType(request.getActivityTypeDTO())
                .date(request.getDateDTO())
                .distanceInMetres(request.getDistanceInMetresDTO())
                .timeInMinutes(request.getTimeInMinutesDTO())
                .howDoYouFeel(request.getHowDoYouFeelDTO())
                .userName(request.getUserNameDTO())
                .build();
        activityRepository.save(sportActivity);
    }


    public UpdateSportActivityResponse update(Long sportActivityId, UpdateSportActivityRequest request) {

        // find

        SportActivity sportActivity = activityRepository.findById(sportActivityId)
                .orElseThrow(()  -> new EntityNotFoundException("Sport activity with following id not found: " + sportActivityId));


        // update

        if(request.getActivityTypeDTO() != null){
            sportActivity.setActivityType((request.getActivityTypeDTO()));
        }
        if(request.getTitleDTO() != null){
            sportActivity.setTitle(request.getTitleDTO());
        }
        if(request.getDistanceInMetresDTO() != 0){
            sportActivity.setDistanceInMetres((request.getDistanceInMetresDTO()));
        }
        if(request.getTimeInMinutesDTO() != 0){
            sportActivity.setTimeInMinutes((request.getTimeInMinutesDTO()));
        }
        if(request.getHowDoYouFeelDTO() != null){
            sportActivity.setHowDoYouFeel((request.getHowDoYouFeelDTO()));
        }

        // save updated object

        sportActivity = activityRepository.save(sportActivity);

        //return response (not the entity)

        return sportActivityToSportActivityResponse(sportActivity);
    }

    private UpdateSportActivityResponse sportActivityToSportActivityResponse(SportActivity sportActivity){
        return new UpdateSportActivityResponse(
                sportActivity.getTitle(),
                sportActivity.getId(),
                sportActivity.getDate(),
                sportActivity.getDistanceInMetres(),
                sportActivity.getTimeInMinutes(),
                sportActivity.getUserName(),
                sportActivity.getActivityType(),
                sportActivity.getHowDoYouFeel()
        );
    }
}