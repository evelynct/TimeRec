package com.example.timerec.view

import Clock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timerec.model.User
import com.example.timerec.components.HistoryCardComponent
import com.example.timerec.components.NormalTextComponent
import com.example.timerec.controller.getUserTest
import com.example.timerec.ui.theme.BgColor
import java.text.SimpleDateFormat


@Composable
fun HistoryScreen(clocks: List<Clock>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp),
        ) {
            items(clocks) { clock ->
                HistoryCardComponent(clock)
            }
        }
    }
}



@Composable
fun ClockDetails(clock: Clock) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        NormalTextComponent(value = "ID: ${clock.id}")
        NormalTextComponent(value = "Hora: ${clock.time}")
        NormalTextComponent(value = "Tipo: " + if (clock.type == TypeClock.CLOCKIN) "Entrada" else "Saída")
        NormalTextComponent(value = "Local: ${clock.local}")
    }
}

@Preview
@Composable
private fun Preview() {
    val usuario = getUserTest()

    HistoryScreen(usuario.clocks)

}