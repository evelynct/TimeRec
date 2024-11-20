package com.example.timerec.controller

import Clock
import com.example.timerec.model.User
import com.example.timerec.view.getFormattedDate

fun getUserTest(): User {
    return User(
        name = "Carlos",
        cpf = "123.456.789-10",
        age = 20,
        pswd = "seloco",
        balance = 10,
        position = "CEO",
        matricula = 7484,
        clocks = mutableListOf(
            Clock(
                id = 1,
                time = "12:40",
                local = "Office",
                type = TypeClock.CLOCKIN,
                date = getFormattedDate("19/11/2024")
            ),
            Clock(
                id = 2,
                time = "12:50",
                local = "Office",
                type = TypeClock.CLOCKOUT,
                date = getFormattedDate("19/11/2024")
            ),
            Clock(
                id = 3,
                time = "12:50",
                local = "Office",
                type = TypeClock.CLOCKOUT,
                date = getFormattedDate("19/11/2024")
            ),
            Clock(
                id = 4,
                time = "12:50",
                local = "Office",
                type = TypeClock.CLOCKOUT,
                date = getFormattedDate("19/11/2024")
            )
        )
    )
}