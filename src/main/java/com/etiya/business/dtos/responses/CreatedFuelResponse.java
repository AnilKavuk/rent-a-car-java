package com.etiya.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedFuelResponse {
    private  int id;
    private String name;
    private LocalDateTime createdDate;

}
