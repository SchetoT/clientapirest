package com.clientapirest.demo.controllers;

import com.clientapirest.demo.entities.Client;
import com.clientapirest.demo.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    //creacion del cliente

    @GetMapping()
    public List<Client> readClients() {
        try{
            return service.readClients();
        } catch (Exception exception){
            System.out.println(exception);
            throw new RuntimeException("READ ALL CLIENTS ERROR");
        }
    }
    //obtener todos los clientes

    @GetMapping("/{id}")
    //el id del cliente lo vamos a sacar de un parametro de ruta
    public Optional<Client> readOneClient(@PathVariable Long id){
        //optional por si no encuentra el cliente
        try{
            return service.readOneClient(id);
        } catch (Exception exception){
            System.out.println(exception);
            throw new RuntimeException("READ ONE CLIENT ERROR");
        }
    }
    //obtener un cliente por id


    @DeleteMapping("/{id}")
    public void deleteAllClients(@PathVariable("id") Long id){
        try{
            service.destroyOneClient(id);
        } catch (Exception exception){
            System.out.println(exception);
            throw new RuntimeException("DELETE ALL CLIENTS ERROR");
        }
    }
    //eliminar un cliente por el id
}
