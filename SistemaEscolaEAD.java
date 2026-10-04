
import java.util.Scanner;

public class SistemaEscolaEAD {

    static Scanner scanner = new Scanner(System.in);

    static ListaDeAlunos listaAlunos = new ListaDeAlunos(50);

    // Matriz obrigatória para os cursos
    static Curso[][] matrizCursos = new Curso[5][5];

    static int totalCursos = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA ESCOLA EAD =====");
            System.out.println("1 - Visualizar Lista de Alunos");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("3 - Sair");
            System.out.println("4 - Verificar Notas do Aluno");
            System.out.println("5 - Verificar Financeiro do Aluno");
            System.out.println("6 - Cadastrar Curso");
            System.out.println("7 - Visualizar Cursos e Alunos");
            System.out.println("8 - Lançar Notas");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    visualizarAlunos();
                    break;

                case 2:
                    adicionarAluno();
                    break;

                case 3:
                    System.out.println("Sistema encerrado.");
                    break;

                case 4:
                    verificarNotas();
                    break;

                case 5:
                    verificarFinanceiro();
                    break;

                case 6:
                    cadastrarCurso();
                    break;

                case 7:
                    visualizarCursos();
                    break;

                case 8:
                    lancarNotas();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        scanner.close();
    }

    // =========================================================
    // 1 - VISUALIZAR ALUNOS
    // =========================================================

    public static void visualizarAlunos() {

        System.out.println("\n===== LISTA DE ALUNOS =====");

        listaAlunos.exibirLista();
    }

    // =========================================================
    // 2 - ADICIONAR ALUNO
    // =========================================================

    public static void adicionarAluno() {

        System.out.println("\n===== ADICIONAR ALUNO =====");

        // Mostra os cursos antes de escolher
        if (totalCursos == 0) {
            System.out.println("Nenhum curso cadastrado.");
            System.out.println("Cadastre um curso antes de cadastrar um aluno.");
            return;
        }

        System.out.println("\nCursos disponíveis:");

        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0; j < matrizCursos[i].length; j++) {

                if (matrizCursos[i][j] != null) {

                    Curso curso = matrizCursos[i][j];

                    System.out.println(
                        "Código: " + curso.getCodigo()
                        + " | Curso: " + curso.getNome()
                        + " | Duração: " + curso.getDuracao() + " horas"
                    );
                }
            }
        }

        System.out.print("\nCódigo do aluno: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("O aluno é bolsista? (S/N): ");
        String resposta = scanner.nextLine();

        Aluno aluno;

        if (resposta.equalsIgnoreCase("S")) {

            System.out.print("Tipo de bolsa: ");
            String tipoBolsa = scanner.nextLine();

            aluno = new AlunoBolsista(
                codigo,
                nome,
                dataNascimento,
                email,
                senha,
                tipoBolsa
            );

        } else {

            aluno = new Aluno(
                codigo,
                nome,
                dataNascimento,
                email,
                senha
            );
        }

        // Escolher curso
        Curso cursoEscolhido = null;

        while (cursoEscolhido == null) {

            System.out.print("\nDigite o código do curso: ");
            int codigoCurso = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < matrizCursos.length; i++) {

                for (int j = 0; j < matrizCursos[i].length; j++) {

                    if (matrizCursos[i][j] != null
                        && matrizCursos[i][j].getCodigo() == codigoCurso) {

                        cursoEscolhido = matrizCursos[i][j];
                    }
                }
            }

            if (cursoEscolhido == null) {
                System.out.println("Curso não encontrado. Digite outro código.");
            }
        }

        aluno.setCursoMatriculado(cursoEscolhido);

        if (listaAlunos.adicionarAluno(aluno)) {

            System.out.println("\nAluno cadastrado com sucesso!");
            System.out.println("Curso: " + cursoEscolhido.getNome());
        }
    }

    // =========================================================
    // 4 - VERIFICAR NOTAS
    // =========================================================

    public static void verificarNotas() {

        System.out.println("\n===== VERIFICAR NOTAS =====");

        System.out.print("Código do aluno: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = listaAlunos.buscarAluno(codigo);

        if (aluno == null) {

            System.out.println("Aluno não encontrado.");

        } else {

            aluno.exibirNotas();
        }
    }

    // =========================================================
    // 5 - VERIFICAR FINANCEIRO
    // =========================================================

    public static void verificarFinanceiro() {

        System.out.println("\n===== FINANCEIRO DO ALUNO =====");

        System.out.print("Código do aluno: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = listaAlunos.buscarAluno(codigo);

        if (aluno == null) {

            System.out.println("Aluno não encontrado.");
            return;
        }

        /*
         * Se o aluno ainda não possui mensalidades,
         * permite cadastrá-las aqui.
         */
        if (!aluno.temMensalidades()) {

            System.out.println("\nNenhuma mensalidade cadastrada.");

            System.out.print("Deseja cadastrar mensalidades? (S/N): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {

                System.out.print("Quantidade de parcelas: ");
                int quantidade = scanner.nextInt();

                while (quantidade <= 0) {

                    System.out.println("A quantidade deve ser maior que zero.");
                    System.out.print("Quantidade de parcelas: ");
                    quantidade = scanner.nextInt();
                }

                double[] valores = new double[quantidade];

                for (int i = 0; i < quantidade; i++) {

                    System.out.print(
                        "Valor da parcela " + (i + 1) + ": R$ "
                    );

                    valores[i] = scanner.nextDouble();

                    while (valores[i] < 0) {

                        System.out.println("O valor não pode ser negativo.");

                        System.out.print(
                            "Valor da parcela " + (i + 1) + ": R$ "
                        );

                        valores[i] = scanner.nextDouble();
                    }
                }

                scanner.nextLine();

                aluno.adicionarMensalidades(valores);

                System.out.println(
                    "\nMensalidades cadastradas com sucesso!"
                );
            } else {

                scanner.nextLine();
                return;
            }
        }

        // Mostra as mensalidades
        aluno.exibirMensalidades();

        // Pergunta se deseja pagar
        System.out.print("\nDeseja pagar alguma parcela? (S/N): ");
        String respostaPagamento = scanner.nextLine();

        if (respostaPagamento.equalsIgnoreCase("S")) {

            System.out.print("Digite o número da parcela: ");
            int parcela = scanner.nextInt();
            scanner.nextLine();

            aluno.pagarMensalidade(parcela - 1);
        }
    }

    // =========================================================
    // 6 - CADASTRAR CURSO
    // =========================================================

    public static void cadastrarCurso() {

        System.out.println("\n===== CADASTRAR CURSO =====");

        if (totalCursos >= 25) {

            System.out.println("Limite de cursos atingido.");
            return;
        }

        System.out.print("Código do curso: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Duração em horas: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        Curso curso = new Curso(codigo, nome, duracao);

        boolean cadastrado = false;

        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0; j < matrizCursos[i].length; j++) {

                if (matrizCursos[i][j] == null) {

                    matrizCursos[i][j] = curso;
                    totalCursos++;
                    cadastrado = true;

                    break;
                }
            }

            if (cadastrado) {
                break;
            }
        }

        System.out.println("Curso cadastrado com sucesso!");
    }

    // =========================================================
    // 7 - VISUALIZAR CURSOS E ALUNOS
    // =========================================================

    public static void visualizarCursos() {

        System.out.println("\n===== CURSOS CADASTRADOS =====");

        if (totalCursos == 0) {

            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0; j < matrizCursos[i].length; j++) {

                Curso curso = matrizCursos[i][j];

                if (curso != null) {

                    System.out.println("\n-------------------------");

                    curso.exibeDados();

                    System.out.println("Alunos matriculados:");

                    boolean encontrouAluno = false;

                    Aluno[] alunos = listaAlunos.getAlunos();
                    int totalAlunos = listaAlunos.getTotalAlunos();

                    for (int k = 0; k < totalAlunos; k++) {

                        if (alunos[k].getCursoMatriculado() == curso) {

                            System.out.println(
                                "- " + alunos[k].getNome()
                                + " (Código: "
                                + alunos[k].getCodigo() + ")"
                            );

                            encontrouAluno = true;
                        }
                    }

                    if (!encontrouAluno) {

                        System.out.println(
                            "Nenhum aluno matriculado."
                        );
                    }
                }
            }
        }
    }

    // =========================================================
    // 8 - LANÇAR NOTAS
    // =========================================================

    public static void lancarNotas() {

        System.out.println("\n===== LANÇAR NOTAS =====");

        System.out.print("Código do aluno: ");
        int codigo = scanner.nextInt();

        Aluno aluno = listaAlunos.buscarAluno(codigo);

        if (aluno == null) {

            System.out.println("Aluno não encontrado.");
            scanner.nextLine();
            return;
        }

        for (int i = 0; i < 3; i++) {

            System.out.print("Nota " + (i + 1) + ": ");
            double nota = scanner.nextDouble();

            while (nota < 0 || nota > 10) {

                System.out.println(
                    "A nota deve estar entre 0 e 10."
                );

                System.out.print("Nota " + (i + 1) + ": ");
                nota = scanner.nextDouble();
            }

            aluno.lancarNotas(i, nota);
        }

        scanner.nextLine();

        System.out.println("Notas lançadas com sucesso!");
    }
}
