package com.etiya.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedTranmissionResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
