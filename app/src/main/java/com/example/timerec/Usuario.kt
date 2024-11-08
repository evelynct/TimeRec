package usuarios

// Modelo de dados do usuário
data class Usuario(
    val id: Int,             // ID do usuário (pode ser gerado automaticamente se usar banco de dados)
    val nome: String,        // Nome do usuário
    val email: String,       // Email do usuário
    val senha: String,       // Senha do usuário (em um sistema real, deve ser criptografada)
    val tipoUsuario: TipoUsuario // Tipo de usuário (ex: ADMIN, COMUM)
)

// Enum para tipos de usuário (isso pode ser expandido conforme a necessidade)
enum class TipoUsuario {
    ADMIN,
    COMUM
}


// Função para validar o login
fun validarLogin(email: String, senha: String, usuarios: List<Usuario>): Usuario? {
    // Encontra o usuário pelo e-mail
    val usuarioEncontrado = usuarios.find { it.email == email }

    // Verifica se o usuário existe e a senha é correta
    return if (usuarioEncontrado != null && usuarioEncontrado.senha == senha) {
        usuarioEncontrado // Retorna o usuário se a senha estiver correta
    } else {
        null // Retorna null caso o login seja inválido
    }
}
