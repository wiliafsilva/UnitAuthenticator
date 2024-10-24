import Models.Aluno;
import TabelaHash.TabelaHash;

import java.util.Scanner;

public class Main {
    private static TabelaHash tH = new TabelaHash(10);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU DO SISTEMA =====");
            System.out.println("1. Inserção de Usuário");
            System.out.println("2. Remoção de Usuário");
            System.out.println("3. Busca de Usuário");
            System.out.println("4. Login");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    inserirAluno(scanner);
                    break;
                case 2:
                    removerAluno(scanner);
                    break;
                case 3:
                    buscarAluno(scanner);
                    break;
                case 4:
                    loginTeste(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }
    
    private static void inserirAluno(Scanner scanner){
        System.out.print("Digite o nome do usuário: ");
        String userName = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        Aluno aluno = new Aluno(userName, password);
        tH.insert(aluno);
        System.out.println("Aluno adicionado! \n");
    }

    private static void removerAluno(Scanner scanner){
        System.out.println("Digite o nome do aluno que tu quer remover:");
        String userName = scanner.nextLine();
        tH.remove(userName);
        System.out.println("Aluno removido\n");
    }

    private static void buscarAluno(Scanner scanner){
        System.out.println("Digite o nome do aluno que tu quer buscar: ");
        String userName = scanner.nextLine();

        if (tH.existe(userName)){
            System.out.println("Aluno encontrado\n");
        }
        else{
            System.out.println("Aluno não encontrado\n");
        }
    }

    private static void loginTeste(Scanner scanner){
        System.out.print("Digite o nome do aluno: ");
        String userName = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        if (tH.autenticar(userName, password)){
            System.out.println("Login feito, bem vindo!\n");
        }
        else{
            System.out.println("Usuário/Senha incorreto.\n");
        }
    }
}