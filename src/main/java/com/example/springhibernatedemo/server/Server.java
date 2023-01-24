package com.example.springhibernatedemo.server;

import com.example.springhibernatedemo.client.Client;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "servers")
public class Server {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private int port;

    @Column(name = "last_online")
    private String last_online;

    @ManyToMany
    @JoinTable(name = "client_server",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "server_id", referencedColumnName = "id"))
    private Set<Client> clients = new HashSet<>();

    public Server() {

    }

    public Server(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.last_online = new Date().toString();
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", date=" + last_online +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getLast_online() {
        return last_online;
    }

    public void setLast_online(String last_online) {
        this.last_online = last_online;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }
}