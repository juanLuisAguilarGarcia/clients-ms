package com.pichincha.app;

import com.pichincha.app.mapper.ClientMapper;
import com.pichincha.domain.entities.Client;
import com.pichincha.domain.port.db.ClientsPortRepository;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import com.pichincha.infra.api.router.facade.ClientsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.pichincha.app.ServiceConsts.MSG_CLIENT_CREATED;
import static com.pichincha.app.ServiceConsts.MSG_CLIENT_GET;


@Service
public class ClientsService implements ClientsFacade {

    @Autowired
    private ClientsPortRepository clientsPortRepository;

    @Autowired
    private ClientMapper clientMapper;


    public ClientDto createClient(Client clientToSave){
        Client client = clientsPortRepository.createClient(clientToSave);

        return getClientDto(client, MSG_CLIENT_CREATED);
    }

    public ClientDto getClientById(Integer clientId){
        Client client = clientsPortRepository.getClientById(clientId);

        return getClientDto(client, MSG_CLIENT_GET);
    }

    public void deleteClient(Integer clientId){
         clientsPortRepository.deleteClient(clientId);

        return;
    }

    public ClientDto updateClient(Client clientToUpdate){
        Client client = clientsPortRepository.updateClient(clientToUpdate);

        return getClientDto(client, MSG_CLIENT_GET);
    }

    private ClientDto getClientDto(Client client, String msg){
        ClientDto clientDto =  ClientDto.builder().data(clientMapper.toDto(client)).build();
        clientDto.setCode(String.valueOf(HttpStatus.OK.value()));
        clientDto.setMessage(msg);

        return clientDto;
    }

}
