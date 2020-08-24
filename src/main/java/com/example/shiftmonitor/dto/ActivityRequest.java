package com.example.shiftmonitor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityRequest {

    private String description;
    private String status;
    private String actionTaken;
    private String recommended;
}
