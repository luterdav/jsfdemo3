package com.example.jsfdemo3.mbean;

import com.example.jsfdemo3.data.Weapon;
import com.example.jsfdemo3.data.Robot;
import com.example.jsfdemo3.repository.RobotRepository;
import com.example.jsfdemo3.repository.WeaponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named
@ViewScoped
public class RobotManagerMBean {
    private List<Robot> robotList;
    private List<Weapon> weaponList;
    @Autowired
    private RobotRepository repository;

    @Autowired
    private WeaponRepository weaponRepository;

    private Robot selectedRobot;

    @PostConstruct
    private void init() {
        loadAll();
        selectedRobot = new Robot();
        weaponList = weaponRepository.findAll();
    }

    public void save() {
        if (selectedRobot.getId() == null) {
            repository.save(selectedRobot);
        } else {
            repository.update(selectedRobot);
        }
        loadAll();
        selectedRobot = new Robot();
    }

    public void delete(Long id) {
        repository.delete(id);
        loadAll();

    }

    public void selectOne(Robot weapon) {
        selectedRobot = weapon;

    }

    private void loadAll() {
        robotList = repository.findAll();
    }

    public List<Robot> getRobotList() {
        return robotList;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }

    public Robot getSelectedRobot() {
        return selectedRobot;
    }

    public void setSelectedRobot(Robot selectedRobot) {
        this.selectedRobot = selectedRobot;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }
}

