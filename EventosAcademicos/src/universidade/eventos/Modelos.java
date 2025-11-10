package universidade.eventos;
import java.util.List;
import java.util.ArrayList;

// ========================= CLASSE BASES ==============================

class Local {
    private String nome;
    private int capacidadeMaxima;
    private String bloco;

    public Local(String nome, int capacidadeMaxima, String bloco) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.bloco = bloco;
    }

    public String getNome() { return nome; }
    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public String getBloco() { return bloco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCapacidadeMaxima(int capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    @Override
    public String toString() {
        return nome + " (Bloco: " + bloco + ", Capacidade: " + capacidadeMaxima + ")";
    }
}

// ========================= SUBCLASSES DE LOCAL ==============================

class Sala extends Local {
    private int numeroSala;
    private boolean temEquipamentoMultimidia;

    public Sala(String nome, int capacidadeMaxima, String bloco, int numeroSala, boolean temEquipamentoMultimidia) {
        super(nome, capacidadeMaxima, bloco);
        this.numeroSala = numeroSala;
        this.temEquipamentoMultimidia = temEquipamentoMultimidia;
    }

    public int getNumeroSala() { return numeroSala; }
    public boolean isTemEquipamentoMultimidia() { return temEquipamentoMultimidia; }

    public void setNumeroSala(int numeroSala) { this.numeroSala = numeroSala; }
    public void setTemEquipamentoMultimidia(boolean temEquipamentoMultimidia) { this.temEquipamentoMultimidia = temEquipamentoMultimidia; }

    @Override
    public String toString() {
        return super.toString() + " - Sala " + numeroSala + (temEquipamentoMultimidia ? " (Com multimídia)" : " (Sem multimídia)");
    }
}

class Auditorio extends Local {
    private boolean temSistemaSom;
    private boolean temTraducaoSimultanea;

    public Auditorio(String nome, int capacidadeMaxima, String bloco, boolean temSistemaSom, boolean temTraducaoSimultanea) {
        super(nome, capacidadeMaxima, bloco);
        this.temSistemaSom = temSistemaSom;
        this.temTraducaoSimultanea = temTraducaoSimultanea;
    }

    public boolean isTemSistemaSom() { return temSistemaSom; }
    public boolean isTemTraducaoSimultanea() { return temTraducaoSimultanea; }

    public void setTemSistemaSom(boolean temSistemaSom) { this.temSistemaSom = temSistemaSom; }
    public void setTemTraducaoSimultanea(boolean temTraducaoSimultanea) { this.temTraducaoSimultanea = temTraducaoSimultanea; }

    @Override
    public String toString() {
        return super.toString() + (temSistemaSom ? " (Com som)" : "") + (temTraducaoSimultanea ? " (Com tradução)" : "");
    }
}

class Laboratorio extends Local {
    private int numeroComputadores;
    private String tipo;

    public Laboratorio(String nome, int capacidadeMaxima, String bloco, int numeroComputadores, String tipo) {
        super(nome, capacidadeMaxima, bloco);
        this.numeroComputadores = numeroComputadores;
        this.tipo = tipo;
    }

    public int getNumeroComputadores() { return numeroComputadores; }
    public String getTipo() { return tipo; }

    public void setNumeroComputadores(int numeroComputadores) { this.numeroComputadores = numeroComputadores; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return super.toString() + " - Lab " + tipo + " (" + numeroComputadores + " computadores)";
    }
}

// ========================= PESSOAS RESPONSÁVEIS ==============================

abstract class PessoaResponsavel {
    private String nome;
    private String email;

    public PessoaResponsavel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}

class Instrutor extends PessoaResponsavel {
    private String formacao;
    private String areaEspecializacao;

    public Instrutor(String nome, String email, String formacao, String areaEspecializacao) {
        super(nome, email);
        this.formacao = formacao;
        this.areaEspecializacao = areaEspecializacao;
    }

    public String getFormacao() { return formacao; }
    public String getAreaEspecializacao() { return areaEspecializacao; }

    public void setFormacao(String formacao) { this.formacao = formacao; }
    public void setAreaEspecializacao(String areaEspecializacao) { this.areaEspecializacao = areaEspecializacao; }

    @Override
    public String toString() {
        return super.toString() + " - Instrutor (" + formacao + ", " + areaEspecializacao + ")";
    }
}

class Organizador extends PessoaResponsavel {
    private String funcaoAdministrativa;

    public Organizador(String nome, String email, String funcaoAdministrativa) {
        super(nome, email);
        this.funcaoAdministrativa = funcaoAdministrativa;
    }

    public String getFuncaoAdministrativa() { return funcaoAdministrativa; }
    public void setFuncaoAdministrativa(String funcaoAdministrativa) { this.funcaoAdministrativa = funcaoAdministrativa; }

    @Override
    public String toString() {
        return super.toString() + " - Organizador (" + funcaoAdministrativa + ")";
    }
}

// ========================= PARTICIPANTE ==============================

class Participante {
    private String nome;
    private String cpf;
    private String email;
    private String curso;

    public Participante(String nome, String cpf, String email, String curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.curso = curso;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getCurso() { return curso; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setCurso(String curso) { this.curso = curso; }

    @Override
    public String toString() {
        return nome + " (" + curso + ")";
    }
}

// ========================= EVENTO (SUPERCLASSE) ==============================

abstract class Evento {
    protected String titulo;
    protected String data; 
    protected int duracaoHoras;
    protected double orcamento;
    protected Local local;
    protected List<Participante> participantes;

    public Evento(String titulo, String data, int duracaoHoras, double orcamento, Local local) {
        this.titulo = titulo;
        this.data = data;
        this.duracaoHoras = duracaoHoras;
        this.orcamento = orcamento;
        this.local = local;
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante(Participante p) {
        if (participantes.size() < local.getCapacidadeMaxima()) {
            participantes.add(p);
        } else {
            System.out.println("Não há vagas disponíveis para este evento!");
        }
    }

    @Override
    public String toString() {
        return titulo + " em " + data + " (" + duracaoHoras + "h, R$ " + orcamento + ") - Local: " + local;
    }
}

// ========================= SUBCLASSES DE EVENTO ==============================

class Palestra extends Evento {
    private String nomePalestrante;
    private String emailPalestrante;
    private String instituicao;

    public Palestra(String titulo, String data, int duracaoHoras, double orcamento, Local local,
                    String nomePalestrante, String emailPalestrante, String instituicao) {
        super(titulo, data, duracaoHoras, orcamento, local);
        this.nomePalestrante = nomePalestrante;
        this.emailPalestrante = emailPalestrante;
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return super.toString() + " - Palestrante: " + nomePalestrante + " (" + instituicao + ")";
    }
}

class Minicurso extends Evento {
    private List<Instrutor> instrutores;
    private List<String> materiaisApoio;
    private int cargaHoraria;

    public Minicurso(String titulo, String data, int duracaoHoras, double orcamento, Local local, int cargaHoraria) {
        super(titulo, data, duracaoHoras, orcamento, local);
        this.cargaHoraria = cargaHoraria;
        this.instrutores = new ArrayList<>();
        this.materiaisApoio = new ArrayList<>();
    }

    public void adicionarInstrutor(Instrutor i) { instrutores.add(i); }
    public void adicionarMaterial(String material) { materiaisApoio.add(material); }

    @Override
    public String toString() {
        return super.toString() + " - Minicurso (" + cargaHoraria + "h)";
    }
}

class Seminario extends Evento {
    private String tema;
    private String nomeAluno;
    private String nomeOrientador;

    public Seminario(String titulo, String data, int duracaoHoras, double orcamento, Local local,
                     String tema, String nomeAluno, String nomeOrientador) {
        super(titulo, data, duracaoHoras, orcamento, local);
        this.tema = tema;
        this.nomeAluno = nomeAluno;
        this.nomeOrientador = nomeOrientador;
    }

    @Override
    public String toString() {
        return super.toString() + " - Seminário: " + tema + " (" + nomeAluno + " / Orientador: " + nomeOrientador + ")";
    }
}
