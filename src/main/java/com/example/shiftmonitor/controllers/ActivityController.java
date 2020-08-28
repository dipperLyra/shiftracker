package com.example.shiftmonitor.controllers;

import com.example.shiftmonitor.dto.ActivityRequest;
import com.example.shiftmonitor.dto.ActivityResponse;
import com.example.shiftmonitor.services.ActivityCRUDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ActivityController {

    @Autowired
    ActivityCRUDServices services;
    @Autowired
    Helper helper;

    @PostMapping("/activity")
    public String recordActivity(@RequestBody ActivityRequest request) {
        if (!helper.checkMandatoryFields(request)) {
            return "Please fill mandatory fields";
        }
        boolean action = helper.checkActionTaken(request.getActionTaken());
        boolean status = helper.checkActivityStatus(request.getStatus());
        if (status && action) {
            services.newActivity(request);
            return "successful";
        }
        return "unsuccessful";
    }

    @GetMapping("/activity/{id}")
    public ActivityResponse viewActivity(@PathVariable Long id) {
        return services.showActivity(id);
    }

    @GetMapping("/activity")
    public List<ActivityResponse> listActivity() {
        return services.listActivities();
    }

    @PutMapping("/activity/{id}")
    public String updateActivity(@PathVariable Long id, @RequestBody ActivityRequest request) {
        if (!helper.checkMandatoryFields(request)) {
            return "Please fill mandatory fields";
        }
        boolean action = helper.checkActionTaken(request.getActionTaken());
        boolean status = helper.checkActivityStatus(request.getStatus());

        if (status && action) {
            return services.updateActivity(id, request);
        }
        return "unsuccessful";
    }

    @DeleteMapping("/activity/{id}")
    public String removeActivity(@PathVariable Long id) {

        return services.deleteActivity(id);
    }

}
