package org.example.ui;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.dto.UsuarioDTO;
import org.example.domain.services.UsuarioService;

@Slf4j
public class UsuarioUI {
    private final UsuarioService usuarioService;

    @Inject
    public UsuarioUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void login() {
        IO.println("Por favor, introduzca sus credenciales");

        while (true) {
            IO.println("Usuario: ");
            String username = IO.readln();
            if (username.isEmpty()) continue;

            IO.println("Contraseña: ");
            String password = IO.readln();
            if (password.isEmpty()) continue;
            UsuarioDTO credenciales = new UsuarioDTO(username, password);

            boolean ok = usuarioService.login(credenciales);
            if (ok) {
                IO.println("Bienvenido al sistema.");
                log.info("bienvenido");
                break;
            } else {
                IO.println("Credenciales incorrectas, inténtelo de nuevo.");
            }
        }
    }
}