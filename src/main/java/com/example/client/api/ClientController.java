package com.example.client.api;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client addClient(@RequestBody Client client){ return clientService.addClient(client); }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    @GetMapping("{clientId}")
    public Client getClientById(@PathVariable String clientId) throws NotFoundException {
        return clientService.getById(clientId);
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientId){
        clientService.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}
