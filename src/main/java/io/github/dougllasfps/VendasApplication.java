package io.github.dougllasfps;

import io.github.dougllasfps.domain.entity.Cliente;
import io.github.dougllasfps.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            clientes.save(new Cliente("Dougllas"));
            clientes.save(new Cliente("Carlos"));
            clientes.save(new Cliente("Teodora"));
            clientes.save(new Cliente("Sergio"));

            boolean existe = clientes.existsByNome("Douglas");
            System.out.println("Existe um cliente com o nome Dougllas? " + existe);


        };
    }

    public static void main(String[] args){

        SpringApplication.run(VendasApplication.class, args);
    }


}
