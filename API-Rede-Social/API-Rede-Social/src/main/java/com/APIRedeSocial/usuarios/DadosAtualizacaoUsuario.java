package com.APIRedeSocial.usuarios;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String nomeUsuario,
        String email,
        String senha,
        String numero,
        String fotoLink
) {
}
