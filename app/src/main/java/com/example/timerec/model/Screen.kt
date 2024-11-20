package com.example.timerec.model

import kotlinx.serialization.Serializable

sealed class Screen() {
    @Serializable
    object MainScreen

    @Serializable
    data class DetailScreen(val userJson: String)

    @Serializable
    object PunchClockScreen

    @Serializable
    object LoginScreen

    @Serializable
    data class HistoryScreen(val clocksJson: String)

    @Serializable
    object AlarmScreen

}