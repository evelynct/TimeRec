package com.example.timerec.model

import Clock
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class User(
    val name: String,
    val cpf: String,
    val pswd: String,
    val age: Int,
    val balance: Int,
    val position: String,
    val matricula: Int,
    var clocks: MutableList<Clock>
) : Parcelable {

    fun addClock(clock: Clock) {
        clocks.add(clock)
    }

    fun removeClock(clock: Clock) {
        clocks.remove(clock)
    }
}
