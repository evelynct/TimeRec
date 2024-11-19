package com.example.timerec.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timerec.R
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun PunchClockScreen(
) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)
        .padding(64.dp)
    ) {
        CurrentTimeDisplay()
        Spacer(Modifier.padding(20.dp))
        PunchClock()
    }

}

@Composable
fun CurrentTimeDisplay() {
    val currentTime = remember { mutableStateOf(getCurrentTime()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            currentTime.value = getCurrentTime()
        }
    }

    Text(
        text = currentTime.value,
        style = TextStyle(fontSize = 48.sp, fontFamily = FontFamily.Monospace),
        color = Color.LightGray,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

fun getCurrentTime(): String {
    val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return format.format(Date())
}

@Composable
fun PunchClock() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.scannerdigital),
            contentDescription = "Pressione para bater o ponto",
            modifier = Modifier
                .size(170.dp)
                .align(Alignment.Center)
        )
    }
}
