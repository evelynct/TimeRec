package com.example.timerecgit.controller

import com.example.timerecgit.model.Usuario

class LoginController {
    private val usuarios = listOf(
        Usuario(1, "João Silva", "joao.silva@email.com", "senha123", Usuario.TipoUsuario.COMUM),
        Usuario(2, "Maria Oliveira", "maria.oliveira@email.com", "senha456", Usuario.TipoUsuario.ADMIN)
    )

    fun autenticar(email: String, senha: String, onSuccess: (Usuario) -> Unit, onFailure: () -> Unit) {
        val usuario = usuarios.find { it.email == email && it.senha == senha }
        if (usuario != null) {
            onSuccess(usuario)
        } else {
            onFailure()
        }
    }
}
