package com.etiya.business.concretes;

import com.etiya.business.dtos.requests.CreateFuelRequest;
import com.etiya.business.dtos.responses.CreatedFuelResponse;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAcces.abstracts.FuelRepository;
import com.etiya.entities.Fuel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuelServiceImpl {

    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;

    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest){
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);

        Fuel createdFuel=fuelRepository.add(fuel);

        CreatedFuelResponse createdFuelResponse=this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);

        return createdFuelResponse;
    }
}
