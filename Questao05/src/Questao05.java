import java.util.Stack;

public class Questao05 {

    // Verifica se duas pilhas são iguais
    public static boolean pilhasIguais(Stack<Integer> p1, Stack<Integer> p2) {
        return p1.equals(p2);
    }

    // Diz qual pilha é "maior" (pela soma dos elementos)
    public static String pilhaMaior(Stack<Integer> p1, Stack<Integer> p2) {
        int somaP1 = soma(p1);
        int somaP2 = soma(p2);
        if (somaP1 > somaP2) return "P1 é maior";
        else if (somaP2 > somaP1) return "P2 é maior";
        else return "As pilhas têm a mesma soma";
    }

    // Soma os elementos da pilha (sem alterar a original)
    private static int soma(Stack<Integer> p) {
        Stack<Integer> aux = (Stack<Integer>) p.clone();
        int total = 0;
        while (!aux.isEmpty()) {
            total += aux.pop();
        }
        return total;
    }

    // Retorna maior, menor e média da pilha
    public static void estatisticas(Stack<Integer> p) {
        if (p.isEmpty()) {
            System.out.println("Pilha vazia");
            return;
        }

        Stack<Integer> aux = (Stack<Integer>) p.clone();
        int maior = aux.peek();
        int menor = aux.peek();
        int soma = 0;
        int count = 0;

        while (!aux.isEmpty()) {
            int valor = aux.pop();
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
            soma += valor;
            count++;
        }

        double media = soma / (double) count;

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
        System.out.println("Média: " + media);
    }

    // Copia P1 para P2 mantendo a ordem
    public static void copiarPilha(Stack<Integer> origem, Stack<Integer> destino) {
        Stack<Integer> aux = new Stack<>();
        for (int val : origem) {
            aux.push(val);
        }
        destino.clear();
        for (int val : aux) {
            destino.push(val);
        }
    }

    // Conta os números ímpares da pilha
    public static int contarImpares(Stack<Integer> p) {
        Stack<Integer> aux = (Stack<Integer>) p.clone();
        int count = 0;
        while (!aux.isEmpty()) {
            if (aux.pop() % 2 != 0) count++;
        }
        return count;
    }

    // Conta os números pares da pilha
    public static int contarPares(Stack<Integer> p) {
        Stack<Integer> aux = (Stack<Integer>) p.clone();
        int count = 0;
        while (!aux.isEmpty()) {
            if (aux.pop() % 2 == 0) count++;
        }
        return count;
    }

    // Teste principal
    public static void main(String[] args) {
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();

        p1.push(10);
        p1.push(20);
        p1.push(30);

        p2.push(10);
        p2.push(20);
        p2.push(30);

        // Verifica igualdade
        System.out.println("Pilhas iguais? " + pilhasIguais(p1, p2));
        System.out.println(pilhaMaior(p1, p2));

        // Estatísticas
        estatisticas(p1);

        // Copiando P1 para P2
        p2.clear();
        copiarPilha(p1, p2);
        System.out.println("Pilha P2 após cópia: " + p2);

        // Contando pares e ímpares
        System.out.println("Impares em P1: " + contarImpares(p1));
        System.out.println("Pares em P1: " + contarPares(p1));
    }
}