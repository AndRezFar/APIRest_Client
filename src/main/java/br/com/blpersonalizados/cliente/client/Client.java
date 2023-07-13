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
//@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    private String name;
    private String born_date;
    private String cpf;
    private String phone1;
    private String phone2;
    private String email;
    private String password;

    public Client(ClientRequestDTO data){
        this.name = data.name();
        this.born_date = data.born_date();
        this.cpf = data.cpf();
        this.phone1 = data.phone1();
        this.email = data.email();
        this.password = data.password();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
