package com.pichincha.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String fistName;
    private String lastName;
    private String gender;
    private Integer age;
    private Identification identification;
    private String address;
    private ContactInformation contactInformation;
    private String createAt;
    private String updateAt;
}
