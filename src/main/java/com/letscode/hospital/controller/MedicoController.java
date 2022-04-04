package com.letscode.hospital.controller;

import com.letscode.hospital.dto.request.MedicoRequest;
import com.letscode.hospital.dto.response.MedicoResponse;
import com.letscode.hospital.model.Medico;
import com.letscode.hospital.service.impl.MedicoServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoServiceImp medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponse> salvar(
            @Valid @RequestBody MedicoRequest medicoRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Medico medico = medicoService.salvar(medicoRequest);
        URI uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new MedicoResponse(medico));
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> listar() {
        List<Medico> medicos = medicoService.listar();
        return ResponseEntity.ok(MedicoResponse.of(medicos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> pesquisar(@PathVariable UUID id) {
        Medico medico = medicoService.pesquisar(id);
        return ResponseEntity.ok(new MedicoResponse(medico));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicoResponse> editar(@PathVariable UUID id, @RequestBody MedicoRequest medicoRequest) {
        Medico medico = medicoService.editar(id, medicoRequest);
        return ResponseEntity.ok(new MedicoResponse(medico));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        medicoService.deletar(id);
    }
}
