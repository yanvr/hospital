package com.letscode.hospital.service;

import com.letscode.hospital.dto.request.MedicoRequest;
import com.letscode.hospital.model.Medico;

import java.util.List;
import java.util.UUID;

public interface MedicoService {

    Medico salvar(MedicoRequest medicoRequest);

    List<Medico> listar();

    Medico pesquisar(UUID id);

    Medico editar(UUID id, MedicoRequest medicoRequest);

    void deletar(UUID id);
}
