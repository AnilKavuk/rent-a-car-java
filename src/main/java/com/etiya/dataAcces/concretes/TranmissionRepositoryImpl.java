package com.etiya.dataAcces.concretes;

import com.etiya.dataAcces.abstracts.TranmissionRepository;
import com.etiya.entities.Tranmission;

import java.util.Random;

public class TranmissionRepositoryImpl implements TranmissionRepository {
    @Override
    public Tranmission add(Tranmission tranmission) {
        Random random=new Random();
        tranmission.setId(random.nextInt(1000));
        System.out.println("Tranmission added to db by TranmissionRepositoryImpl");
        return tranmission;
    }
}
