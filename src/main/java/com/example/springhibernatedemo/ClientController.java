package com.example.springhibernatedemo;

import com.example.springhibernatedemo.client.Client;
import com.example.springhibernatedemo.client.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients/")
    public Object executeGetAllClientsRequest() {
        return this.service.getClients();
    }

    @PostMapping("/client/create/")
    public Object executeCreateClientRequest(@RequestBody Client client) {
        this.service.addClient(client);
        return client;
    }
}
