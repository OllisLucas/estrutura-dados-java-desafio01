public class Questao07 {

    static final int TAMANHO_MAX = 10;

    // Representa um nó da lista
    static class No {
        int valor;
        int proximo;

        public No() {
            this.valor = 0;
            this.proximo = -1;
        }
    }

    static class ListaEstatica {
        No[] nos = new No[TAMANHO_MAX];
        int inicio = -1;
        int disponivel = 0;

        public ListaEstatica() {
            for (int i = 0; i < TAMANHO_MAX; i++) {
                nos[i] = new No();
                nos[i].proximo = i + 1;
            }
            nos[TAMANHO_MAX - 1].proximo = -1;
        }

        // Aloca uma posição livre
        private int aloca() {
            if (disponivel == -1) {
                System.out.println("Sem espaço disponível!");
                return -1;
            }
            int indice = disponivel;
            disponivel = nos[indice].proximo;
            return indice;
        }

        // Libera uma posição
        private void libera(int indice) {
            nos[indice].proximo = disponivel;
            disponivel = indice;
        }

        // Insere um elemento no início da lista
        public void inserir(int valor) {
            int novo = aloca();
            if (novo == -1) return;

            nos[novo].valor = valor;
            nos[novo].proximo = inicio;
            inicio = novo;
        }

        // Remove o primeiro elemento
        public void remover() {
            if (inicio == -1) {
                System.out.println("Lista vazia!");
                return;
            }
            int temp = inicio;
            inicio = nos[inicio].proximo;
            libera(temp);
        }

        // Exibe a lista
        public void exibir() {
            int atual = inicio;
            System.out.print("Lista: ");
            while (atual != -1) {
                System.out.print(nos[atual].valor + " ");
                atual = nos[atual].proximo;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);

        lista.exibir(); // Deve mostrar: 30 20 10

        lista.remover(); // Remove 30
        lista.exibir(); // Deve mostrar: 20 10
    }
}