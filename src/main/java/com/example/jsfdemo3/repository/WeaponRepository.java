package com.example.jsfdemo3.repository;

import com.example.jsfdemo3.data.Weapon;

public interface WeaponRepository extends CoreCrudRepository<Weapon> {
    Weapon findByName(String name);
}
