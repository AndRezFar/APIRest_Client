package br.com.blpersonalizados.cliente.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "client")
@Entity(name = "client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    private String nome;
    private String data_nascimento;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String email;
    private String senha;

    public Client(ClientRequestDTO data){
        this.nome = data.nome();
        this.data_nascimento = data.data_nascimento();
        this.cpf = data.cpf();
        this.telefone1 = data.telefone1();
        this.email = data.email();
        this.senha = data.senha();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
