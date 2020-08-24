package com.example.shiftmonitor.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;
    private String status;
    private String actionTaken;
    private String recommended;

    public Activity(String description, String status, String actionTaken, String recommended) {
        this.description = description;
        this.status = status;
        this.actionTaken = actionTaken;
        this.recommended = recommended;
    }

}
