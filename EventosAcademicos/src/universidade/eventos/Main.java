package universidade.eventos;

public class Main {
    public static void main(String[] args) {
        // Locais
        Sala sala1 = new Sala("Sala A101", 30, "Bloco A", 101, true);
        Auditorio auditorio1 = new Auditorio("Auditório Central", 200, "Bloco Principal", true, true);
        Laboratorio lab1 = new Laboratorio("Lab Info 2", 25, "Bloco C", 25, "Informática");

        // Pessoas Responsáveis
        Instrutor instrutor1 = new Instrutor("Carlos Silva", "carlos@uni.edu", "Mestre em TI", "Machine Learning");
        Organizador organizador1 = new Organizador("Marina Souza", "marina@uni.edu", "Coordenadora de Eventos");

        // Participantes
        Participante p1 = new Participante("João", "111.222.333-44", "joao@aluno.com", "Engenharia de Software");
        Participante p2 = new Participante("Ana", "555.666.777-88", "ana@aluno.com", "Ciência de Dados e IA");

        // Eventos
        Palestra palestra = new Palestra("IA no Mercado Atual", "10/12/2025", 2, 1500.00,
                auditorio1, "Dr. Pedro Lima", "pedro@tech.com", "Google Research");

        Minicurso minicurso = new Minicurso("Introdução ao Python", "12/12/2025", 4, 800.00, sala1, 8);
        minicurso.adicionarInstrutor(instrutor1);
        minicurso.adicionarMaterial("Apostila PDF");
        minicurso.adicionarMaterial("Notebook Jupyter");

        Seminario seminario = new Seminario("Tópicos Avançados em Química", "15/12/2025", 3, 500.00, lab1,
                "Reações Orgânicas", "Lucas Almeida", "Prof. Dr. Roberto Tavares");

        // Inscrições
        palestra.adicionarParticipante(p1);
        palestra.adicionarParticipante(p2);
        minicurso.adicionarParticipante(p1);
        seminario.adicionarParticipante(p2);

        // Impressão
        System.out.println("\n=== EVENTOS CADASTRADOS ===");
        System.out.println(palestra);
        System.out.println(minicurso);
        System.out.println(seminario);

        System.out.println("\n=== ORGANIZAÇÃO ===");
        System.out.println(instrutor1);
        System.out.println(organizador1);

        System.out.println("\n=== PARTICIPANTES ===");
        System.out.println(p1);
        System.out.println(p2);
    }
}
