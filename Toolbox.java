
import java.util.Scanner;

public class Toolbox 
{
    static Scanner scanner = new Scanner(System.in);

    // 
    public static void main(String[] args) throws Exception
    {
        while (true) { 
            MainMenu();          
        }
    }

    // Menu principal
    public static void MainMenu()
    {
        System.out.println("=== Menu Principal ===");
        System.out.println("1 - Cadastro de pessoas");
        System.out.println("2 - Cadastro de tipos de objetos");
        System.out.println("3 - Cadastro de objetos");
        System.out.println("4 - Cadastro de manutenções");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt();

        switch(option)
        {
            case 1: 
                displayPplRegistrationMenu();
                break;
            case 2:
                displayObjTpRegistrationMenu();
                break;
            case 3: 
                displayObjRegistrationMenu();
                break;
            case 4:
                displayMtcRegistrationMenu();
                break;
            case 0:
                System.out.println("Encerrando o programa.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // Menu de cadastro de pessoas
    public static void displayPplRegistrationMenu()
    {
     System.out.println("1 - Incluir pessoa");
     System.out.println("2 - Alterar pessoa");
     System.out.println("3 - Remover pessoa");
     System.out.println("4 - Consultar pessoas");
     System.out.println("0 - Voltar ao menu principal");
     System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt();
    
        switch(option)
        {
            case 1:
                InsertPerson();
                break;
            case 2: 
                ChangePerson();
                break;
            case 3:
                RemovePerson();
                break;
            case 4:
                ConsultPeople();
                break;
            case 0:
                System.out.println("Fechando a tela de registros de pessoas");
                System.exit(0);
            default:
                System.out.print("Opção inválida. Tente novamente.");
        }
    }
    
    // Cadastrar pessoas
    public static void InsertPerson()
    {
        System.out.println("Digite o nome de quem você deseja cadastrar: ");

        var nome = scanner.nextInt();
    }

    // Alterar pessoas cadastradas.
    public static void ChangePerson()
    {
        System.out.println("Digite o nome da pessoa que você deseja alterar: ");
    }

    // Remover alguma pessoa cadastrada.
    public static void RemovePerson()
    {
        System.out.println("Digite o nome da pessoa que deseja remover: ");
    }

    // Consultar as pessoas cadastradas.
    public static void ConsultPeople()
    {

    }




    // Menu de cadastro dos tipos de objetos.
    public static void displayObjTpRegistrationMenu()
    {
     
    }

    // Menu de cadastro dos objetos.
    public static void displayObjRegistrationMenu()
    {
     
    }
    // Menu de cadastro das manutenções das ferramentas.
    public static void displayMtcRegistrationMenu()
    {
     
    }
}
