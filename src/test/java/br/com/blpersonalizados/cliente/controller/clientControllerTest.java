package br.com.blpersonalizados.cliente.controller;

import br.com.blpersonalizados.cliente.client.Client;
import br.com.blpersonalizados.cliente.client.ClientRequestDTO;
import br.com.blpersonalizados.cliente.repository.ClientRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class clientControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static final String END_POINT_PATH = "/clients";

    @Test
    void saveClientSucessful() throws Exception {
        ClientRequestDTO clientDTO = new ClientRequestDTO("Ricardao","08/09/2000","12312312312","11999998888","ricardo.sa@gmail.com","123");
        Client client = new Client(clientDTO);

        ResponseEntity<String> result = testRestTemplate.postForEntity(END_POINT_PATH, client, String.class);

        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void saveClientError() throws Exception {
        ClientRequestDTO clientDTO = new ClientRequestDTO("Ricardao","","12312312312","11999998888","ricardo.sa@gmail.com",null);
        Client client = new Client(clientDTO);

        ResponseEntity<String> result = testRestTemplate.postForEntity(END_POINT_PATH, client, String.class);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    void getAllSUcessful() throws Exception {

        ResponseEntity<String> result = testRestTemplate.getForEntity(END_POINT_PATH, String.class);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void getClientById() {
        ResponseEntity<String> result = testRestTemplate.getForEntity("/clients/{id}", String.class, 6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateNomeClient() {
        Client client = new Client();
        client.setName("Robertao");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/name", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void updateEmailClient() {
        Client client = new Client();
        client.setEmail("Robertao@aa.com");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/email", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateSenhaClient() {
        Client client = new Client();
        client.setPassword("321");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/password", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateTelefone1Client() {
        Client client = new Client();
        client.setPhone1("11987878787");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/phone1", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateTelefone2Client() {
        Client client = new Client();
        client.setPhone2("11987878787");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/phone2", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void updateDataNascimentoClient() {
        Client client = new Client();
        client.setBorn_date("01/01/1999");
        HttpEntity<Client> request = new HttpEntity<>(client);
        ResponseEntity<String> result = testRestTemplate.exchange("/clients/{id}/bornDate", HttpMethod.PUT,request, String.class,6);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void deleteClient() {
        Client cLient = new Client();
        HttpEntity<Client> request = new HttpEntity<>(cLient);
        ResponseEntity<Void> result = testRestTemplate.exchange("/clients/{id}", HttpMethod.DELETE, request, Void.class, 5);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}