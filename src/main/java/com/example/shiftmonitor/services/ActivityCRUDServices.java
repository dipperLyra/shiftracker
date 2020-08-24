package com.example.shiftmonitor.services;

import com.example.shiftmonitor.dto.ActivityRequest;
import com.example.shiftmonitor.dto.ActivityResponse;
import com.example.shiftmonitor.persistence.entities.Activity;

import java.util.List;

public interface ActivityCRUDServices {
    public Activity newActivity(ActivityRequest request);
    public ActivityResponse showActivity(Long id);
    public List<ActivityResponse> listActivities();
    public String updateActivity(Long id, ActivityRequest request);
    public String deleteActivity(Long id);
}
