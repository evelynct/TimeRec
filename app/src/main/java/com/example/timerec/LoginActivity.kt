import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import usuarios.*

@Composable
fun LoginScreen(usuarios: List<Usuario>, onLoginSuccess: (Usuario) -> Unit) {
    // Variáveis para armazenar as entradas do usuário
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var erroMensagem by remember { mutableStateOf("") }

    // Função chamada quando o botão de login é pressionado
    fun onLoginClick() {
        val usuarioLogado = validarLogin(email, senha, usuarios)

        if (usuarioLogado != null) {
            onLoginSuccess(usuarioLogado)  // Acesso liberado
        } else {
            erroMensagem = "E-mail ou senha inválidos"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFF800080)),  // Cor de fundo roxa
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tela de Login",
            style = MaterialTheme.typography.h5,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo para o e-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { /* Foca no próximo campo */ })
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para a senha
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { /* Realiza a validação */ })
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mensagem de erro
        if (erroMensagem.isNotEmpty()) {
            Text(text = erroMensagem, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de login
        Button(
            onClick = { onLoginClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    // Lista de usuários simulados para teste
    val usuarios = listOf(
        Usuario(1, "João", "joao@email.com", "senha123", TipoUsuario.ADMIN),
        Usuario(2, "Maria", "maria@email.com", "senha456", TipoUsuario.COMUM)
    )

    // Função de sucesso do login
    LoginScreen(usuarios = usuar
