package br.com.blpersonalizados.cliente.client;


public record ClientRequestDTO(String nome, String data_nascimento, String cpf, String telefone1, String email, String senha){}
