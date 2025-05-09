public class Questao08 {

    // Nó da lista
    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    // Lista simplesmente encadeada
    static class Lista {
        No inicio;

        // Insere no final da lista
        public void inserir(int valor) {
            No novo = new No(valor);
            if (inicio == null) {
                inicio = novo;
            } else {
                No atual = inicio;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novo;
            }
        }

        // Verifica se a lista contém um valor
        public boolean contem(int valor) {
            No atual = inicio;
            while (atual != null) {
                if (atual.valor == valor) return true;
                atual = atual.proximo;
            }
            return false;
        }

        // Exibe a lista
        public void exibir() {
            No atual = inicio;
            System.out.print("Lista: ");
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    // Gera a união sem repetição de L1 e L2
    public static Lista uniao(Lista l1, Lista l2) {
        Lista l3 = new Lista();

        No atual = l1.inicio;
        while (atual != null) {
            if (!l3.contem(atual.valor)) {
                l3.inserir(atual.valor);
            }
            atual = atual.proximo;
        }

        atual = l2.inicio;
        while (atual != null) {
            if (!l3.contem(atual.valor)) {
                l3.inserir(atual.valor);
            }
            atual = atual.proximo;
        }

        return l3;
    }

    // Gera a interseção de L1 e L2
    public static Lista intersecao(Lista l1, Lista l2) {
        Lista l4 = new Lista();

        No atual = l1.inicio;
        while (atual != null) {
            if (l2.contem(atual.valor) && !l4.contem(atual.valor)) {
                l4.inserir(atual.valor);
            }
            atual = atual.proximo;
        }

        return l4;
    }

    // Teste
    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();

        // Preenchendo L1 e L2
        l1.inserir(1);
        l1.inserir(2);
        l1.inserir(3);
        l1.inserir(4);

        l2.inserir(3);
        l2.inserir(4);
        l2.inserir(5);
        l2.inserir(6);

        System.out.print("L1: "); l1.exibir();
        System.out.print("L2: "); l2.exibir();

        Lista uniao = uniao(l1, l2);
        Lista intersecao = intersecao(l1, l2);

        System.out.print("União (sem repetição): "); uniao.exibir();
        System.out.print("Interseção: "); intersecao.exibir();
    }
}