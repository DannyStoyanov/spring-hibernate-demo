package com.example.springhibernatedemo;

import com.example.springhibernatedemo.client.ClientRepository;
import com.example.springhibernatedemo.client.ClientService;
import com.example.springhibernatedemo.server.ServerRepository;
import com.example.springhibernatedemo.server.ServerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class JavaConfig {

    @Bean
    public ServerService serverService(ServerRepository serverRepository) {
        return new ServerService(serverRepository);
    }

    @Bean
    public ClientService clientService(ClientRepository clientRepository) {
        return new ClientService(clientRepository);
    }

    @Bean
    public RequestController requestController(ServerRepository serverRepository, ClientRepository clientRepository) {
        return new RequestController(serverRepository, clientRepository);
    }
}
