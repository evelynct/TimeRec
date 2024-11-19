package com.example.timerec.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.timerec.Controller.AndroidAlarmScheduler
import com.example.timerec.Model.AlarmItem
import com.example.timerec.Model.AlarmScheduler
import java.time.LocalDateTime


@Composable
fun AlarmScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scheduler = AndroidAlarmScheduler(context)
    var alarmItem: AlarmItem? = null

    var secondsText by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = secondsText,
            onValueChange = { secondsText = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Alarme em segundos") }
        )
        OutlinedTextField(
            value = message,
            onValueChange = { message = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Mensagem") }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    alarmItem = AlarmItem(
                        time = LocalDateTime.now().plusSeconds(secondsText.toLong()),
                        message = message
                    )
                    alarmItem?.let(scheduler::schedule)
                    secondsText = ""
                    message =""
                }
            ) {
                Text(text = "Definir")
            }
            Button(
                onClick = {
                    alarmItem?.let(scheduler::cancel)
                }
            ) {
                Text(text = "Cancelar")
            }
        }
    }

}

