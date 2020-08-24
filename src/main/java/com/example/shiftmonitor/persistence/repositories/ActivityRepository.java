package com.example.shiftmonitor.persistence.repositories;

import com.example.shiftmonitor.persistence.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
