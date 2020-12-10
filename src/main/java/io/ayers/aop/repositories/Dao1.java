package io.ayers.aop.repositories;

import io.ayers.aop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveData() {
        return "Dao1";
    }

}
