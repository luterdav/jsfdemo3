package com.example.jsfdemo3.repository.impl;

import com.example.jsfdemo3.data.Robot;
import com.example.jsfdemo3.repository.RobotRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RobotRepositoryImpl extends CoreCrudRepositoryImpl<Robot> implements RobotRepository {
    @Override
    public Class getManagedClass() {
        return Robot.class;
    }
}
