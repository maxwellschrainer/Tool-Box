
import java.util.Scanner;

public class Toolbox 
{

    static Scanner scanner = new Scanner(System.in);

    //region Public Static Void MAIN
    // Comando para o "main" ficar rodando infinitamente, para finalizar apenas se usuário selecionar a opção "sair".
    public static void main(String[] args) throws Exception 
    {
        while (true) {
            MainMenu();
        }
    }
    //#endregion

    //region Menu principal
    public static void MainMenu() 
    {
        System.out.println("=== Menu Principal ===");
        System.out.println("1 - Menu de pessoas");
        System.out.println("2 - Menu de tipos de objetos");
        System.out.println("3 - Menu de objetos");
        System.out.println("4 - Menu de manutenções");
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
    public static void displayPeopleMenu() 
    {
        System.out.println("1 - Incluir pessoa");
        System.out.println("2 - Alterar pessoa");
        System.out.println("3 - Remover pessoa");
        System.out.println("4 - Consultar pessoas");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".

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
                System.out.println("Fechando o menu de pessoas");
                MainMenu();
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Cadastrar pessoas.
    public static void InsertPerson() 
    {

    }

    // 2 - Alterar pessoas cadastradas.
    public static void ChangePerson() 
    {

    }

    // 3 - Remover alguma pessoa cadastrada.
    public static void RemovePerson() 
    {

    }

    // 4 - Consultar as pessoas cadastradas.
    public static void ConsultPeople() 
    {

    }
    //#endregion

    //region Menu de controle dos tipos de objetos.
    public static void displayObjectTypeMenu() 
    {
        System.out.println("1 - Incluir um tipo de objeto");
        System.out.println("2 - Alterar um tipo de objeto");
        System.out.println("3 - Remover um tipo de objeto");
        System.out.println("4 - Consultar tipos de objetos");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".

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
                System.out.println("Fechando o menu de tipos de objetos.");
                System.exit(0);
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }

    }
    
    // 1 - Inserir tipo de objeto.
    public static void InsertObjectType()
    {
        
    }

    // 2 - Alterar algum tipo de objeto cadastrado.
    public static void ChangeObjectType()
    {
        
    }

    // 3 - Remover algum tipo de objeto cadastrado.
    public static void RemoveObjectType()
    {
        
    }

    // 4 - Consultar tipos de objetos cadastrados.
    public static void ConsultTypesOfObjects()
    {
        
    }
    //#endregion

    //region Menu de controle dos objetos.
    public static void displayObjectMenu() 
    {
        System.out.println("1 - Incluir um objeto");
        System.out.println("2 - Alterar um objeto");
        System.out.println("3 - Remover um objeto");
        System.out.println("4 - Consultar objetos");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".

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
                System.out.println("Fechando o menu de objetos.");
                System.exit(0);
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Inserir objeto.
    public static void InsertObject()
    {

    }

    // 2 - Alterar algum objeto cadastrado.
    public static void ChangeObject()
    {

    } 

    // 3 - Remover algum objeto cadastrado.
    public static void RemoveObject()
    {

    } 

    // 4 - Consultar objetos cadastrados.
    public static void ConsultObjects()
    {

    }
    //#endregion

    //region Menu de controle das manutenções das ferramentas.
    public static void displayMaintenanceMenu() 
    {
        System.out.println("1 - Incluir uma manutenção");
        System.out.println("2 - Alterar uma manutenção");
        System.out.println("3 - Remover uma manutenção");
        System.out.println("4 - Consultar manutenções");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt(); // Scanner para ler o que for digitado e aplicar nas opções do "switch".

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
                System.out.println("Fechando o menu de manutenções.");
                System.exit(0);
            default: // Caso seja digitado alguma opção sem ser as propostas.
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // 1 - Inserir manutenção.
    public static void InsertMaintenance()
    {

    }

    // 2 - Alterar alguma manutenção cadastrada.
    public static void ChangeMaintenance()
    {

    }

    // 3 - Remover alguma manutenção cadastrada.
    public static void RemoveMaintenance()
    {

    }

    // 4 - Consultar manutenções cadastradas.
    public static void ConsultMaintenance()
    {

    }
    //#endregion
}
