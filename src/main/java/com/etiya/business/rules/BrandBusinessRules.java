package com.etiya.business.rules;

import com.etiya.dataAcces.abstracts.BrandRepository;
import com.etiya.entities.Brand;

public class BrandBusinessRules {
    BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void brandNameCanNotBeDuplicated(String name){
        this.brandRepository.getByName(name).ifPresentOrElse(brand->{throw new RuntimeException("Marka ismi tekrar edemez. "+ brand.getName());
        },()->{});
    }
}
