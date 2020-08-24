package com.example.shiftmonitor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityResponse {
    private Long id;
    private String description;
    private String status;
    private String actionTaken;
    private String recommended;

    public ActivityResponse(Long id, String description, String status, String actionTaken, String recommended) {
        id = id;
        description = description;
        status = status;
        actionTaken = actionTaken;
        recommended = recommended;
    }
    public ActivityResponse(String description, String status, String actionTaken, String recommended) {
        description = description;
        status = status;
        actionTaken = actionTaken;
        recommended = recommended;
    }
}
