package com.APIRedeSocial.usuarios;

public record DadosDetalhamentoUsuario(Long id, String nome, String nomeUsuario, String email, String numero, String fotoLink) {

    public DadosDetalhamentoUsuario(User usuario) {
        this(usuario.getId(),usuario.getNome(),usuario.getNomeUsuario(),usuario.getEmail(),usuario.getNome(),usuario.getFotoLink());
    }

}
