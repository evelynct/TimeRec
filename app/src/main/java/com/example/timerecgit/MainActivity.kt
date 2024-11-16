package com.example.timerec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController // erro
import com.example.timerecgit.view.LoginScreen
import com.example.timerecgit.view.TelaInicial
import com.example.timerecgit.model.Usuario
import com.example.timerecgit.controller.LoginController

class MainActivity : ComponentActivity() {
    private lateinit var loginController: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginController = LoginController()

        setContent {
            val navController = rememberNavController() // erro
            MaterialTheme {
                Surface {
                    LoginScreen(
                        loginController = loginController,
                        onLoginSuccess = { usuario -> // erro no usuario
                            navController.navigate("home")
                        }
                    )
                }
            }
        }
    }
}
