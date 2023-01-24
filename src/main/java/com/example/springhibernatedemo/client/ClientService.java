package com.example.springhibernatedemo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    @Transactional
    public void addClient(Client client) {
        clientRepository.save(client);
    }

}
