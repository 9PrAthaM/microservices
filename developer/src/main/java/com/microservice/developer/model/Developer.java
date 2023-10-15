package com.microservice.developer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "developer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    @Id
    private Integer developerId;
    @Field
    private String developerName;
    @Field
    private Integer managerId;
}
