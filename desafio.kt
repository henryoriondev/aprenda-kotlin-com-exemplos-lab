// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe simples para representar um usuário (poderia ter mais atributos, como nome, email, etc.)
class Usuario(val nome: String) {
    override fun toString(): String = nome
}

// Conteúdo educacional: aula/módulo com nome e duração em minutos (default 60)
data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String = "$nome (${duracao} min)"
}

// Formação (curso): tem nome, lista de conteúdos e lista de inscritos
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    // Implementação do TODO: matricular um usuário
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("Usuário ${usuario.nome} já está matriculado na formação '$nome'.")
        } else {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado com sucesso na formação '$nome'.")
        }
    }

    // Método auxiliar para calcular duração total da formação
    fun duracaoTotal(): Int = conteudos.sumOf { it.duracao }

    // Método auxiliar para exibir inscritos
    fun exibirInscritos() {
        if (inscritos.isEmpty()) {
            println("Nenhum inscrito na formação '$nome' ainda.")
        } else {
            println("Inscritos na formação '$nome':")
            inscritos.forEachIndexed { index, usuario ->
                println("${index + 1}. ${usuario.nome}")
            }
        }
    }
}

fun main() {
    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 45)
    val conteudo2 = ConteudoEducacional("Classes e Objetos", 90)
    val conteudo3 = ConteudoEducacional("Null Safety e Coleções", 75)
    val conteudo4 = ConteudoEducacional("Coroutines Básicas", 120)

    // Criação de formações (cursos)
    val formacaoBasica = Formacao(
        nome = "Kotlin Básico",
        conteudos = listOf(conteudo1, conteudo2)
    )

    val formacaoAvancada = Formacao(
        nome = "Kotlin Avançado",
        conteudos = listOf(conteudo3, conteudo4)
    )

    // Criação de usuários
    val henry = Usuario("Henry")
    val ana = Usuario("Ana")
    val joao = Usuario("João")

    // Simulação de matrículas
    println("=== Simulando matrículas ===")
    formacaoBasica.matricular(henry)
    formacaoBasica.matricular(ana)
    formacaoBasica.matricular(henry)  // tenta matricular novamente → deve mostrar mensagem

    formacaoAvancada.matricular(joao)
    formacaoAvancada.matricular(ana)

    // Exibição dos resultados
    println("\n=== Resultados das formações ===")

    println("\nFormação: ${formacaoBasica.nome}")
    println("Conteúdos (${formacaoBasica.conteudos.size}): ${formacaoBasica.conteudos.joinToString()}")
    println("Duração total: ${formacaoBasica.duracaoTotal()} minutos")
    formacaoBasica.exibirInscritos()

    println("\nFormação: ${formacaoAvancada.nome}")
    println("Conteúdos (${formacaoAvancada.conteudos.size}): ${formacaoAvancada.conteudos.joinToString()}")
    println("Duração total: ${formacaoAvancada.duracaoTotal()} minutos")
    formacaoAvancada.exibirInscritos()

    // Sugestões de evolução (como pedido no TODO)
    println("\n=== Ideias de evolução do modelo ===")
    println("- Adicionar propriedade 'nivel: Nivel' na Formacao")
    println("- Incluir data de matrícula e status (ativo/concluído) no inscrito")
    println("- Método para concluir formação e emitir certificado")
    println("- Filtrar formações por nível ou duração")
    println("- Usar sealed class para tipos de conteúdo (vídeo, artigo, exercício)")
}