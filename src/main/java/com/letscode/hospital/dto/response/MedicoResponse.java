package com.letscode.hospital.dto.response;

import com.letscode.hospital.model.Medico;
import lombok.Getter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class MedicoResponse {

    private final UUID uuid;
    private final String nome;
    private final String telefone;
    private final String email;
    private final String crm;

    public MedicoResponse(Medico medico) {
        this.uuid = medico.getUuid();
        this.nome = medico.getNome();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.crm = medico.getCrm();
    }

    public static List<MedicoResponse> of(List<Medico> medicos) {
        return medicos.stream().map(MedicoResponse::new).collect(Collectors.toList());
    }
}
