package com.example.springhibernatedemo.server;

public class ServerDataPair {
    private String ip;
    private int port;

    public ServerDataPair(String ip, int port) {
        this.ip = ip;
        this.port = port;
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

    @Override
    public String toString() {
        return "ServerDataPair{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
