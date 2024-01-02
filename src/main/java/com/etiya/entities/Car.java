package com.etiya.entities;

import com.etiya.core.entities.BaseEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car extends BaseEntity<Integer> {
    private String plate;
    private double dailyPrice;
    private Model model;
    private Fuel fuel;
    private Tranmission tranmission;

}
