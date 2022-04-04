package com.letscode.hospital.model;

import com.letscode.hospital.dto.request.MedicoRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    private String email;

    @Column(nullable = false, unique = true)
    private String crm;

    public Medico(MedicoRequest medicoRequest) {
        this.nome = medicoRequest.getNome();
        this.telefone = medicoRequest.getTelefone();
        this.email = medicoRequest.getEmail();
        this.crm = medicoRequest.getCrm();
    }
}
