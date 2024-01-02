package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateBrandRequest;
import com.etiya.business.dtos.responses.CreatedBrandResponse;
import com.etiya.business.dtos.responses.GetAllBrandResponse;
import com.etiya.business.rules.BrandBusinessRules;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAcces.abstracts.BrandRepository;
import com.etiya.dataAcces.concretes.BrandRepositoryImpl;
import com.etiya.entities.Brand;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

public class BrandServiceImpl {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    private BrandBusinessRules brandBusinessRules;


    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest){
        this.brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());

        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        Brand createdBrand=brandRepository.add(brand);

        CreatedBrandResponse createdBrandResponse=this.modelMapperService.forResponse()
                .map(createdBrand,CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    public List<GetAllBrandResponse> getAll(){
        var result=brandRepository.getAll();

        List<GetAllBrandResponse> response=result.stream().map(brand->this.modelMapperService.forResponse()
                .map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());

        return  response;
    }
}
