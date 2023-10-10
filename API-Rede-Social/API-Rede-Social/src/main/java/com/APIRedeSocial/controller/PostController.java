package com.APIRedeSocial.controller;

import com.APIRedeSocial.post.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criarPost(@RequestBody @Valid DadosCriacaoPost dados, UriComponentsBuilder uriBuilder) {
        var post = new Post(dados);
        repository.save(post);

        var uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPost(post));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPost(@RequestBody @Valid DadosAtualizacaoPost dados) {
        var post = repository.getReferenceById(dados.id());
        post.atualizarPost(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPost(post));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPost(@PathVariable Long id) {
        var post = repository.getReferenceById(id);
        post.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemPost>> listar() {
        var list = repository.findAllByDeletadoFalse().stream().map(DadosListagemPost::new).toList();
        return ResponseEntity.ok(list);

    }

}
