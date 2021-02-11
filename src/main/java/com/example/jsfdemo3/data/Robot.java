package com.example.jsfdemo3.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "prime_robot")
public class Robot extends AbstractEntity {

    @NotEmpty(message = "{name.not.null}")
    @Column
    private String name;

    @NotEmpty(message = "{type.not.null}")
    @Column
    private String type;

    @NotNull(message = "{weapon.not.null}")
    @JoinColumn(name = "id")
    private Weapon weapon;

    public Robot() {
    }

    public Robot(Long id, Date createdDate, Date lastModifiedDate, String name, String type, Weapon weapon) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.type = type;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
