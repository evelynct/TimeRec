package com.example.timerec.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timerec.R
import com.example.timerec.ui.theme.AccentColor
import com.example.timerec.ui.theme.BgColor
import com.example.timerec.ui.theme.Primary
import com.example.timerec.ui.theme.TextColor
import Clock
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.timerec.model.User
import com.example.timerec.ui.theme.Secondary
import com.example.timerec.view.ClockDetails
import com.example.timerec.view.getCurrentTime
import kotlinx.coroutines.delay

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SmallTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
    )
}

@Composable
fun MediumTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
    )
}

@Composable
fun HeadingComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextFieldComponent(labelValue: String, vectorResource: ImageVector) {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedContainerColor = Primary
            ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(
                imageVector = vectorResource,
                contentDescription = ""
            )
        }
    )
}

@Composable
fun TextFieldComponentOnChange(
    labelValue: String,
    vectorResource: ImageVector,
    onChange: (String) -> Unit
) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedContainerColor = Primary
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = vectorResource,
                contentDescription = ""
            )
        }
    )
}

@Composable
fun PasswordFieldComponent(labelValue: String, vectorResource: ImageVector ) {
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedContainerColor = Primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(
                imageVector = vectorResource,
                contentDescription = ""
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisible.value = !passwordVisible.value
                }
            ) {
                Icon(
                    imageVector =
                    if (passwordVisible.value) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    },
                    contentDescription =
                    if (passwordVisible.value) {
                        stringResource(id = R.string.hide_password)
                    } else {
                        stringResource(id = R.string.show_password)
                    }
                )
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
            }
        )
        SmallTextComponent(value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryCardComponent(clock: Clock) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var selectedClock by remember { mutableStateOf<Clock?>(null) }

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                isSheetOpen = true
                selectedClock = clock
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = clock.time,
                    fontSize = 18.sp,
                    color = if (clock.type == TypeClock.CLOCKIN) AccentColor else Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = if (clock.type == TypeClock.CLOCKIN) "Entrada" else "Saída",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Text(
                modifier = Modifier
                .padding(8.dp),
                text = clock.date,
                fontSize = 14.sp,
                textAlign = TextAlign.End,
                color = Color.Gray
            )
        }
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            containerColor = BgColor,
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

@Composable
fun PunchClockImage() {
        Image(
            painter = painterResource(id = R.drawable.scannerdigital),
            contentDescription = "Pressione para bater o ponto",
            modifier = Modifier
                .size(190.dp)
        )
}

@Composable
fun DetailUser(user: User) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .padding(10.dp),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Sua foto de perfil"
        )
        Column {
            MediumTextComponent(value = user.name.uppercase())
            SmallTextComponent(value = "Idade: ${user.age}")
            SmallTextComponent(value = "CPF: ${user.cpf}")
            SmallTextComponent(value = "Matrícula: ${user.matricula}")
            SmallTextComponent(value = "Cargo: ${user.position}")
            SmallTextComponent(value = "Saldo: ${if (user.balance < 0) "-${user.balance}" else "${user.balance}"}")
        }
    }
}

@Composable
fun ButtonComponent(value: String, onClick: () -> Unit ) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(TextColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = BgColor,
                fontFamily = FontFamily.Monospace
                )
        }
    }
}