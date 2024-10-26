package TabelaHash;
import Models.Aluno;

import java.util.LinkedList;

public class TabelaHash {
    private LinkedList<Aluno>[] tabela;
    public int tamanhoTabela;

    @SuppressWarnings("unchecked") // Só para parar de retornar aquele erro irritante que acontecia uma vez ou outra de "falta espaço"
    public TabelaHash(int tamanhoTabela) {
        this.tamanhoTabela = tamanhoTabela;
        tabela = new LinkedList[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++) {
            tabela[i] = new LinkedList<>();
        }
    }
    //Usar um hash polinomial para evitar colisões
    private int hash(String chave) {
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash = (31 * hash + chave.charAt(i)) % tamanhoTabela; // 31 é um número primo comum
        }
        return hash;
    }
    // Ao criar Usuário e senha agora gera alerta que impede valores vázios
    public void insert(Aluno aluno) {
        if (aluno.getUserName() == null || aluno.getUserName().trim().isEmpty()) {
            System.out.println("Erro: O nome de usuário não pode ser vazio.");
            return;
        }

        if (aluno.getPassword() == null || aluno.getPassword().trim().isEmpty()) {
            System.out.println("Erro: A senha não pode ser vazia.");
            return;
        }

        int index = hash(aluno.getUserName());
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(aluno.getUserName())) {
                System.out.println("Usuário existente, tente novamente.");
                return;
            }
        }

        tabela[index].add(aluno);
        System.out.println("Aluno adicionado com sucesso! Obrigado por usar o Unit Authenticator.\n");
    }

    // Modificado para mostrar o nome do aluno removido
    public void remove(String userName){
        int index = hash(userName);
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(userName)) {
                tabela[index].remove(a);
                System.out.println("Aluno " + userName + " removido com sucesso!\n");
                return;
            }
        }
        System.out.println("Aluno não encontrado na nossa tabela.\n");
    }

    public boolean autenticar(String userName, String password){
        int index = hash(userName);
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(userName) && a.getPassword().equals(password)) {
                System.out.println("Aluno logado com sucesso! Bem vindo, " + a.getUserName());
                return true;
            }
        }
        return false;
    }

    // EU QUASE ESQUECI DE FAZER ESTE MÉTHODO RSRSRSRS
    // modificado para exiber o nome do aluno encontrado
    public boolean existe(String userName){
        int index = hash(userName);
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(userName)) {
                System.out.println("Aluno " + userName + " existe \n");
                return true;
            }
        }
        return false;
    }

}
