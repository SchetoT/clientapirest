package com.clientapirest.demo.services;

import com.clientapirest.demo.entities.Client;
import com.clientapirest.demo.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;

    public void saveClient(Client client){
        repository.save(client);
    }

    public List<Client> readClients(){
        return repository.findAll();
    }

    public Optional<Client> readOneClient(Long id){
        //el optional es por si no encuentra el cliente con ese id
        return repository.findById(id);
    }
    public void destroyOneClient(Long id){
        repository.deleteById(id);
    }
}
