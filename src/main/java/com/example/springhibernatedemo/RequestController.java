package com.example.springhibernatedemo;

import com.example.springhibernatedemo.client.Client;
import com.example.springhibernatedemo.client.ClientRepository;
import com.example.springhibernatedemo.server.Server;
import com.example.springhibernatedemo.server.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private ServerRepository serverRepository;
    @Autowired
    private ClientRepository clientRepository;

    public RequestController(ServerRepository serverRepository, ClientRepository clientRepository) {
        this.serverRepository = serverRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/client-server/")
    public void executeGetRelatedData() {
        // ...
    }

    @PutMapping("/client-server/")
    public Server executePutRelatedData(@RequestParam Integer serverID, @RequestParam Integer clientID) {
        Server server = serverRepository.findById(serverID).get();
        Client client = clientRepository.findById(clientID).get();
        server.addClient(client);
        client.addServer(server);
        return serverRepository.save(server);
    }
}
