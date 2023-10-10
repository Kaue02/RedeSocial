package com.APIRedeSocial.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String bio,
        @NotBlank
        String nomeUsuario,
        @NotBlank
        String senha,
        String numero,
        String fotoLink
) {

}
