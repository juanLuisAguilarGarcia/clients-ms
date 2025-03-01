package com.pichincha.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Integer clientId;
    private boolean isActived;
    private String password;
    private Person personalInformation;
    private String createAt;
    private String updateAt;
}
