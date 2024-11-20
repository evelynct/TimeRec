package com.example.timerec

import Clock
import TypeClock
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timerec.controller.getUserTest
import com.example.timerec.view.Appbar
import com.example.timerec.view.DetailScreen
import com.example.timerec.view.DrawerBody
import com.example.timerec.view.DrawerHeader
import com.example.timerec.model.ItemMenu
import com.example.timerec.view.MainScreen
import com.example.timerec.model.Screen
import com.example.timerec.model.User
import com.example.timerec.view.AlarmScreen
import com.example.timerec.view.HistoryScreen
import com.example.timerec.view.LoginScreen
import com.example.timerec.view.PunchClockScreen
import com.example.timerec.ui.theme.TimeRecTheme
import com.example.timerec.view.getFormattedDate
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeRecTheme {
                val usuario = getUserTest()

                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                val userJson = Json.encodeToString(usuario)
                val clocksJson = Json.encodeToString(usuario.clocks)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.primary)
                        ) {
                            Column {
                                DrawerHeader()
                                DrawerBody(
                                    items = listOf(
                                        ItemMenu(
                                            id = "Home",
                                            title = "Home",
                                            contentDescription = "Go to Home screen",
                                            icon = Icons.Default.Home
                                        ),
                                        ItemMenu(
                                            id = "Login",
                                            title = "Login",
                                            contentDescription = "Go to Login screen",
                                            icon = Icons.Default.AccountCircle
                                        ),
                                        ItemMenu(
                                            id = "PunchClock",
                                            title = "Bater Ponto",
                                            contentDescription = "Go to Clock in or out",
                                            icon = Icons.Default.CheckCircle
                                        ),
                                        ItemMenu(
                                            id = "Details",
                                            title = "Detalhes",
                                            contentDescription = "Detalhes",
                                            icon = Icons.Default.Face
                                        ),
                                        ItemMenu(
                                            id = "History",
                                            title = "Histórico",
                                            contentDescription = "Go to History page",
                                            icon = Icons.Default.DateRange
                                        ),
                                        ItemMenu(
                                            id = "Alarm",
                                            title = "Alarme",
                                            contentDescription = "Definir um alarme",
                                            icon = Icons.Default.Create
                                        ),
                                    ),
                                    onItemClick = { item ->
                                        when (item.id) {
                                            "Home" -> navController.navigate(Screen.MainScreen)
                                            "Details" -> navController.navigate(Screen.DetailScreen(userJson))
                                            "PunchClock" -> navController.navigate(Screen.PunchClockScreen)
                                            "Login" -> navController.navigate(Screen.LoginScreen)
                                            "History" -> navController.navigate(Screen.HistoryScreen(clocksJson))
                                            "Alarm" -> navController.navigate(Screen.AlarmScreen)
                                        }
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                    Scaffold(
                        topBar = {
                            Appbar(onNavigationIconClick = { scope.launch { drawerState.open() } })
                        },
                        content = { paddingValues ->
                            Box(
                                modifier = Modifier
                                    .padding(paddingValues)
                                    .fillMaxSize()
                            ) {
                                NavHost(
                                    navController = navController,
                                    startDestination = Screen.MainScreen
                                ) {
                                    composable<Screen.MainScreen> {
                                        MainScreen(navController = navController)
                                    }
                                    composable<Screen.DetailScreen> {
                                        DetailScreen(usuario)
                                    }
                                    composable<Screen.PunchClockScreen> {
                                        PunchClockScreen()
                                    }
                                    composable<Screen.LoginScreen> {
                                        LoginScreen()
                                    }
                                    composable<Screen.HistoryScreen> {
                                        HistoryScreen(usuario.clocks)
                                    }
                                    composable<Screen.AlarmScreen> {
                                        AlarmScreen()
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
