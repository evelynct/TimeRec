package com.example.timerec.View

import Clock
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(clocks: List<Clock>) {
    // State to control the visibility of the bottom sheet
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    // Variable to store the currently selected clock
    var selectedClock by remember { mutableStateOf<Clock?>(null) }

    // Main content (LazyColumn)
    LazyColumn {
        items(clocks) { clock ->
            Text(
                text = clock.time,
                modifier = Modifier
                    .clickable {
                        isSheetOpen = true
                        selectedClock = clock
                    }
            )
        }
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }

        ) {
            selectedClock?.let { ClockDetails(it) }
        }
    }
}

@Composable
fun ClockDetails(clock: Clock) {
    Column {
        Text(text = "ID: ${clock.id}")
        Text(text = "Hora: ${clock.time}")
        Text(text = "Tipo: ${clock.type}")
        Text(text = "Local: ${clock.local}")
    }
}