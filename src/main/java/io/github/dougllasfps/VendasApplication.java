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
            clientes.salvar(new Cliente("Dougllas"));
            clientes.salvar(new Cliente("Carlos"));
            clientes.salvar(new Cliente("Teodora"));
            clientes.salvar(new Cliente("Sergio"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c ->{
                c.setNome(c.getNome() + " Atualizado");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("ll").forEach(System.out::println);

            //System.out.println("Deletando clientes");
            //clientes.obterTodos().forEach(c -> {
               // clientes.deletar(c);
            //});

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args){

        SpringApplication.run(VendasApplication.class, args);
    }


}
