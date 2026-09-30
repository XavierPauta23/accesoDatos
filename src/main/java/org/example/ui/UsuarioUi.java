package org.example.ui;

import jakarta.inject.Inject;
import org.example.dao.model.Usuario;
import org.example.domain.services.UsuarioService;

public class UsuarioUi {
    private final UsuarioService usuarioService;

    @Inject
    public UsuarioUi(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public boolean login(Usuario credencialesUi){

    }
}
