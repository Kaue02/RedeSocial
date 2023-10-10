package com.APIRedeSocial.post;

import com.APIRedeSocial.usuarios.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "post")
@Entity(name = "Post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean deletado;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
    private String titulo;
    private String descricao;
    private String fotoLink;
    private String videoLink;
    private Boolean postPrivado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    public Post(DadosCriacaoPost dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.videoLink = dados.videoLink();
        this.fotoLink = dados.fotoLink();
        this.dataCriacao = LocalDate.now();
        this.postPrivado = dados.postPrivado();
        this.deletado = false;
        this.usuario = dados.usuario();/*dados.idUsuario()*/
    }

    public void atualizarPost(@Valid DadosAtualizacaoPost dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.fotoLink() != null) {
            this.fotoLink = dados.fotoLink();
        }
        if (dados.videoLink() != null) {
            this.videoLink = dados.videoLink();
        }if (dados.privado() != null) {
            this.postPrivado = dados.privado();
        }
        this.dataAtualizacao = LocalDate.now();
    }

    public void excluir() {
        this.deletado = true;
    }

}
