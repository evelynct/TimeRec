package com.example.timerec.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.timerec.Model.User
import com.example.timerec.R

@Composable
fun DetailScreen(user: User) {
    Box(){
        DetailUser(user)
    }
}

@Composable
fun DetailUser(user: User) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Sua foto de perfil"
        )
        Column {
            Text(text = user.name.uppercase())
            Text(text = "Idade: ${user.age}")
            Text(text = "CPF: ${user.cpf}")
            Text(text = "Matrícula: ${user.matricula}")
            Text(text = "Cargo: ${user.position}")
            Text(text = "Saldo: ${if (user.balance < 0) "-${user.balance}" else "${user.balance}"}")
        }
    }
}
