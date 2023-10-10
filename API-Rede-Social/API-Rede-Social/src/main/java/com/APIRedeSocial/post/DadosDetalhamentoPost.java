package com.APIRedeSocial.post;

import com.APIRedeSocial.usuarios.User;

public record DadosDetalhamentoPost(Long id, User usuario, String titulo, String descricao, String videoLink, String fotoLink) {
    public DadosDetalhamentoPost(Post post) {
        this(post.getId(), post.getUsuario(), post.getTitulo(), post.getDescricao(),post.getVideoLink(),post.getFotoLink());
    }
}
