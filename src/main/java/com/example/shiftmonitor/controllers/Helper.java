package com.example.shiftmonitor.controllers;

import com.example.shiftmonitor.dto.ActivityRequest;
import org.springframework.stereotype.Service;

@Service
public class Helper {

    public boolean checkActionTaken(String actionSupplied) {
        if (actionSupplied == null) return false;
        String[] actionTaken = {"emergency", "customer call", "observation made", "job done"};
        String actionSuppliedClean = actionSupplied.toLowerCase().strip();

        for (String s : actionTaken) {
            if (actionSuppliedClean.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkActivityStatus(String statusSupplied) {
        if (statusSupplied == null) return false;
        String[] status = {"okay", "not okay"};
        String statusSuppliedClean = statusSupplied.toLowerCase().strip();

        for (String s : status) {
            if (statusSuppliedClean.equals(s)){
                return true;
            }
        }
        return false;
    }

    public boolean checkMandatoryFields(ActivityRequest request) {
        if (
                request.getActionTaken() != null &&
                request.getStatus() != null &&
                request.getDescription() != null
        )
        {
            if(request.getActionTaken().isEmpty()) return false;
            if (request.getDescription().isEmpty()) return false;
            return !request.getStatus().isEmpty();
        }

        return true;
    }
}
