package com.example.timerecgit.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.timerecgit.controller.LoginController //erro nessa importação

import com.example.timerecgit.model.Usuario

@Composable
fun LoginScreen(loginController: LoginController, onLoginSuccess: (Usuario) -> Unit) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val erro = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            label = { Text("Senha") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                loginController.autenticar(
                    email.value,
                    senha.value,
                    onSuccess = { usuario -> onLoginSuccess(usuario) },
                    onFailure = { erro.value = true }
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        if (erro.value) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Email ou senha inválidos",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}