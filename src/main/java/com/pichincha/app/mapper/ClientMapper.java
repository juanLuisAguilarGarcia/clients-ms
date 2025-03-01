package com.pichincha.app.mapper;

import com.pichincha.domain.entities.Client;
import com.pichincha.infra.api.router.controller.dto.request.CreateClientDto;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDataDto;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDataDto toDto(Client client);
}
