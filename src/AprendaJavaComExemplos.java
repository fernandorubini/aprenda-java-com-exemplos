import java.util.ArrayList;
import java.util.List;

enum Nivel {
    BASICO, INTERMEDIARIO, AVANCADO, TOTAL
}

class Usuario {
    String nome;
    String email;
    int idade;

    public Usuario(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}

class ConteudoEducacional {
    String nome;
    int duracaoHoras;
    Nivel nivel;

    public ConteudoEducacional(String nome, int duracaoHoras, Nivel nivel) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.nivel = nivel;
    }
}

class Formacao {
    String nome;
    Nivel nivel;
    List<ConteudoEducacional> conteudos = new ArrayList<>();
    List<Usuario> inscritos = new ArrayList<>();

    public Formacao(String nome, Nivel nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public void adicionarConteudo(ConteudoEducacional conteudo) {
        conteudos.add(conteudo);
    }

    public void matricular(Usuario usuario) {
        inscritos.add(usuario);
        System.out.println("Usuário " + usuario.nome + " matriculado na formação " + nome);
    }

    public void removerInscrito(Usuario usuario) {
        if (inscritos.remove(usuario)) {
            System.out.println("Usuário " + usuario.nome + " removido da formação " + nome);
        } else {
            System.out.println("Usuário " + usuario.nome + " não encontrado na formação.");
        }
    }

    public void imprimirGradeCurricular() {
        System.out.println("Formação: " + nome + " - Nível: " + nivel);
        System.out.println("Grade Curricular:");
        for (ConteudoEducacional cont : conteudos) {
            System.out.println("- " + cont.nome + " (" + cont.duracaoHoras + "h - " + cont.nivel + ")");
        }
    }

    public void imprimirListaDeInscritos() {
        System.out.println("Lista de Inscritos na formação " + nome + ":");
        for (Usuario user : inscritos) {
            System.out.println("- " + user.nome + " (" + user.email + " - " + user.idade + " anos)");
        }
    }
}

public class AprendaJavaComExemplos {
    public static void main(String[] args) {
        ConteudoEducacional flutter = new ConteudoEducacional("Flutter", 30, Nivel.BASICO);
        ConteudoEducacional dart = new ConteudoEducacional("Dart", 70, Nivel.INTERMEDIARIO);
        ConteudoEducacional firebase = new ConteudoEducacional("Firebase", 90, Nivel.AVANCADO);
        ConteudoEducacional devOuro = new ConteudoEducacional("Desenvolvedor de Ouro", 190, Nivel.TOTAL);

        Formacao formacaoFlutter = new Formacao("Especialização Flutter", Nivel.BASICO);
        formacaoFlutter.adicionarConteudo(flutter);
        formacaoFlutter.adicionarConteudo(firebase);

        Formacao formacaoDart = new Formacao("Especialização Dart", Nivel.INTERMEDIARIO);
        formacaoDart.adicionarConteudo(dart);

        Formacao formacaoCompleta = new Formacao("Desenvolvedor de Ouro", Nivel.TOTAL);
        formacaoCompleta.adicionarConteudo(devOuro);

        Usuario fernando = new Usuario("Fernando", "fernando@hotmail.com", 56);
        Usuario marcia = new Usuario("Marcia", "marcia@gmail.com", 25);
        Usuario gabriel = new Usuario("Gabriel", "gabriel@mail.terra.com.br", 18);

        formacaoFlutter.matricular(fernando);
        formacaoFlutter.matricular(marcia);
        formacaoDart.matricular(gabriel);

        formacaoFlutter.imprimirGradeCurricular();
        formacaoFlutter.imprimirListaDeInscritos();

        formacaoDart.imprimirGradeCurricular();
        formacaoDart.imprimirListaDeInscritos();

        formacaoCompleta.imprimirGradeCurricular();
        formacaoCompleta.imprimirListaDeInscritos();
    }
}
