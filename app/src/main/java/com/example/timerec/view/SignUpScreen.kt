package com.example.timerec.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timerec.R
import com.example.timerec.components.*
import com.example.timerec.ui.theme.BgColor

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
            .padding(28.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(BgColor)
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))

            TextFieldComponent(
                labelValue = stringResource(R.string.first_name),
                vectorResource = Icons.Default.AccountCircle
            )

            TextFieldComponent(
                labelValue = stringResource(R.string.last_name),
                vectorResource = Icons.Default.AccountCircle
            )

            TextFieldComponent(
                labelValue = stringResource(R.string.email),
                vectorResource = Icons.Default.Email
            )

            PasswordFieldComponent(
                labelValue = stringResource(R.string.password),
                vectorResource = Icons.Default.Lock
            )

            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions))

        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(modifier: Modifier = Modifier) {
    SignUpScreen()
}
