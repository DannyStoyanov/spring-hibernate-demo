package com.example.springhibernatedemo;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
public class RequestController {
    private final Service service;

    public RequestController(Service service) {
        this.service = service;
    }

    @GetMapping("/servers/")
    public Object executeGetRequest(@RequestParam(required=false) String ip, @RequestParam(required=false) Integer port) {
        return this.service.getServers(ip, port);
    }

    @GetMapping("/servers/{id}")
    public Object executeGetServerById(@PathVariable Integer id) {
        return this.service.getServerById(id).orElse(null);
    }

    @PostMapping("/create/")
    public Object executePostRequest(@RequestBody Server server) {
        this.service.addServer(server);
        return server;
    }

    @DeleteMapping("/delete/{ip}/{port}")
    public void executeDeleteRequest(@PathVariable String ip, @PathVariable int port) {
        this.service.deleteSpecificServer(ip, port);
    }

    @DeleteMapping("/delete/{ip}")
    public void executeDeleteRequest(@PathVariable String ip) {
        this.service.deleteServer(ip);
    }

    @PutMapping("/update/")
    public void executeUpdateRequest(@RequestParam String serverIP, @RequestParam int serverPort, @RequestParam @NotNull String attribute, @RequestParam String newValue) {
        if (attribute.equals("ip")) {
            this.service.updateServerIp(serverIP, newValue);
        } else if (attribute.equals("port")) {
            this.service.updateServerPort(serverIP, serverPort, Integer.parseInt(newValue));
        }
    }
}
