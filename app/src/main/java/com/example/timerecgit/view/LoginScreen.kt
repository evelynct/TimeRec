package com.example.timerecgit.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.timerec.controller.LoginController
import com.example.timerec.model.Usuario

@Composable
fun LoginScreen(loginController: LoginController, onLoginSuccess: (Usuario) -> Unit) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val erro = remember { mutableStateOf(false) }

    Column {
        TextField(value = email.value, onValueChange = { email.value = it }, label = { Text("Email") })
        TextField(value = senha.value, onValueChange = { senha.value = it }, label = { Text("Senha") })

        if (erro.value) {
            Text("Email ou senha inválidos", color = MaterialTheme.colorScheme.error)
        }

        Button(onClick = {
            loginController.autenticar(
                email.value, senha.value,
                onSuccess = { usuario -> onLoginSuccess(usuario) },
                onFailure = { erro.value = true }
            )
        }) {
            Text("Entrar")
        }
    }
}