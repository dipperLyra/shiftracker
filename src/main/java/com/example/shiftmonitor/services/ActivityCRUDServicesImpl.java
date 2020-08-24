package com.example.shiftmonitor.services;

import com.example.shiftmonitor.dto.ActivityRequest;
import com.example.shiftmonitor.dto.ActivityResponse;
import com.example.shiftmonitor.persistence.entities.Activity;
import com.example.shiftmonitor.persistence.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityCRUDServicesImpl implements ActivityCRUDServices{

    @Autowired
    ActivityRepository repository;

    public Activity newActivity(ActivityRequest request) {
        Activity activity = new Activity(
                request.getDescription(),
                request.getStatus(),
                request.getActionTaken(),
                request.getRecommended()
        );
        return repository.save(activity);

    }

    public ActivityResponse showActivity(Long id) {
        Optional<Activity> activity = repository.findById(id);
        return activity.map(value -> new ActivityResponse(
                value.getId(),
                value.getDescription(),
                value.getStatus(),
                value.getActionTaken(),
                value.getRecommended()
        )).orElse(null);
    }

    public List<ActivityResponse> listActivities() {
        List<ActivityResponse> activityResponses = new ArrayList<>();
        ActivityResponse activityResponse = new ActivityResponse();

        List<Activity> activities = repository.findAll();

        activities.forEach(activity -> {
            activityResponse.setActionTaken(activity.getActionTaken());
            activityResponse.setDescription(activity.getDescription());
            activityResponse.setId(activity.getId());
            activityResponse.setRecommended(activity.getRecommended());
            activityResponse.setStatus(activity.getStatus());

            activityResponses.add(activityResponse);
        });

        return activityResponses;
    }

    public String updateActivity(Long id, ActivityRequest request) {
        Optional<Activity> activityOld = repository.findById(id);

        if (activityOld.isPresent()) {
            Activity activity = activityOld.get();

            activity.setActionTaken(request.getActionTaken());
            activity.setDescription(request.getDescription());
            activity.setActionTaken(request.getActionTaken());
            activity.setRecommended(request.getRecommended());

            try {
                repository.save(activity);

            } catch (Exception e) {
                return "Couldn't update: " + e;
            }
        }
        return "Updated record";
    }

    public String deleteActivity(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            return "Couldn't perform operation due to: " + e;
        }
        return "Record deleted... bye bye forever ooh!!";
    }
}


