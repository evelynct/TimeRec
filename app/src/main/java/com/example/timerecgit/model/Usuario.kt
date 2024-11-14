package com.example.timerecgit.model


data class Usuario(
    val id: Int,
    val nome: String,
    val email: String,
    val senha: String,
    val tipo: TipoUsuario
) {
    enum class TipoUsuario {
        COMUM,
        ADMIN
    }
}