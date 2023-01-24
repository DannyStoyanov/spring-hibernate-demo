package com.example.springhibernatedemo.server;

import com.example.springhibernatedemo.server.Server;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRepository extends CrudRepository<Server, Integer> {
    @Query("SELECT s FROM Server s WHERE s.ip=:ipValue AND (:portValue is null) OR (:ipValue is null) AND s.port=:portValue OR (:ipValue is null) AND (:portValue is null) OR (s.ip=:ipValue AND s.port=:portValue)")
    public List<Server> findServers(String ipValue, Integer portValue);

    @Modifying
    @Query("DELETE FROM Server WHERE ip=:ipValue")
    public void deleteByIp(String ipValue);

    @Modifying
    @Query("DELETE FROM Server s WHERE ip=:ipValue AND port=:portValue")
    public void deleteByIpAndPort(String ipValue, int portValue);

    @Modifying
    @Query("UPDATE Server s SET s.port=:newPortValue WHERE s.ip=:ipValue AND s.port=:portValue")
    public void updatePort(String ipValue, int portValue, int newPortValue);

    @Modifying
    @Query("UPDATE Server s SET s.ip=:newIPValue WHERE s.ip=:ipValue")
    public void updateIP(String ipValue, String newIPValue);

    @Modifying
    @Query("UPDATE Server s SET s.last_online=:newLastOnline WHERE s.ip=:ipValue AND s.port=:portValue")
    public void updateServerLastOnline(String ipValue, int portValue, String newLastOnline);


}
