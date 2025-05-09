public class Questao09 {

    // Nó da lista duplamente encadeada
    static class No {
        int valor;
        No anterior, proximo;

        No(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    // Lista duplamente encadeada
    static class Lista {
        No inicio;
        No fim;

        // (a) Estrutura inicial

        // (b) Localiza o nó da posição P (1-based)
        public No locate(int pos) {
            if (pos < 1) return null;
            No atual = inicio;
            int i = 1;
            while (atual != null && i < pos) {
                atual = atual.proximo;
                i++;
            }
            return (i == pos) ? atual : null;
        }

        // (c) Insere item E na posição P
        public boolean insereP(int valor, int pos) {
            No novo = new No(valor);
            if (pos < 1) return false;

            if (pos == 1) {
                novo.proximo = inicio;
                if (inicio != null) inicio.anterior = novo;
                inicio = novo;
                if (fim == null) fim = novo;
                return true;
            }

            No atual = locate(pos - 1);
            if (atual == null) return false;

            novo.proximo = atual.proximo;
            novo.anterior = atual;
            if (atual.proximo != null) atual.proximo.anterior = novo;
            atual.proximo = novo;
            if (novo.proximo == null) fim = novo;
            return true;
        }

        // (d) Remove item na posição P e retorna seu valor
        public Integer removaP(int pos) {
            No alvo = locate(pos);
            if (alvo == null) return null;

            if (alvo.anterior != null) alvo.anterior.proximo = alvo.proximo;
            else inicio = alvo.proximo;

            if (alvo.proximo != null) alvo.proximo.anterior = alvo.anterior;
            else fim = alvo.anterior;

            return alvo.valor;
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

    // Teste
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.insereP(10, 1);
        lista.insereP(20, 2);
        lista.insereP(30, 3);
        lista.exibir(); // Lista: 10 20 30

        System.out.println("Elemento na posição 2: " + lista.locate(2).valor); // 20

        lista.insereP(15, 2);
        lista.exibir(); // Lista: 10 15 20 30

        Integer removido = lista.removaP(3); // Remove o 20
        System.out.println("Removido: " + removido);
        lista.exibir(); // Lista: 10 15 30
    }
}
