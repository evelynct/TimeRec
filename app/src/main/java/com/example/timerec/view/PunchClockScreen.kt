package com.example.timerec.view

import Clock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timerec.components.ButtonComponent
import com.example.timerec.components.CurrentTimeDisplay
import com.example.timerec.components.PunchClockImage
import com.example.timerec.controller.getUserTest
import com.example.timerec.ui.theme.BgColor
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun PunchClockScreen(
) {
    var clocks by remember { mutableStateOf(getUserTest().clocks) }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(BgColor)
        .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CurrentTimeDisplay()
        PunchClockImage()
        ButtonComponent(value = "Bater Ponto", onClick = {
            println("Punch Clock Button Clicked")
            punchClock()
        })
    }

}

fun getCurrentTime(): String {
    val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return format.format(Date())
}


fun punchClock() {
    val usuario = getUserTest()
    val clockId = if (usuario.clocks.isNotEmpty()) {
        usuario.clocks.maxOf { it.id } + 1
    } else {
        1
    }

    val newClock = Clock(
        id = clockId,
        time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
        local = "Office",
        type = TypeClock.CLOCKIN,
        date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"))
    )
    usuario.addClock(newClock)
}

@Preview
@Composable
private fun Preview() {
    PunchClockScreen()
}
