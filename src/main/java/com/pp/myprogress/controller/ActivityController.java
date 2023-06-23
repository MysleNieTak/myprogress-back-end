package com.pp.myprogress.controller;

import com.pp.myprogress.model.SportActivity;
import com.pp.myprogress.model.dto.CreateSportActivityRequest;
import com.pp.myprogress.model.dto.UpdateSportActivityRequest;
import com.pp.myprogress.model.dto.UpdateSportActivityResponse;
import com.pp.myprogress.service.SportActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// GET DELETE PATCH POST PUT


@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

    private SportActivityService sportActivityService;

    public ActivityController(SportActivityService sportActivityService){
        this.sportActivityService = sportActivityService;
    }

    // READ
    // Get list of all activities
    // http://localhost:8080/activity
    @GetMapping()
    public List<SportActivity> getSportActivityList(){
       log.info("List of sport activities has been requested.");
        return sportActivityService.getAll();
   }


    // READ
    // Get speed of the activity
    // http://localhost:8080/activity/activitySpeed?sId=3
    @GetMapping("/activitySpeed")
    public Double getSpeed(@RequestParam Long sId){
       log.info("Speed of activity with following id has been requested: {}", sId);
        return sportActivityService.getSpeedOfSportActivityWithId(sId);
    }

    // READ
    // Get the activity with the Id...
    // http://localhost:8080/activity?sportactivity=1
    @GetMapping("/activityWithId")
    public SportActivity getSportActivityWithId(@RequestParam Long sportActivityId){
        log.info("Sport activity with the following id has been requested: {}", sportActivityId);
        return sportActivityService.findById(sportActivityId);
    }

    //READ
    // http://localhost:8080/activity/1
    @GetMapping("/{id}")
    public SportActivity getSportActivityById(@PathVariable Long id){
        log.info("Sport activity with the following id has been requested: {}", id);
        return sportActivityService.findById(id);
    }


    // DELETE
    // http://localhost:8080/activity?id=1
    @DeleteMapping()
    public void deleteSportActivity(@RequestParam Long id){
        log.info("Delete sport activity with the following id has been requested: {}" , id );
        sportActivityService.delete(id);
    }

    // CREATE - POST
    // http://localhost:8080/activity
    @PostMapping()
    public void createSportActivity(@RequestBody CreateSportActivityRequest request){
        log.info("New sport activity creation has been requested:{}", request);
        sportActivityService.createSportActivity(request);

    }

    // UPDATE
    @PatchMapping("/{sportActivityId}")
    public UpdateSportActivityResponse updateSportActivityResponse
    (@PathVariable Long sportActivityId, @RequestBody UpdateSportActivityRequest request){
        log.info("Sport activity update has been requested :{}", sportActivityId, request);
        return sportActivityService.update(sportActivityId, request);
    }

}
