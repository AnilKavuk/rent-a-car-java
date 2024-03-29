package com.etiya.entities;

import com.etiya.core.entities.BaseEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Model extends BaseEntity<Integer> {
    private String name;
    private Brand brand;
    private List<Car> cars;
}
