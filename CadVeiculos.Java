import java.util.ArrayList;

public class CadVeiculos {

    public static void main(String[] args) {
        ArrayList<String> veiculos = new ArrayList<String>();
        int opcao;

        do {
            exibirMenu();
            opcao = Input.readInt("Digite a opcao desejada: ");
            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(veiculos);
                    break;
                case 2:
                    listarVeiculos(veiculos);
                    break;
                case 3:
                    buscarVeiculoPorNome(veiculos);
                    break;
                case 4:
                    editarVeiculo(veiculos);
                    break;
                case 5:
                    removerVeiculoPorIndice(veiculos);
                    break;
                case 6:
                    removerVeiculoPorNome(veiculos);
                    break;
                case 7:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 7);
    }

    public static void exibirMenu() {
        System.out.println("===== CADVEICULOS =====");
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Listar veiculos");
        System.out.println("3 - Buscar veiculo por nome");
        System.out.println("4 - Editar veiculo");
        System.out.println("5 - Remover veiculo por indice");
        System.out.println("6 - Remover veiculo por nome");
        System.out.println("7 - Sair");
    }

    public static void cadastrarVeiculo(ArrayList<String> veiculos) {
        String nome = Input.readString("Digite o nome do veiculo: ").trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do veiculo nao pode ser vazio.");
            return;
        }

        if (existeVeiculo(veiculos, nome)) {
            System.out.println("Veiculo ja cadastrado.");
            return;
        }

        veiculos.add(nome);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public static void listarVeiculos(ArrayList<String> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("A lista esta vazia.");
            System.out.println("Total de veiculos cadastrados: 0");
            return;
        }

        ordenarVeiculos(veiculos);

        System.out.println("Lista de veiculos:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - " + veiculos.get(i));
        }

        System.out.println("Total de veiculos cadastrados: " + veiculos.size());
    }

    public static void buscarVeiculoPorNome(ArrayList<String> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("A lista esta vazia.");
            System.out.println("Total de veiculos cadastrados: 0");
            return;
        }

        String nome = Input.readString("Digite o nome do veiculo para busca: ").trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do veiculo nao pode ser vazio.");
            System.out.println("Total de veiculos cadastrados: " + veiculos.size());
            return;
        }

        ordenarVeiculos(veiculos);

        boolean encontrado = false;

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                System.out.println("Veiculo encontrado: " + i + " - " + veiculos.get(i));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Veiculo nao cadastrado.");
        }

        System.out.println("Total de veiculos cadastrados: " + veiculos.size());
    }

    public static void editarVeiculo(ArrayList<String> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("A lista esta vazia.");
            return;
        }

        ordenarVeiculos(veiculos);

        System.out.println("Veiculos cadastrados:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - " + veiculos.get(i));
        }

        int indice = Input.readInt("Digite o indice do veiculo que deseja editar: ");

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        String novoNome = Input.readString("Digite o novo nome do veiculo: ").trim();

        if (novoNome.isEmpty()) {
            System.out.println("O nome do veiculo nao pode ser vazio.");
            return;
        }

        if (existeVeiculoNaEdicao(veiculos, novoNome, indice)) {
            System.out.println("Ja existe um veiculo com esse nome.");
            return;
        }

        veiculos.set(indice, novoNome);
        System.out.println("Veiculo editado com sucesso.");
    }

    public static void removerVeiculoPorIndice(ArrayList<String> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("A lista esta vazia.");
            return;
        }

        ordenarVeiculos(veiculos);

        System.out.println("Veiculos cadastrados:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - " + veiculos.get(i));
        }

        int indice = Input.readInt("Digite o indice do veiculo que deseja remover: ");

        if (indice < 0 || indice >= veiculos.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        String removido = veiculos.remove(indice);
        System.out.println("Veiculo removido com sucesso: " + removido);
    }

    public static void removerVeiculoPorNome(ArrayList<String> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("A lista esta vazia.");
            return;
        }

        String nome = Input.readString("Digite o nome do veiculo que deseja remover: ").trim();

        if (nome.isEmpty()) {
            System.out.println("O nome do veiculo nao pode ser vazio.");
            return;
        }

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                String removido = veiculos.remove(i);
                System.out.println("Veiculo removido com sucesso: " + removido);
                return;
            }
        }

        System.out.println("Veiculo nao encontrado.");
    }

    public static boolean existeVeiculo(ArrayList<String> veiculos, String nome) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    public static boolean existeVeiculoNaEdicao(ArrayList<String> veiculos, String nome, int indiceAtual) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (i != indiceAtual && veiculos.get(i).equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    public static void ordenarVeiculos(ArrayList<String> veiculos) {
        for (int i = 0; i < veiculos.size() - 1; i++) {
            for (int j = 0; j < veiculos.size() - 1 - i; j++) {
                if (veiculos.get(j).compareToIgnoreCase(veiculos.get(j + 1)) > 0) {
                    String auxiliar = veiculos.get(j);
                    veiculos.set(j, veiculos.get(j + 1));
                    veiculos.set(j + 1, auxiliar);
                }
            }
        }
    }
}