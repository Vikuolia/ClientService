package com.example.client.service;

import com.example.client.model.Client;
import javassist.NotFoundException;

import java.util.List;

public interface ClientService {

    Client addClient(Client newClient);

    List<Client> getAll();

    Client getById(String id) throws NotFoundException;

    void deleteById(String id);
}

