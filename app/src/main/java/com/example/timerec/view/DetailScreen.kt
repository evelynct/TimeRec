package com.example.timerec.view

import Clock
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timerec.model.User
import com.example.timerec.components.DetailUser
import com.example.timerec.components.HistoryCardComponent
import com.example.timerec.controller.getUserTest
import com.example.timerec.ui.theme.BgColor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DetailScreen(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
    ){
        DetailUser(user)
        LazyRow (
            modifier = Modifier
                .padding(16.dp)
        ) {
            items(user.clocks) { clock ->
                HistoryCardComponent(clock)
            }
        }
    }
}

fun getFormattedDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("dd/MM/yyyy")
    val outputFormat = SimpleDateFormat("dd/MM")
    val date: Date = inputFormat.parse(dateString) ?: Date()
    return outputFormat.format(date)
}



@Preview
@Composable
private fun PreviewDetailScreen() {
    val usuario = getUserTest()

    DetailScreen(usuario)
}


