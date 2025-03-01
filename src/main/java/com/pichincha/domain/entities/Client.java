package com.pichincha.domain.entities;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private Long clientId;
    private Boolean isActive;
    private String password;
    private Person personalInformation;
    private Timestamp createAt;
    private Timestamp updateAt;
}
