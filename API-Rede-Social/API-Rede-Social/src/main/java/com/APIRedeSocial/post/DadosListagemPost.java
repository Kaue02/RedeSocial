package com.APIRedeSocial.post;

public record DadosListagemPost(Long id, String titulo, String descricao, String fotoLink, String videoLink) {
    public DadosListagemPost(Post post) {
        this(post.getId(), post.getTitulo(), post.getDescricao(), post.getFotoLink(), post.getVideoLink());
    }
}
