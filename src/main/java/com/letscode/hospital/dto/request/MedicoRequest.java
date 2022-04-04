package com.letscode.hospital.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class MedicoRequest {

    @NotBlank
    @Size(min = 2)
    private String nome;

    @NotBlank
    private String telefone;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String crm;
}
