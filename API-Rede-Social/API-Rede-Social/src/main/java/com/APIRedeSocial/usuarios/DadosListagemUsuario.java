package com.APIRedeSocial.usuarios;

public record DadosListagemUsuario(Long id, String nomeUsuario, String fotoLink, String nome, String numero) {
    public DadosListagemUsuario(User usuario) {
        this(usuario.getId(), usuario.getNomeUsuario(), usuario.getFotoLink(), usuario.getNome(), usuario.getNumero());
    }
}
