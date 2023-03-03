package com.andrelula.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrelula.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
