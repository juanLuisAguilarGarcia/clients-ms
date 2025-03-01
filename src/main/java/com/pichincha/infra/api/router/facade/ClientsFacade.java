package com.pichincha.infra.api.router.facade;

import com.pichincha.app.ClientsService;
import com.pichincha.domain.entities.Client;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface ClientsFacade {

    public ClientDto createClient(Client client);

    public ClientDto getClientById(Integer clientId);

    public void deleteClient(Integer clientId);

    public ClientDto updateClient(Client client );
}
