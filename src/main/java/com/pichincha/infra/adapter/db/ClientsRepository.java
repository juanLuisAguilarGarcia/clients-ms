package com.pichincha.infra.adapter.db;

import com.pichincha.domain.entities.Client;
import com.pichincha.domain.port.db.ClientsPortRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientsRepository implements ClientsPortRepository {

    public Client createClient(Client clientToSave){

        return new Client();
    }

    public Client getClientById(Integer clientId){
        return new Client();
    }

    public void deleteClient(Integer clientId){

        return;
    }

    public Client updateClient(Client clientToUpdate){
        return new Client();
    }
}
