package com.pichincha.infra.api.router.controller.mapper;

import com.pichincha.domain.entities.Client;
import com.pichincha.infra.api.router.controller.dto.request.CreateClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {
    @Mapping(ignore = true, target = "clientId")
    Client toEntity(CreateClientDto createClientDto);

    @Mappings({
            @Mapping(target="clientId", source="clientId")
    })
    Client toEntityWithId(CreateClientDto createClientDto, Integer clientId);
}
