package org.example.dao.repositories;

import org.example.dao.model.Usuario;

public interface UsuarioRepository {
    Usuario get(String username);
}
