package com.etiya;


import com.etiya.business.concretes.BrandServiceImpl;
import com.etiya.business.concretes.FuelServiceImpl;
import com.etiya.business.concretes.TranmissionServiceImpl;
import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.requests.CreateFuelRequest;
import com.etiya.business.dtos.requests.CreateTranmissionRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.business.rules.BrandBusinessRules;
import com.etiya.core.utilities.mapping.ModelMapperManager;
import com.etiya.dataAcces.concretes.*;
import com.etiya.entities.*;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Brand brand1=new Brand();
//        brand1.setId(1);
//        brand1.setName("BMW");
//
//        Brand brand2=new Brand();
//        brand2.setId(2);
//        brand2.setName("Mercedes");
//
//        Model model1 = new Model();
//        model1.setId(1);
//        model1.setName("Series 1");
//        model1.setBrand(brand1);
//
//        Fuel fuel1=new Fuel();
//        fuel1.setId(1);
//        fuel1.setName("Diesel");
//
//        Fuel fuel2=new Fuel();
//        fuel2.setId(2);
//        fuel2.setName("Fuel Oil");
//
//        Tranmission tranmission1=new Tranmission();
//        tranmission1.setId(1);
//        tranmission1.setName("Automatic");
//
//        Tranmission tranmission2= new Tranmission();
//        tranmission2.setId(2);
//        tranmission2.setName("Manual");
//
//        Car car1 = new Car();
//        car1.setId(1);
//        car1.setPlate("06ABC01");
//        car1.setModel(model1);
//        car1.setFuel(fuel1);
//        car1.setTranmission(tranmission1);
//        car1.setDailyPrice(800000);
//
//        Car car2 = new Car();
//        car2.setId(2);
//        car2.setPlate("06ABC02");
//        car2.setModel(model1);
//        car2.setFuel(fuel2);
//        car2.setTranmission(tranmission2);
//        car2.setDailyPrice(500000);
//
//        System.out.println(car1);
//        System.out.println("===========================");
//        System.out.println(car2);

        //Brand
        BrandServiceImpl brandService=new BrandServiceImpl(new BrandRepositoryImpl(),new ModelMapperManager(new ModelMapper())
                ,new BrandBusinessRules(new BrandRepositoryImpl()));
        CreateBrandRequest request1=new CreateBrandRequest();
        request1.setName("Model");
        CreatedBrandResponse response1=brandService.add(request1);
        System.out.println(response1.getName());
        //Fuel
        FuelServiceImpl fuelService=new FuelServiceImpl(new FuelRepositoryHibernate(),new ModelMapperManager(new ModelMapper()));
        CreateFuelRequest request2=new CreateFuelRequest();
        request2.setName("Diesel");
        fuelService.add(request2);

        //Tranmission
        TranmissionServiceImpl tranmissionService=new TranmissionServiceImpl(new TranmissionRepositoryImpl(),new ModelMapperManager(new ModelMapper()));
        CreateTranmissionRequest request3=new CreateTranmissionRequest();
        request3.setName("Manual");
        tranmissionService.add(request3);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //Get All Brand
        List<GetAllBrandResponse> allBrand= brandService.getAll();

        for(GetAllBrandResponse brand:allBrand){
            System.out.println(brand.getId()+"/"+ brand.getName()+"/"+brand.getCreatedDate());
        }
    }
}