package com.pichincha.infra.api.router.controller.dto.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pichincha.infra.api.router.controller.dto.request.CreateClientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDataDto extends CreateClientDto {
    @JsonProperty("client_id")
    private Integer clientId;

}
