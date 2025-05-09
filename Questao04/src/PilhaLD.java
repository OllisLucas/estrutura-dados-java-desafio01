// Classe do nó da lista duplamente encadeada
class No {
    int valor;
    No anterior, proximo;

    No(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

// TAD Pilha implementada com lista duplamente encadeada
public class PilhaLD {
    private No topo;

    // Construtor
    public PilhaLD() {
        topo = null;
    }

    // Insere um novo elemento no topo (push)
    public void push(int valor) {
        No novo = new No(valor);
        if (topo != null) {
            topo.anterior = novo;
            novo.proximo = topo;
        }
        topo = novo;
    }

    // Remove e retorna o elemento do topo (pop)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        if (topo != null) {
            topo.anterior = null;
        }
        return valor;
    }

    // Retorna o elemento do topo sem remover (peek)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return topo.valor;
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Teste
    public static void main(String[] args) {
        PilhaLD pilha = new PilhaLD();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo da pilha: " + pilha.peek()); // 30
        System.out.println("Removido: " + pilha.pop());       // 30
        System.out.println("Novo topo: " + pilha.peek());     // 20
    }
}