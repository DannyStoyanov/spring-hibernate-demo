package com.example.springhibernatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class Service {

    @Autowired
    private final ServerRepository repository;

    public Service(ServerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Optional<Server> getServerById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public List<Server> getServers(String ip, Integer port) {
        return  repository.findServers(ip, port);
    }

    @Transactional
    public void addServer(Server server) {
        repository.save(server);
    }

    @Transactional
    public void deleteServer(String ip) {
        repository.deleteByIp(ip);
    }

    @Transactional
    public void deleteSpecificServer(String ip, int port) {
        repository.deleteByIpAndPort(ip, port);
    }

    @Transactional
    public void updateServerIp(String serverIP, String newIPValue) {
        repository.updateIP(serverIP, newIPValue);
    }

    @Transactional
    public void updateServerPort(String serverIP, int serverPort, int newPortValue) {
        repository.updatePort(serverIP, serverPort, newPortValue);
    }
}
