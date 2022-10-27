package com.example.springhibernatedemo;


import javax.persistence.*;
@Entity
@Table(name="servers")
public class Server {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; // add Getter and return

    @Column(name="ip")
    String ip;

    @Column(name="port")
    int port;

    public Server() {

    }

    public Server(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
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
}