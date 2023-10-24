package com.microservice.manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Developers {
    private Integer developerId;
    private String developerName;
    private Integer managerId;
}
