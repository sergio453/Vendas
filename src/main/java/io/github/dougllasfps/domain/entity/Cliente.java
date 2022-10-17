package io.github.dougllasfps.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Para MySql usamos IDENTITY
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message =  "{campo.nome.obrigatorio}")
    private  String nome;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message =  "{campo.cpf.obrigatorio}")
    @CPF(message = "campo.cpf.invalido{}")
    private String cpf;

    @Column(name = "idade")
    @NotNull(message = "{campo.idade.obrigatorio}")
    private Integer idade;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
