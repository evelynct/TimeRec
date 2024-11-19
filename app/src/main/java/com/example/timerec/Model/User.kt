package com.example.timerec.Model

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
    val clocks: List<Clock>

) : Parcelable
