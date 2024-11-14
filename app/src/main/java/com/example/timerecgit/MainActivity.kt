package com.example.timerec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.timerec.view.LoginScreen
import com.example.timerec.view.TelaInicial
import com.example.timerec.model.Usuario
import com.example.timerec.controller.LoginController

class MainActivity : ComponentActivity() {
    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginController = LoginController()

        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Surface {
                    // Iniciando na tela de login e passando a função onLoginSuccess para navegar à tela inicial
                    LoginScreen(
                        loginController = loginController,
                        onLoginSuccess = { usuario ->
                            // Navega para a TelaInicial após o login
                            navController.navigate("home")
                        }
                    )
                }
            }
        }
    }
}
