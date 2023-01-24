package com.example.springhibernatedemo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ServerService {

    @Autowired
    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Transactional
    public Optional<Server> getServerById(Integer id) {
        return serverRepository.findById(id);
    }

    @Transactional
    public List<Server> getServers(String ip, Integer port) {
        return serverRepository.findServers(ip, port);
    }

    @Transactional
    public void addServer(Server server) {
        serverRepository.save(server);
    }

    @Transactional
    public void deleteServer(String ip) {
        serverRepository.deleteByIp(ip);
    }

    @Transactional
    public void deleteSpecificServer(String ip, int port) {
        serverRepository.deleteByIpAndPort(ip, port);
    }

    @Transactional
    public void updateServerIp(String serverIP, String newIPValue) {
        serverRepository.updateIP(serverIP, newIPValue);
    }

    @Transactional
    public void updateServerPort(String serverIP, int serverPort, int newPortValue) {
        serverRepository.updatePort(serverIP, serverPort, newPortValue);
    }

    @Transactional
    public void updateServerLastOnline(String serverIP, int serverPort, String newDate) {
        serverRepository.updateServerLastOnline(serverIP, serverPort, newDate);
    }

    @Transactional
    public List<Server> getServersLastOnline(String ip, Integer port) {
        List<Server> servers = serverRepository.findServers(ip, port);
        List<Server> lastMinuteOnlineServers = new LinkedList<Server>();
        for (Server server : servers) {
            if (server.getLast_online() == null) {
                continue;
            }
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime lastOnline = LocalDateTime.parse(server.getLast_online());
            LocalDateTime tempDateTime = LocalDateTime.from(now);

            long years = tempDateTime.until(lastOnline, ChronoUnit.YEARS);
            tempDateTime = tempDateTime.plusYears(years);
            long months = tempDateTime.until(lastOnline, ChronoUnit.MONTHS);
            tempDateTime = tempDateTime.plusMonths(months);
            long days = tempDateTime.until(lastOnline, ChronoUnit.DAYS);
            tempDateTime = tempDateTime.plusDays(days);
            long hours = tempDateTime.until(lastOnline, ChronoUnit.HOURS);
            tempDateTime = tempDateTime.plusHours(hours);
            long minutes = tempDateTime.until(lastOnline, ChronoUnit.MINUTES);
            tempDateTime = tempDateTime.plusMinutes(minutes);
            long seconds = tempDateTime.until(lastOnline, ChronoUnit.SECONDS);
            if (years == 0 && months == 0 && days == 0 && hours == 0 && Math.abs(minutes) <= 1) {
                lastMinuteOnlineServers.add(server);
            }
        }
        return lastMinuteOnlineServers;
    }
}
