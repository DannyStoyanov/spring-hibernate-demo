package com.example.springhibernatedemo;

import com.example.springhibernatedemo.server.Server;
import com.example.springhibernatedemo.server.ServerService;
import com.example.springhibernatedemo.utils.HeartbeatMessage;
import com.example.springhibernatedemo.rabbitmq.MQConfig;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
public class ServerController {
    private final ServerService service;

    public ServerController(ServerService service) {
        this.service = service;
    }

    @GetMapping("/servers/active/")
    public Object executeGetActiveServersRequest(@RequestParam(required = false) String ip, @RequestParam(required = false) Integer port) {
        return this.service.getServersLastOnline(ip, port);
    }

    @GetMapping("/servers/")
    public Object executeGetAllServersRequest(@RequestParam(required = false) String ip, @RequestParam(required = false) Integer port) {
        return this.service.getServers(ip, port);
    }

    @GetMapping("/servers/{id}")
    public Object executeGetServerById(@PathVariable Integer id) {
        return this.service.getServerById(id).orElse(null);
    }

    @PostMapping("/servers/create/")
    public Object executePostRequest(@RequestBody Server server) {
        this.service.addServer(server);
        return server;
    }

    @DeleteMapping("/servers/delete/{ip}/{port}")
    public void executeDeleteRequest(@PathVariable String ip, @PathVariable int port) {
        this.service.deleteSpecificServer(ip, port);
    }

    @DeleteMapping("/servers/delete/{ip}")
    public void executeDeleteRequest(@PathVariable String ip) {
        this.service.deleteServer(ip);
    }

    @PutMapping("/servers/update/")
    public void executeUpdateRequest(@RequestParam String serverIP, @RequestParam int serverPort, @RequestParam @NotNull String attribute, @RequestParam String newValue) {
        if (attribute.equals("ip")) {
            this.service.updateServerIp(serverIP, newValue);
        } else if (attribute.equals("port")) {
            this.service.updateServerPort(serverIP, serverPort, Integer.parseInt(newValue));
        }
    }

    @Transactional
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(HeartbeatMessage message) {
        String date = message.getMessageDate();
        String[] args = message.getMessage().split(";");
        String serverIP = args[0];
        int serverPort = Integer.parseInt(args[1]);
        if (this.service.getServers(serverIP, serverPort).isEmpty()) {
            this.service.addServer(new Server(serverIP, serverPort));
        }
        this.service.updateServerLastOnline(serverIP, serverPort, date);
        System.out.println(serverIP + " is online ");
    }
}
