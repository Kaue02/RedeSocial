package com.APIRedeSocial.post;

import com.APIRedeSocial.usuarios.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCriacaoPost(
        @NotBlank
        String titulo,
        String descricao,
        String fotoLink,
        String videoLink,
        LocalDate dataCriacao,
        @NotNull
        Boolean postPrivado,
        User usuario
) {
}
