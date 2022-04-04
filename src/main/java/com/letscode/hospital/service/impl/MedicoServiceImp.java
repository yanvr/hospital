package com.letscode.hospital.service.impl;

import com.letscode.hospital.dto.request.MedicoRequest;
import com.letscode.hospital.model.Medico;
import com.letscode.hospital.repository.MedicoRepository;
import com.letscode.hospital.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.UUID;

@Service
public class MedicoServiceImp implements MedicoService {

    @Autowired
    private MedicoRepository medicoRespository;

    @Override
    public Medico salvar(MedicoRequest medicoRequest) {
        Medico medico = new Medico(medicoRequest);
        return medicoRespository.save(medico);
    }

    @Override
    public List<Medico> listar() {
        return medicoRespository.findAll();
    }

    @Override
    public Medico pesquisar(UUID id) {
        return medicoRespository
                .findById(id)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Medico editar(UUID id, MedicoRequest medicoRequest) {
        Medico medico = pesquisar(id);
        BeanUtils.copyProperties(medicoRequest, medico, "id");
        return medicoRespository.save(medico);
    }

    @Override
    public void deletar(UUID id) {
        Medico medico = pesquisar(id);
        medicoRespository.delete(medico);
    }
}
