package com.example.shiftmonitor.controllers;

import com.example.shiftmonitor.dto.ActivityRequest;
import com.example.shiftmonitor.dto.ActivityResponse;
import com.example.shiftmonitor.persistence.entities.Activity;
import com.example.shiftmonitor.services.ActivityCRUDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1")
public class ActivityController {

    @Autowired
    ActivityCRUDServices services;

    @PostMapping("/activity")
    public Activity recordActivity(@RequestBody ActivityRequest request) {
         return services.newActivity(request);
    }

    @GetMapping("/activity/{id}")
    public ActivityResponse viewActivity(@PathVariable Long id) {
        return services.showActivity(id);
    }

    @GetMapping("/activity/")
    public List<ActivityResponse> listActivity() {
        return services.listActivities();
    }

    @PutMapping("/activity/{id}")
    public String updateActivity(@PathVariable Long id, @RequestBody ActivityRequest request) {
        return services.updateActivity(id, request);
    }

}
