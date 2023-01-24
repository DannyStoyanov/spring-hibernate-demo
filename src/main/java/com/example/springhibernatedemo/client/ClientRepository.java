package com.example.springhibernatedemo.client;

import com.example.springhibernatedemo.client.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Query("SELECT c FROM Client c")
    public List<Client> getClients();
}