package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(Integer year);

    List<Whisky> findWhiskyByDistilleryNameAndAge(String name,
                                      Integer age);

    List<Whisky> findWhiskyByDistilleryRegion(String region);

}
