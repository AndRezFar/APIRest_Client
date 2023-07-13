package br.com.blpersonalizados.cliente.repository;

import br.com.blpersonalizados.cliente.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
