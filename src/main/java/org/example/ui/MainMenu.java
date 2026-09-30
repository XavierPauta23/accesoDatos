package org.example.ui;

import jakarta.inject.Inject;
import org.example.dao.model.Usuario;

import java.util.Scanner;

public class MainMenu {

    private final UsuarioUi usuarioUi;

       @Inject
    public MainMenu(UsuarioUi usuarioUi){
        this.usuarioUi = usuarioUi;
    }

    public void run(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hospital App");
            System.out.println("Por favor, introduzca sus credenciales");

            boolean logueado = false;
            while (!logueado){
                System.out.println("Usuario: ");
                String username = scanner.nextLine().trim();
                if(username.isEmpty()) continue;

                System.out.println("Contraseña: ");
                String password = scanner.nextLine().trim();
                if(password.isEmpty()) continue;
                Usuario credencialesUI = new Usuario(username, password);
                logueado = usuarioUi.login(credencialesUI);
            }
        }
    }
}
