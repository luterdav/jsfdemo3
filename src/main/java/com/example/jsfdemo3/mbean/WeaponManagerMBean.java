package com.example.jsfdemo3.mbean;

import com.example.jsfdemo3.data.Weapon;
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
public class WeaponManagerMBean {

    private List<Weapon> weaponList;

    @Autowired
    private WeaponRepository repository;

    private Weapon selectedWeapon;

    @PostConstruct
    private void init() {
        loadAll();
        selectedWeapon = new Weapon();
    }

    public void save() {
        if (selectedWeapon.getId() == null) {
            repository.save(selectedWeapon);
        } else {
            repository.update(selectedWeapon);
        }
        loadAll();
        selectedWeapon = new Weapon();
    }

    public void delete(Long id) {
        repository.delete(id);
        loadAll();

    }

    public void selectOne(Weapon weapon) {
        selectedWeapon = weapon;

    }

    private void loadAll() {
        weaponList = repository.findAll();
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(Weapon selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }
}
