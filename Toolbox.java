
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//region Criação da classe "Pessoa".
class Pessoa {

    private String pessoa;

    public Pessoa(String nome) {
        this.pessoa = nome;
    }

    public String toString() {
        return "Nome: " + pessoa;
    }
}
//#endregion

//#region Criação da classe "Tipo de objeto".
class TipoDeObjeto {

    private String tipo;

    public TipoDeObjeto(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Tipo de objeto: " + tipo;
    }
}
//#endregion

//#region Criação da classe "Objeto".
class Objeto {

    private String objeto;
    private boolean disponivel;

    public Objeto(String objeto) {
        this.objeto = objeto;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Objeto: " + objeto + " (Disponível: " + (disponivel ? "Sim" : "Não") + ")";
    }
}
//#endregion

//#region Criação da classe "Manutencao".
class Manutencao {

    private String manutencao;

    public Manutencao(String manutencao) {
        this.manutencao = manutencao;
    }

    public String toString() {
        return "Manutenção: " + manutencao;
    }
}
//#endregion

//#region Criação da classe "Emprestimo".
class Emprestimo {

    private Pessoa pessoa;
    private Objeto objeto;
    private String dataEmprestimo;

    public Emprestimo(Pessoa pessoa, Objeto objeto, String dataEmprestimo) {
        this.pessoa = pessoa;
        this.objeto = objeto;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String toString() {
        return pessoa + ", " + objeto + ", Data do Empréstimo: " + dataEmprestimo;
    }
}
//#endregion

public class Toolbox {

//#region Criação das listas
    static Scanner scanner = new Scanner(System.in);
    static List<Pessoa> pessoas = new ArrayList<>(); // Lista para armazenar o cadastro das pessoas enquanto o código estiver rodando.
    static List<TipoDeObjeto> tipos = new ArrayList<>(); // Lista para armazenar o cadastro dos tipos de objeto enquanto o código estiver rodando.
    static List<Objeto> objetos = new ArrayList<>(); // Lista para armazenar o cadastro dos objetos enquanto o código estiver rodando.
    static List<Manutencao> manutencoes = new ArrayList<>(); // Lista para armazenar o cadastro das manutenções enquanto o código estiver rodando. 
    static List<Emprestimo> emprestimos = new ArrayList<>(); // Lista para armazenar o cadastro dos empréstimos enquanto o código estiver rodando. 
//#endregion

    //region Public Static Void MAIN
    // Comando para o "main" ficar rodando infinitamente, para finalizar apenas se usuário selecionar a opção "sair".
    public static void main(String[] args) throws Exception {
        while (true) {
            MainMenu();
        }
    }
    //#endregion

