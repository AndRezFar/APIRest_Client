package br.com.blpersonalizados.cliente.controller;


import br.com.blpersonalizados.cliente.client.Client;
import br.com.blpersonalizados.cliente.repository.ClientRepository;
import br.com.blpersonalizados.cliente.client.ClientRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client saveClient(@RequestBody ClientRequestDTO data){
        Client clientData = new Client(data);
        return clientRepository.save(clientData);
    }

    @GetMapping
    public List<Client> getAllClients(){
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = clientRepository.getReferenceById(id);

        if(client != null)
            return ResponseEntity.ok(client);
        else
            return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Client> updateNomeClient(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setName(client.getName());

            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Client> updateEmailClient(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setEmail(client.getEmail());


            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<Client> updateSenhaClient(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setPassword(client.getPassword());

            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/phone1")
    public ResponseEntity<Client> updateTelefone1Client(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setPhone1(client.getPhone1());

            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/phone2")
    public ResponseEntity<Client> updateTelefone2Client(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setPhone2(client.getPhone2());

            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/bornDate")
    public ResponseEntity<Client> updateDataNascimentoClient(@PathVariable Long id, @RequestBody Client client){
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null) {
            existingClient.setBorn_date(client.getBorn_date());

            Client savedClient = clientRepository.save(existingClient);

            return ResponseEntity.ok(savedClient);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        Client existingClient = clientRepository.getReferenceById(id);

        if (existingClient != null){
            clientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
