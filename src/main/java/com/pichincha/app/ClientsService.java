package com.pichincha.app;

import com.pichincha.app.mapper.ClientMapper;
import com.pichincha.domain.entities.Client;
import com.pichincha.domain.port.db.ClientsPortRepository;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import com.pichincha.infra.api.router.controller.error.exception.ClientException;
import com.pichincha.infra.api.router.facade.ClientsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.pichincha.app.ServiceConsts.MSG_CLIENT_CREATED;
import static com.pichincha.app.ServiceConsts.MSG_CLIENT_GET;


@Service
public class ClientsService implements ClientsFacade {

    @Autowired
    private ClientsPortRepository clientsPortRepository;

    @Autowired
    private ClientMapper clientMapper;


    public ClientDto createClient(Client clientToSave) throws ClientException {
        try{
            Client client = clientsPortRepository.save(
                    ClientMapper.toClientEntityDto(
                            validClientBeforeCreate(clientToSave)));
            return ClientMapper.toClientDto(clientMapper.toDto(client), MSG_CLIENT_CREATED);
        } catch(DataAccessException ex){
            throw new ClientException("422-1", ex.getMessage());
        }
    }

    public ClientDto getClientById(Long clientId) throws ClientException {
        try{
            Client client = existsClient(clientId);

            return ClientMapper.toClientDto(clientMapper.toDto(client), MSG_CLIENT_GET);
        } catch(DataAccessException ex){
            throw new ClientException("422-2", ex.getMessage());
        }

    }

    public void deleteClient(Long clientId) throws ClientException {
        try{
            Client client = existsClient(clientId);

            client.setIsActive(false);

            clientsPortRepository.save(ClientMapper.toClientEntityDto(client));
            return;
        } catch(DataAccessException ex){
            throw new ClientException("422-3", ex.getMessage());
        }
    }

    public ClientDto updateClient(Client clientToUpdate) throws ClientException {
        try{
            existsClient(clientToUpdate.getClientId());

            Client client = clientsPortRepository.updateClient(ClientMapper.toClientEntityDto(clientToUpdate));
            return ClientMapper.toClientDto(clientMapper.toDto(client), MSG_CLIENT_GET);
        } catch(DataAccessException ex){
            throw new ClientException("422-4", ex.getMessage());
        }
    }

    private Client existsClient(Long clientId) throws ClientException {
        Client client = clientsPortRepository.getClientById(clientId);

        if(Objects.isNull(client.getClientId())  || client.getClientId() < 1L) {
            throw new ClientException("422-5", "client not found");
        }

        return client;
    }

    private Client validClientBeforeCreate(Client clientToCreate) throws ClientException {
        Client client = clientsPortRepository.getClientByIdentificationTypeIdAndIdentificationNumber(
                clientToCreate.getPersonalInformation().getIdentification().getTypeId(), clientToCreate.getPersonalInformation().getIdentification().getNumber());

        if(!Objects.isNull(client.getClientId()) || client.getClientId() >= 1L ) {
            if(client.getIsActive()) {
                throw new ClientException("422-5", "Client exists in system.");
            } else {
                clientToCreate.setClientId(client.getClientId());
                return clientToCreate;
            }
        }else {
            return clientToCreate;
        }

    }
}
