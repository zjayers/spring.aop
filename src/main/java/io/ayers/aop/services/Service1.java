package io.ayers.aop.services;

import io.ayers.aop.repositories.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Autowired
    private Dao1 dao1;

    public String retrieveDataFromRepository() {
        return dao1.retrieveData();
    }

}
