package com.andrelula.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrelula.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
