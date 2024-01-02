package com.etiya.business.concretes;


import com.etiya.business.dtos.requests.CreateTranmissionRequest;
import com.etiya.business.dtos.responses.CreatedTranmissionResponse;
import com.etiya.core.utilities.mapping.ModelMapperService;
import com.etiya.dataAcces.abstracts.TranmissionRepository;
import com.etiya.entities.Tranmission;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TranmissionServiceImpl {
    private TranmissionRepository tranmissionRepository;
    private ModelMapperService modelMapperService;

  public CreatedTranmissionResponse add(CreateTranmissionRequest createTranmissionRequest){
      Tranmission tranmission=this.modelMapperService.forRequest().map(createTranmissionRequest,Tranmission.class);

      Tranmission createdTranmission=tranmissionRepository.add(tranmission);

      CreatedTranmissionResponse createdTranmissionResponse=this.modelMapperService.forResponse().map(createdTranmission, CreatedTranmissionResponse.class);

      return createdTranmissionResponse;
  }
}
