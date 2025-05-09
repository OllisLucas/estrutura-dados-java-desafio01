import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Questao03 {

    // Fila de pilhas
    private Queue<Stack<Integer>> filaDePilhas = new LinkedList<>();

    // Adiciona uma nova pilha na fila
    public void enfileirarPilha(Stack<Integer> novaPilha) {
        filaDePilhas.add(novaPilha);
    }

    // Remove a primeira pilha da fila
    public Stack<Integer> desenfileirarPilha() {
        return filaDePilhas.poll();
    }

    // Insere um número na pilha da frente da fila
    public void inserirNumeroNaPilhaFrontal(int numero) {
        if (!filaDePilhas.isEmpty()) {
            filaDePilhas.peek().push(numero);
        } else {
            System.out.println("A fila está vazia.");
        }
    }

    // Remove o número do topo da pilha da frente
    public Integer removerNumeroDaPilhaFrontal() {
        if (!filaDePilhas.isEmpty() && !filaDePilhas.peek().isEmpty()) {
            return filaDePilhas.peek().pop();
        } else {
            System.out.println("Fila ou pilha está vazia.");
            return null;
        }
    }

    // Teste
    public static void main(String[] args) {
        Questao03 estrutura = new Questao03();

        // Criando e adicionando pilha 1
        Stack<Integer> pilha1 = new Stack<>();
        pilha1.push(10);
        pilha1.push(20);
        estrutura.enfileirarPilha(pilha1);

        // Criando e adicionando pilha 2
        Stack<Integer> pilha2 = new Stack<>();
        pilha2.push(5);
        pilha2.push(15);
        estrutura.enfileirarPilha(pilha2);

        // Inserindo número na primeira pilha da fila
        estrutura.inserirNumeroNaPilhaFrontal(99);

        // Removendo número da primeira pilha
        Integer removido = estrutura.removerNumeroDaPilhaFrontal();
        System.out.println("Número removido da primeira pilha: " + removido);

        // Removendo uma pilha inteira
        Stack<Integer> pilhaRemovida = estrutura.desenfileirarPilha();
        System.out.println("Pilha removida: " + pilhaRemovida);
    }
}