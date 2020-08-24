package com.example.shiftmonitor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityRequest {

    private String description;
    private String status;
    private String actionTaken;
    private String recommended;
}
