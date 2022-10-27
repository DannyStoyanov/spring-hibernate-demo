package com.example.springhibernatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Configuration
@EnableJpaRepositories
public class JavaConfig {

    @Bean
    public Service service(ServerRepository serverRepository) {
        return new Service(serverRepository);
    }
}
