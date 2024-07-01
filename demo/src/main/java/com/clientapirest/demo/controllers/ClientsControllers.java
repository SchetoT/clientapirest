package com.clientapirest.demo.controllers;

import com.clientapirest.demo.entities.Client;
import com.clientapirest.demo.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/clients")
public class ClientsControllers {

    @Autowired
    private ClientsService service;

    @PostMapping()
    public void saveClient(@RequestBody Client client) {
        try{
            service.saveClient(client);
        } catch (Exception exception){
            System.out.println(exception);
            throw new RuntimeException("CREATE ERROR");
        }
    }
}
