package com.andrelula.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andrelula.helpdesk.domain.Chamado;
import com.andrelula.helpdesk.domain.Cliente;
import com.andrelula.helpdesk.domain.Tecnico;
import com.andrelula.helpdesk.domain.enums.Perfil;
import com.andrelula.helpdesk.domain.enums.Prioridade;
import com.andrelula.helpdesk.domain.enums.Status;
import com.andrelula.helpdesk.repositories.ChamadoRepository;
import com.andrelula.helpdesk.repositories.ClienteRepository;
import com.andrelula.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository; 
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Abigail Bezerra", "06678239300", "abigail@gmail.com", encoder.encode("123"));
		Tecnico tec2 = new Tecnico(null, "Andre Lula", "30729378349", "andre@gmail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Wendell Rodrigues", "11582723320", "wendell@gmail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Maysa Silveira", "32626746304", "maysa@gmail.com", encoder.encode("123"));
 
		tec1.addPerfil(Perfil.ADMIN);
		tec4.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "82148589334", "torvalds@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Acacio Elias", "34691014349", "acacio@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Aci Duarte", "09309380896", "aciduarte@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Acilana Alencar", "81425295304", "acilana@mail.com", encoder.encode("123"));
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 03", "Terceiro Chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 04", "Quarto Chamado", tec4, cli4);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}
	
}
