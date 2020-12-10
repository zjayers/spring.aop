package io.ayers.aop.services;

import io.ayers.aop.repositories.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    @Autowired
    private Dao2 dao2;

    public String retrieveDataFromRepository() {
        return dao2.retrieveData();
    }

}
