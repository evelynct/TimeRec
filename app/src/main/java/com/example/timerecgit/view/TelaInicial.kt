package com.example.timerecgit.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.timerecgit.model.Usuario

@Composable
fun TelaInicial(usuario: Usuario) {
    Text("Bem-vindo, ${usuario.nome}")
}