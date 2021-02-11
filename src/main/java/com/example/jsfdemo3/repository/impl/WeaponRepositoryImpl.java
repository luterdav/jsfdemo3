package com.example.jsfdemo3.repository.impl;

import com.example.jsfdemo3.data.Weapon;
import com.example.jsfdemo3.repository.WeaponRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class WeaponRepositoryImpl extends CoreCrudRepositoryImpl<Weapon> implements WeaponRepository {
    @Override
    public Class getManagedClass() {
        return Weapon.class;
    }

    @Override
    public Weapon findByName(String name) {
        Query query = em.createQuery("select n from " + getManagedClass().getSimpleName() + " n where n.name=:name");
        query.setParameter("name", name);
        return (Weapon) query.getSingleResult();
    }
}
