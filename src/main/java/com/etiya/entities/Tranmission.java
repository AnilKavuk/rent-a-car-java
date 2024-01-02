package com.etiya.entities;

import com.etiya.core.entities.BaseEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tranmission  extends BaseEntity<Integer> {
    private String name;
    List<Car> cars;
}
