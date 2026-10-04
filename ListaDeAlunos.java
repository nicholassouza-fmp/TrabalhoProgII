public class ListaDeAlunos {
    private Aluno[] alunos;
    private int totalAlunos;

    public ListaDeAlunos(int capacidade) {
        alunos = new Aluno[capacidade];
        totalAlunos = 0;
    }

    public boolean adicionarAluno(Aluno a) {

        if (totalAlunos >= alunos.length) {
            System.out.println("A lista de alunos está cheia.");
            return false;
        }

        // Verifica duplicidade pelo código
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getCodigo() == a.getCodigo()) {
                System.out.println("Já existe um aluno com esse código.");
                return false;
            }
        }

        alunos[totalAlunos] = a;
        totalAlunos++;

        return true;
    }

    public void exibirLista() {

        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (int i = 0; i < totalAlunos; i++) {
            System.out.println("-------------------------");
            alunos[i].exibeDados();
        }
    }

    public Aluno buscarAluno(int codigo) {

        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getCodigo() == codigo) {
                return alunos[i];
            }
        }

        return null;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }
}