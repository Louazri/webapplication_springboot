package com.louazri.webapplication.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private LocalDateTime createdAT;
    private String createdBy;
    private LocalDateTime updatedAT;
    private String updatedBy;
}
