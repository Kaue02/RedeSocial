package com.APIRedeSocial.controller;

import com.APIRedeSocial.usuarios.DadosListagemUsuario;
import com.APIRedeSocial.usuarios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usersPageble")
public class UserPagebleController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public Page<DadosListagemUsuario> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemUsuario::new);
    }



}
