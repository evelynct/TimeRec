package com.example.timerec.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
fun LoginScreen(modifier: Modifier = Modifier) {
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
            HeadingComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))

            TextFieldComponent(
                labelValue = stringResource(R.string.first_name),
                vectorResource = Icons.Default.AccountCircle
            )

            PasswordFieldComponent(
                labelValue = stringResource(R.string.password),
                vectorResource = Icons.Default.Lock
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen(modifier: Modifier = Modifier) {
    LoginScreen()
}
