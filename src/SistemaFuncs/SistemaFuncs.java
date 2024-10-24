package SistemaFuncs;
import Models.Aluno;
import TabelaHash.TabelaHash;
import java.util.Scanner;

public class SistemaFuncs {
    public void inserirUsuario(Scanner scanner){
        System.out.print("Digite o nome do usuário: ");
        String userName = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        Aluno aluno = new Aluno(userName, password);

    }
}
