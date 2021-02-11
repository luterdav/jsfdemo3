package com.example.jsfdemo3.mbean;

import com.example.jsfdemo3.data.Weapon;
import com.example.jsfdemo3.messages.AbstractMessages;
import com.example.jsfdemo3.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named
@ViewScoped
public class WeaponManagerMBean extends AbstractMessages {

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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, AbstractMessages.message, null));
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
