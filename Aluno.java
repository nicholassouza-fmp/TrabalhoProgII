public class Aluno {

    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;

    // Curso em que o aluno está matriculado
    private Curso cursoMatriculado;

    // Notas
    private double[] notas = new double[3];
    private boolean[] lancada = new boolean[3];

    // Mensalidades
    private Mensalidade[] mensalidades;
    private int numParcelas;


    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public Aluno(int codigo, String nome, String dataNascimento,
                 String email, String senha) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }


    // =========================================================
    // GETTERS E SETTERS
    // =========================================================

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Curso getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(Curso cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }


    // =========================================================
    // EXIBIR DADOS
    // =========================================================

    public void exibeDados() {

        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("E-mail: " + email);

        if (cursoMatriculado != null) {

            System.out.println(
                "Curso: " + cursoMatriculado.getNome()
            );

        } else {

            System.out.println("Curso: Nenhum");
        }
    }


    // =========================================================
    // NOTAS
    // =========================================================

    public void lancarNotas(int indice, double nota) {

        if (indice >= 0 && indice < 3) {

            if (nota >= 0 && nota <= 10) {

                notas[indice] = nota;
                lancada[indice] = true;

            } else {

                System.out.println(
                    "A nota deve estar entre 0 e 10."
                );
            }

        } else {

            System.out.println("Índice de nota inválido.");
        }
    }


    public double calcularMedia() {

        double soma = 0;

        for (int i = 0; i < 3; i++) {

            soma += notas[i];
        }

        return soma / 3;
    }


    public void exibirNotas() {

        System.out.println("\nAluno: " + nome);

        for (int i = 0; i < 3; i++) {

            if (lancada[i]) {

                System.out.println(
                    "Nota " + (i + 1) + ": " + notas[i]
                );

            } else {

                System.out.println(
                    "Nota " + (i + 1) + ": Não lançada"
                );
            }
        }

        System.out.printf(
            "Média: %.2f%n",
            calcularMedia()
        );
    }


    // =========================================================
    // MENSALIDADES
    // =========================================================

    public void adicionarMensalidades(double[] valores) {

        numParcelas = valores.length;

        mensalidades = new Mensalidade[numParcelas];

        for (int i = 0; i < numParcelas; i++) {

            mensalidades[i] = new Mensalidade(valores[i]);
        }
    }


    // Verifica se o aluno possui mensalidades cadastradas
    public boolean temMensalidades() {

        return mensalidades != null
            && mensalidades.length > 0;
    }


    public void exibirMensalidades() {

        if (!temMensalidades()) {

            System.out.println(
                "Nenhuma mensalidade cadastrada."
            );

            return;
        }

        System.out.println(
            "\nFinanceiro do aluno: " + nome
        );

        for (int i = 0; i < mensalidades.length; i++) {

            System.out.println(
                "Parcela " + (i + 1)
                + " - R$ " + mensalidades[i].getValor()
                + " - "
                + (
                    mensalidades[i].isPago()
                    ? "Pago"
                    : "Pendente"
                )
            );
        }
    }


    public void pagarMensalidade(int indice) {

        if (!temMensalidades()) {

            System.out.println(
                "Nenhuma mensalidade cadastrada."
            );

            return;
        }

        if (indice >= 0 && indice < mensalidades.length) {

            mensalidades[indice].darBaixa();

            System.out.println(
                "Mensalidade paga com sucesso."
            );

        } else {

            System.out.println(
                "Número de parcela inválido."
            );
        }
    }
}
