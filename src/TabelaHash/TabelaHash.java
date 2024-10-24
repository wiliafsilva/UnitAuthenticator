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
    private int hash(String chave){
        int hash = 0;
        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i);
        }
        return (hash%tamanhoTabela);
    }

    public void insert(Aluno aluno){
        int index = hash(aluno.getUserName());
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(aluno.getUserName())) {
                System.out.println("Usuário existente, tente novamente.");
                return;
            }
        }
        tabela[index].add(aluno);
        System.out.println("Aluno adicionado com sucesso!! Obrigado por usaro Unit Authenticator");
    }

    public void remove(String userName){
        int index = hash(userName);
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(userName)) {
                tabela[index].remove(a);
                System.out.println("Aluno removido com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado na nossa tabela.");
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
    public boolean existe(String userName){
        int index = hash(userName);
        for (Aluno a : tabela[index]) {
            if (a.getUserName().equals(userName)) {
                System.out.println("Aluno existe");
                return true;
            }
        }
        return false;
    }

}
