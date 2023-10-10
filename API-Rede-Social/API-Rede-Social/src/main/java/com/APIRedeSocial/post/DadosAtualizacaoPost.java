package com.APIRedeSocial.post;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPost(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String fotoLink,
        String videoLink,
        Boolean privado
) {
}
