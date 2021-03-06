package com.example.client.service;

import com.example.client.model.Client;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client getById(String id){
        return clientRepository.getOne(id);
    }

    @Override
    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

}

