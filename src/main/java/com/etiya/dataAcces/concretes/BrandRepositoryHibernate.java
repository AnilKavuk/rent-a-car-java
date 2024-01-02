package com.etiya.dataAcces.concretes;

import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.dataAcces.abstracts.BrandRepository;
import com.etiya.entities.Brand;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BrandRepositoryHibernate  implements BrandRepository {
    List<Brand> brands;
    public BrandRepositoryHibernate() {
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("BMW");
        brand1.setCreatedDate(LocalDateTime.now());

        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("Mercedes");
        brand2.setCreatedDate(LocalDateTime.now());

        Brand brand3 = new Brand();
        brand3.setId(3);
        brand3.setName("Alfa Romeo");
        brand3.setCreatedDate(LocalDateTime.now());


        brands=new ArrayList<>();

        brands.add(brand1);
        brands.add(brand2);
        brands.add(brand3);
    }

    @Override
    public Brand add(Brand brand) {
        Random random=new Random();
        brand.setId(random.nextInt(1000));
        System.out.println("Brand added to db by BrandRepositoryHibernate");
        return brand;
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

    @Override
    public Optional<Brand> getByName(String name) {
        Optional<Brand> currentBrand= this.brands.stream().filter(brand -> brand.getName().equals(name)).findFirst();
        return currentBrand;
    }

}
