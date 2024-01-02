package com.etiya.dataAcces.concretes;

import com.etiya.dataAcces.abstracts.FuelRepository;
import com.etiya.entities.Fuel;

import java.util.Random;

public class FuelRepositoryHibernate implements FuelRepository {
    @Override
    public Fuel add(Fuel fuel) {
        Random random=new Random();
        fuel.setId(random.nextInt(1000));
        System.out.println("Fuel added to db by FuelRepositoryHibernate");
        return fuel;
    }
}
