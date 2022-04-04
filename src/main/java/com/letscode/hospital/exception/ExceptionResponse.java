package com.letscode.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {

    private String campo;
    private String mensagem;
    private LocalDateTime horario;
}
