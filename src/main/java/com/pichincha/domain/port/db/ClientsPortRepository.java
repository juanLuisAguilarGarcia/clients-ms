package com.pichincha.domain.port.db;

import com.pichincha.domain.entities.Client;

public interface ClientsPortRepository {
    Client createClient(Client client);
    Client getClientById(Integer clientId);
    void deleteClient(Integer clientId);
    Client updateClient(Client client );
}
