package com.agendamentoweb.repository;

import org.springframework.data.repository.CrudRepository;
import com.agendamentoweb.models.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento, String>{

	Agendamento findByCodigo(long codigo);

}
