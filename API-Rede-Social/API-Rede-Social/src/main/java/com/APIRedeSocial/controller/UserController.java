package com.APIRedeSocial.controller;

import com.APIRedeSocial.infra.security.TokenService;
import com.APIRedeSocial.usuarios.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity login (@RequestBody @Valid DadosAutenticacao dados){
        var userNamePassword = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new DadosLoginResponse(token));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrar (@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){

        if(this.repository.findByEmail(dados.email()) != null) return ResponseEntity.badRequest().build();

        String senhaEncriptada = new BCryptPasswordEncoder().encode(dados.senha());

        var user = new User(dados.nome(), dados.email(), dados.bio(), dados.nomeUsuario(), senhaEncriptada, dados.numero(), dados.fotoLink());
        this.repository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(user));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemUsuario>> listar() {
        var list = repository.findAllByDeletadoFalse().stream().map(DadosListagemUsuario::new).toList();
        return ResponseEntity.ok(list);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInfo(dados);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
        return ResponseEntity.noContent().build();

    }

}
