import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import usuarios.Usuario
import usuarios.TipoUsuario
import com.exemplo.pontotrabalho.ui.theme.PontoTrabalhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PontoTrabalhoTheme {
                // Lista de usuários (normalmente viriam de um banco de dados)
                val usuarios = listOf(
                    Usuario(1, "João", "joao@email.com", "senha123", TipoUsuario.ADMIN),
                    Usuario(2, "Maria", "maria@email.com", "senha456", TipoUsuario.COMUM)
                )

                // Chama a tela de login
                LoginScreen(usuarios = usuarios) { usuario ->
                    // Ação após login bem-sucedido
                    println("Login bem-sucedido! Bem-vindo, ${usuario.nome}")
                }
            }
        }
    }
}
