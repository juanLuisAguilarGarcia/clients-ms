package com.pichincha.app.mapper;

import com.pichincha.domain.entities.Client;
import com.pichincha.infra.adapter.db.entites.ClientsDto;
import com.pichincha.infra.adapter.db.entites.IdentificationTypeDto;
import com.pichincha.infra.adapter.db.entites.PersonsDto;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDataDto;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import org.mapstruct.Mapper;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDataDto toDto(Client client);

    static ClientsDto toCreateEntity(Client client){
        return new ClientsDto();
    }

    static ClientDto toClientDto(ClientDataDto client, String msg){
        ClientDto clientDto =  ClientDto.builder().data(client).build();
        clientDto.setCode(String.valueOf(HttpStatus.OK.value()));
        clientDto.setMessage(msg);

        return clientDto;
    }

    static ClientsDto toClientEntityDto(Client client) {
        PersonsDto personsDto = new PersonsDto();

        if (Objects.isNull(client) ){
            return ClientsDto.builder().build();
        }

        if(!Objects.isNull(client.getPersonalInformation())) {
            personsDto = PersonsDto.builder()
                    .address(client.getPersonalInformation().getAddress())
                    .age(client.getPersonalInformation().getAge())
                    .firstName(client.getPersonalInformation().getFirstName())
                    .lastName(client.getPersonalInformation().getLastName())
                    .gender(client.getPersonalInformation().getGender())
                    .telephonNumber(client.getPersonalInformation().getContactInformation().getTelephoneNumber())
                    .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                    .identification(IdentificationTypeDto.builder().build()).build();

            if(!Objects.isNull(client.getPersonalInformation().getContactInformation())) {
                personsDto.setIdentificationNumber(client.getPersonalInformation().getIdentification().getNumber());
            }

            if(!Objects.isNull(client.getPersonalInformation().getIdentification())) {
                personsDto.setIdentification(IdentificationTypeDto.builder().identificationTypeId(
                        client.getPersonalInformation().getIdentification().getTypeId()
                ).build());
            }
        }

        return  ClientsDto.builder()
                .clientId(client.getClientId())
                .isActive(true)
                .updateAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .persons(personsDto)
                .password(client.getPassword()).build();
    }
}
