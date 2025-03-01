package com.pichincha.infra.api.router.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pichincha.infra.api.router.controller.dto.response.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientDto  {
    @JsonProperty("is_actived")
    private boolean isActived;
    private String password;
    @JsonProperty("personal_information")
    private PersonDto personalInformation;
}
