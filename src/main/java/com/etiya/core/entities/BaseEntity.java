package com.etiya.core.entities;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity<T> {
    private T id;
    private LocalDateTime createdDate;
    private Optional <LocalDateTime> updatedDate;
    private Optional <LocalDateTime> deletedDate;
}