    //region Menu principal
    public static void MainMenu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1 - Cadastro de pessoas");
        System.out.println("2 - Cadastro de tipos de objetos");
        System.out.println("3 - Cadastro de objetos");
        System.out.println("4 - Cadastro de manutenções");
        System.out.println("5 - Cadastro de empréstimos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".

        switch (option) {
            case 1:
                displayPeopleMenu(); // Menu de cadastro de pessoas.
                break;
            case 2:
                displayObjectTypeMenu(); // Menu de cadastro de tipos de objetos.
                break;
            case 3:
                displayObjectMenu(); // Menu de cadastros de objetos.
                break;
            case 4:
                displayMaintenanceMenu(); // Menu de cadastros de manutenções.
                break;
            case 5:
                displayLoanMenu(); // Menu de cadastro de empréstimos.
                break;
            case 0:
                System.out.println("Encerrando o programa.");
                System.exit(0);
                break;
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    //#endregion

    //region Menu de controle de pessoas
    public static void displayPeopleMenu() {
        System.out.println("1 - Incluir pessoa");
        System.out.println("2 - Alterar pessoa");
        System.out.println("3 - Remover pessoa");
        System.out.println("4 - Consultar pessoas");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".
        scanner.nextLine();

        switch (option) {
            case 1:
                InsertPerson(); // Cadastrar pessoas.
                break;
            case 2:
                ChangePerson(); // Alterar pessoas cadastradas.
                break;
            case 3:
                RemovePerson(); // Remover alguma pessoa cadastrada.
                break;
            case 4:
                ConsultPeople(); // Consultar as pessoas cadastradas.
                break;
            case 0:
                System.out.println("Fechando o menu de cadastro de pessoas.");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Cadastrar pessoas.
    public static void InsertPerson() {
        String nome = "";

        while (nome.isEmpty()) {
            System.out.println("Digite o nome da pessoa: ");
            nome = scanner.nextLine().trim();
        }

        Pessoa novaPessoa = new Pessoa(nome);
        pessoas.add(novaPessoa);

        System.out.println("Pessoa adicionada com sucesso!");
    }

    // 2 - Alterar pessoas cadastradas.
    public static void ChangePerson() {
        // Checando se realmente há cadastros.
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            System.out.println("Pessoas cadastradas: ");
            // Listando os cadastros:
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println((i + 1) + " - " + pessoas.get(i).toString());
            }
            System.out.println("Digite o número do cadastro da pessoa que deseja alterar: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Código para caso o valor digitado seja menor que 1 ou maior que um número existente no index da lista, conste como uma opção inválida.
            if (index < 1 || index > pessoas.size()) {
                System.out.println("Opção inválida. Tente novamente.");
            }

            // Redirecionando e indicando a escolha do usuário.
            Pessoa pessoaSelecionada = pessoas.get(index - 1);

            System.out.println("Digite o novo nome (ou deixe em branco para cancelar a alteração): ");
            String novoNome = scanner.nextLine().trim();

            // Checando se o valor de entrada é vazio, para cancelar a operação, ou adicionando/alterando o nome selecionado para o novo nome digitado e armazenado no atributo "novoNome".
            if (novoNome.isEmpty()) {
                System.out.println("Alteração cancelada com sucesso.");
            } else {
                pessoaSelecionada = new Pessoa(novoNome);
                pessoas.set(index - 1, pessoaSelecionada);
            }

            System.out.println("Nome alterado com sucesso!");
        }
    }

    // 3 - Remover alguma pessoa cadastrada.
    public static void RemovePerson() {
        // Checando se há cadastros.
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas");
        } else {
            // Listando os cadastros.
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println((i + 1) + " - " + pessoas.get(i).toString());
            }
            System.out.println("Digite o número do cadastro da pessoa que deseja remover: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Checando se o valor digitado é maior que 0 e menor que o maior index do cadastro, para então remover o código que foi selecionado.
            if (index > 0 && index <= pessoas.size()) {
                pessoas.remove(index - 1);
                System.out.println("Pessoa removida com sucesso!");
                // Caso o valor for inválido, o else será chamado.
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // 4 - Consultar as pessoas cadastradas.
    public static void ConsultPeople() {
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            System.out.println("Pessoas cadastradas: ");
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println((i + 1) + " - " + pessoas.get(i).toString());
            }
        }
    }
    //#endregion

    //region Menu de controle dos tipos de objetos.
    public static void displayObjectTypeMenu() {
        System.out.println("1 - Incluir um tipo de objeto");
        System.out.println("2 - Alterar um tipo de objeto");
        System.out.println("3 - Remover um tipo de objeto");
        System.out.println("4 - Consultar tipos de objetos");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".
        scanner.nextLine();

        switch (option) {
            case 1:
                InsertObjectType(); // Cadastrar um tipo de objeto.
                break;
            case 2:
                ChangeObjectType(); // Alterar algum tipo de objeto cadastrado.
                break;
            case 3:
                RemoveObjectType(); // Remover algum tipo de objeto cadastrado.
                break;
            case 4:
                ConsultTypesOfObjects(); // Consultar tipos de objetos cadastrados.
            case 0:
                System.out.println("Fechando o menu de cadastro de tipos de objetos.");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }

    }

    // 1 - Inserir tipo de objeto.
    public static void InsertObjectType() {
        String tipo = "";

        while (tipo.isEmpty()) {
            System.out.println("Digite o tipo de objeto que deseja cadastrar: ");
            tipo = scanner.nextLine().trim();
        }

        TipoDeObjeto novoTipo = new TipoDeObjeto(tipo);
        tipos.add(novoTipo);

        System.out.println("Tipo de objeto cadastrado com sucesso!");
    }

    // 2 - Alterar algum tipo de objeto cadastrado.
    public static void ChangeObjectType() {
        // Checando se realmente há cadastros.
        if (tipos.isEmpty()) {
            System.out.println("Não há tipos de objeto cadastrados.");
        } else {
            System.out.println("Tipos de objetos cadastrados: ");
            // Listando os cadastros:
            for (int i = 0; i < tipos.size(); i++) {
                System.out.println((i + 1) + " - " + tipos.get(i).toString());
            }
            System.out.println("Digite o número do cadastro do tipo de objeto que deseja alterar: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Código para caso o valor digitado seja menor que 1 ou maior que um número existente no index da lista, conste como uma opção inválida.
            if (index < 1 || index > tipos.size()) {
                System.out.println("Opção inválida. Tente novamente.");
            }

            // Redirecionando e indicando a escolha do usuário.
            TipoDeObjeto tipoSelecionado = tipos.get(index - 1);

            System.out.println("Digite o novo nome (ou deixe em branco para cancelar a alteração): ");
            String novoNome = scanner.nextLine().trim();

            // Checando se o valor de entrada é vazio, para cancelar a operação, ou adicionando/alterando o nome selecionado para o novo nome digitado e armazenado no atributo "novoNome".
            if (novoNome.isEmpty()) {
                System.out.println("Alteração cancelada com sucesso.");
            } else {
                tipoSelecionado = new TipoDeObjeto(novoNome);
                tipos.set(index - 1, tipoSelecionado);
            }

            System.out.println("Nome alterado com sucesso!");
        }
    }

    // 3 - Remover algum tipo de objeto cadastrado.
    public static void RemoveObjectType() {
        // Checando se há cadastros.
        if (tipos.isEmpty()) {
            System.out.println("Não há tipos de objetos cadastrados");
        } else {
            // Listando os cadastros.
            for (int i = 0; i < tipos.size(); i++) {
                System.out.println((i + 1) + " - " + tipos.get(i).toString());
            }
            System.out.println("Digite o número do cadastro do tipo de objeto que deseja remover: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Checando se o valor digitado é maior que 0 e menor que o maior index do cadastro, para então remover o código que foi selecionado.
            if (index > 0 && index <= tipos.size()) {
                tipos.remove(index - 1);
                System.out.println("Tipo de objeto removido com sucesso!");
                // Caso o valor for inválido, o else será chamado.
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // 4 - Consultar tipos de objetos cadastrados.
    public static void ConsultTypesOfObjects() {
        if (tipos.isEmpty()) {
            System.out.println("Não há tipos de objeto cadastrados.");
        } else {
            System.out.println("Tipos de objetos cadastrados");
            for (int i = 0; i < tipos.size(); i++) {
                System.out.println((i + 1) + " - " + tipos.get(i).toString());
            }
        }
    }
    //#endregion

    //region Menu de controle dos objetos.
    public static void displayObjectMenu() {
        System.out.println("1 - Incluir um objeto");
        System.out.println("2 - Alterar um objeto");
        System.out.println("3 - Remover um objeto");
        System.out.println("4 - Consultar objetos");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".
        scanner.nextLine();

        switch (option) {
            case 1:
                InsertObject(); // Inserir objeto.
                break;
            case 2:
                ChangeObject(); // Alterar algum objeto cadastrado.
                break;
            case 3:
                RemoveObject(); // Remover algum objeto cadastrado.
                break;
            case 4:
                ConsultObjects(); // Consultar objetos cadastrados.
            case 0:
                System.out.println("Fechando o menu de cadastro de objetos.");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Inserir objeto.
    public static void InsertObject() {
        String objeto = "";

        while (objeto.isEmpty()) {
            System.out.println("Digite o objeto que você deseja cadastrar: ");
            objeto = scanner.nextLine().trim();
        }

        Objeto novoObjeto = new Objeto(objeto);
        objetos.add(novoObjeto);

        System.out.println("Objeto cadastrado com sucesso!");
    }

    // 2 - Alterar algum objeto cadastrado.
    public static void ChangeObject() {
        // Checando se realmente há cadastros.
        if (objetos.isEmpty()) {
            System.out.println("Não há objetos cadastrados.");
        } else {
            System.out.println("Objetos cadastrados: ");
            // Listando os cadastros:
            for (int i = 0; i < objetos.size(); i++) {
                System.out.println((i + 1) + " - " + objetos.get(i).toString());
            }
            System.out.println("Digite o número do cadastro do objeto que deseja alterar: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Código para caso o valor digitado seja menor que 1 ou maior que um número existente no index da lista, conste como uma opção inválida.
            if (index < 1 || index > objetos.size()) {
                System.out.println("Opção inválida. Tente novamente.");
            }

            // Redirecionando e indicando a escolha do usuário.
            Objeto objetoSelecionado = objetos.get(index - 1);

            System.out.println("Digite o novo nome (ou deixe em branco para cancelar a alteração): ");
            String novoNome = scanner.nextLine().trim();

            // Checando se o valor de entrada é vazio, para cancelar a operação, ou adicionando/alterando o nome selecionado para o novo nome digitado e armazenado no atributo "novoNome".
            if (novoNome.isEmpty()) {
                System.out.println("Alteração cancelada com sucesso.");
            } else {
                objetoSelecionado = new Objeto(novoNome);
                objetos.set(index - 1, objetoSelecionado);
            }

            System.out.println("Nome alterado com sucesso!");
        }
    }

    // 3 - Remover algum objeto cadastrado.
    public static void RemoveObject() {
        // Checando se há cadastros.
        if (objetos.isEmpty()) {
            System.out.println("Não há objetos cadastrados");
        } else {
            // Listando os cadastros.
            for (int i = 0; i < objetos.size(); i++) {
                System.out.println((i + 1) + " - " + objetos.get(i).toString());
            }
            System.out.println("Digite o número do cadastro do objeto que deseja remover: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Checando se o valor digitado é maior que 0 e menor que o maior index do cadastro, para então remover o código que foi selecionado.
            if (index > 0 && index <= objetos.size()) {
                objetos.remove(index - 1);
                System.out.println("Objeto removido com sucesso!");
                // Caso o valor for inválido, o else será chamado.
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // 4 - Consultar objetos cadastrados.
    public static void ConsultObjects() {
        if (objetos.isEmpty()) {
            System.out.println("Não há objetos cadastrados.");
        } else {
            System.out.println("Objetos cadastrados: ");
            for (int i = 0; i < objetos.size(); i++) {
                System.out.println((i + 1) + " - " + objetos.get(i).toString());
            }
        }
    }
    //#endregion

    //region Menu de controle das manutenções das ferramentas.
    public static void displayMaintenanceMenu() {
        System.out.println("1 - Incluir uma manutenção");
        System.out.println("2 - Alterar uma manutenção");
        System.out.println("3 - Remover uma manutenção");
        System.out.println("4 - Consultar manutenções");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".
        scanner.nextLine();

        switch (option) {
            case 1:
                InsertMaintenance(); // Inserir manutenção.
                break;
            case 2:
                ChangeMaintenance(); // Alterar alguma manutenção cadastrada.
                break;
            case 3:
                RemoveMaintenance(); // Remover alguma manutenção cadastrada.
                break;
            case 4:
                ConsultMaintenance(); // Consultar manutenções cadastradas.
            case 0:
                System.out.println("Fechando o menu de cadastro de manutenções.");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Inserir manutenção.
    public static void InsertMaintenance() {
        String manutencao = "";

        while (manutencao.isEmpty()) {
            System.out.println("Digite a manutenção que você deseja cadastrar: ");
            manutencao = scanner.nextLine().trim();
        }

        System.out.println("Manutenção cadastrada com sucesso!");
        Manutencao novaManutencao = new Manutencao(manutencao);
        manutencoes.add(novaManutencao);
    }

    // 2 - Alterar alguma manutenção cadastrada.
    public static void ChangeMaintenance() {
        // Checando se realmente há cadastros.
        if (manutencoes.isEmpty()) {
            System.out.println("Não há manutenções cadastradas.");
        } else {
            System.out.println("Manutenções cadastradas: ");
            // Listando os cadastros:
            for (int i = 0; i < manutencoes.size(); i++) {
                System.out.println((i + 1) + " - " + manutencoes.get(i).toString());
            }
            System.out.println("Digite o número da manutenção que deseja alterar: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Código para caso o valor digitado seja menor que 1 ou maior que um número existente no index da lista, conste como uma opção inválida.
            if (index < 1 || index > manutencoes.size()) {
                System.out.println("Opção inválida. Tente novamente.");
            }

            // Redirecionando e indicando a escolha do usuário.
            Manutencao manutencaoSelecionada = manutencoes.get(index - 1);

            System.out.println("Digite o novo nome (ou deixe em branco para cancelar a alteração): ");
            String novoNome = scanner.nextLine().trim();

            // Checando se o valor de entrada é vazio, para cancelar a operação, ou adicionando/alterando o nome selecionado para o novo nome digitado e armazenado no atributo "novoNome".
            if (novoNome.isEmpty()) {
                System.out.println("Alteração cancelada com sucesso.");
            } else {
                manutencaoSelecionada = new Manutencao(novoNome);
                manutencoes.set(index - 1, manutencaoSelecionada);
            }

            System.out.println("Nome alterado com sucesso!");
        }
    }

    // 3 - Remover alguma manutenção cadastrada.
    public static void RemoveMaintenance() {
        // Checando se há cadastros.
        if (manutencoes.isEmpty()) {
            System.out.println("Não há manutenções cadastradas");
        } else {
            // Listando os cadastros.
            for (int i = 0; i < manutencoes.size(); i++) {
                System.out.println((i + 1) + " - " + manutencoes.get(i).toString());
            }
            System.out.println("Digite o número do cadastro da manutenção que deseja remover: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            // Checando se o valor digitado é maior que 0 e menor que o maior index do cadastro, para então remover o código que foi selecionado.
            if (index > 0 && index <= manutencoes.size()) {
                manutencoes.remove(index - 1);
                System.out.println("Manutenção removida com sucesso!");
                // Caso o valor for inválido, o else será chamado.
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // 4 - Consultar manutenções cadastradas.
    public static void ConsultMaintenance() {
        if (manutencoes.isEmpty()) {
            System.out.println("Não há manutenções cadastradas.");
        } else {
            System.out.println("Manutenções cadastradas: ");
            for (int i = 0; i < manutencoes.size(); i++) {
                System.out.println((i + 1) + " - " + manutencoes.get(i).toString());
            }
        }
    }
    //#endregion

    //region Menu de controle dos empréstimos.
    public static void displayLoanMenu() {
        System.out.println("1 - Incluir um empréstimo");
        System.out.println("2 - Consultar empréstimos");
        System.out.println("3 - Remover um empréstimo");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".
        scanner.nextLine();

        switch (option) {
            case 1:
                InsertLoan(); // Inserir um empréstimo.
                break;
            case 2:
                ConsultLoan(); // Consulta empréstimos cadastrados.
                break;
            case 3:
                RemoveLoan(); // Remover algum empréstimo cadastrado.
                break;
            case 0:
                System.out.println("Fechando o menu de cadastro de empréstimos.");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Inserir objeto.
    public static void InsertLoan() {
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas");
            return;
        }

        if (objetos.isEmpty()) {
            System.out.println("Não há objetos cadastrados");
            return;
        }

        System.out.println("Pessoas cadastradas: ");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println((i + 1) + " - " + pessoas.get(i).toString());
        }

        System.out.println("Escolha o número do cadastro da pessoa que pegará o objeto: ");
        int pessoaIndex = scanner.nextInt();
        scanner.nextLine();

        if (pessoaIndex < 1 || pessoaIndex > pessoas.size()) {
            System.out.println("Pessoa inválida. Tente novamente.");
        }

        System.out.println("Objetos disponíveis: ");
        boolean temDisponivel = false;
        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).isDisponivel()) {
                System.out.println((i + 1) + " - " + objetos.get(i).toString());
                temDisponivel = true;
            }
        }

        if (!temDisponivel) {
            System.out.println("Não há objetos disponíveis para empréstimo.");
            return;
        }

        System.out.println("Objetos cadastrados: ");
        for (int i = 0; i < objetos.size(); i++) {
            System.out.println((i + 1) + " - " + objetos.get(i).toString());
        }

        System.out.println("Escolha o número do cadastro do objeto a ser emprestado: ");
        int objetoIndex = scanner.nextInt();
        scanner.nextLine();

        if (objetoIndex < 1 || objetoIndex > objetos.size() || !objetos.get(objetoIndex - 1).isDisponivel()) {
            System.out.println("Objeto inválido ou indisponível.");
            return;
        }

        System.out.print("Digite a data do empréstimo: ");
        String dataEmprestimo = scanner.nextLine();

        Pessoa pessoaSelecionada = pessoas.get(pessoaIndex - 1);
        Objeto objetoSelecionado = objetos.get(objetoIndex - 1);

        objetoSelecionado.setDisponivel(false); // Marca o objeto como indisponível
        Emprestimo novoEmprestimo = new Emprestimo(pessoaSelecionada, objetoSelecionado, dataEmprestimo);
        emprestimos.add(novoEmprestimo);

        System.out.println("Empréstimo registrado com sucesso!");
    }

    // 2 - Alterar algum objeto cadastrado.
    public static void ConsultLoan() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos registrados.");
        } else {
            System.out.println("Empréstimos registrados: ");
            for (int i = 0; i < emprestimos.size(); i++) {
                System.out.println((i + 1) + " - " + emprestimos.get(i).toString());
            }
        }
    }

    // 3 - Remover algum objeto cadastrado.
    public static void RemoveLoan() {
        // Checando se há cadastros.
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos cadastrados");
        } else {
            // Listando os cadastros.
            for (int i = 0; i < emprestimos.size(); i++) {
                System.out.println((i + 1) + " - " + emprestimos.get(i).toString());
            }
            System.out.println("Digite o número do cadastro do empréstimo que deseja remover: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index < 1 || index > emprestimos.size()) {
                System.out.println("Empréstimo inválido.");
                return;
            }

            Emprestimo emprestimoSelecionado = emprestimos.get(index - 1);
            Objeto objetoEmprestado = emprestimoSelecionado.getObjeto();

            objetoEmprestado.setDisponivel(true);

            // Checando se o valor digitado é maior que 0 e menor que o maior index do cadastro, para então remover o código que foi selecionado.
            if (index > 0 && index <= emprestimos.size()) {
                emprestimos.remove(index - 1);
                System.out.println("Empréstimo removido com sucesso!");
                // Caso o valor for inválido, o else será chamado.
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    //#endregion
}
