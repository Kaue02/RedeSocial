package com.APIRedeSocial.usuarios;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Table (name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Boolean deletado;
        private LocalDate dataCriacao;
        private LocalDate dataAtualizacao;
        private String nome;
        private String nomeUsuario;
        private String senha;
        private String email;
        private String numero;
        private String fotoLink;
        private String bio;

        public User(DadosCadastroUsuario dados) {
                this.dataCriacao = LocalDate.now();
                this.bio = dados.bio();
                this.deletado = false;
                this.nome = dados.nome();
                this.nomeUsuario = dados.nomeUsuario();
                this.email = dados.email();
                this.numero = dados.numero();
                this.senha = dados.senha();
                this.fotoLink = dados.fotoLink();
        }

        public User(String nome, String email, String bio, String nomeUsuario, String senhaEncriptada, String numero, String fotoLink) {
                this.nome = nome;
                this.deletado = false;
                this.email = email;
                 this.bio = bio;
                 this.senha = senhaEncriptada;
                 this.nomeUsuario = nomeUsuario;
                 this.numero = numero;
                 this.fotoLink = fotoLink;
                 this.dataCriacao = LocalDate.now();
        }

        public void atualizarInfo(@Valid DadosAtualizacaoUsuario dados) {
                this.dataAtualizacao = LocalDate.now();
                if (dados.nome() != null) {
                        this.nome = dados.nome();
                }
                if (dados.nomeUsuario() != null) {
                        this.nomeUsuario = dados.nomeUsuario();
                }
                if (dados.email() != null) {
                        this.email = dados.email();
                }
                if (dados.fotoLink() != null) {
                        this.fotoLink = dados.fotoLink();
                }
                if (dados.numero() != null) {
                        this.numero = dados.numero();
                }
                if (dados.senha() != null) {
                        this.senha = dados.senha();
                }

        }
        public void excluir() {
                this.deletado = true;
        }



        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
        @Override
        public String getPassword() {
                return senha;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
