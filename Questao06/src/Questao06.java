import java.util.LinkedList;
import java.util.Queue;

public class Questao06 {

    // Verifica se duas filas são iguais
    public static boolean filasIguais(Queue<Integer> f1, Queue<Integer> f2) {
        return f1.equals(f2);
    }

    // Compara as somas das filas para dizer qual é "maior"
    public static String filaMaior(Queue<Integer> f1, Queue<Integer> f2) {
        int somaF1 = soma(f1);
        int somaF2 = soma(f2);
        if (somaF1 > somaF2) return "F1 é maior";
        else if (somaF2 > somaF1) return "F2 é maior";
        else return "As filas têm a mesma soma";
    }

    // Soma os valores da fila
    private static int soma(Queue<Integer> f) {
        Queue<Integer> copia = new LinkedList<>(f);
        int total = 0;
        while (!copia.isEmpty()) {
            total += copia.poll();
        }
        return total;
    }

    // Calcula maior, menor e média
    public static void estatisticas(Queue<Integer> fila) {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }

        Queue<Integer> copia = new LinkedList<>(fila);
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int soma = 0;
        int count = 0;

        while (!copia.isEmpty()) {
            int val = copia.poll();
            if (val > maior) maior = val;
            if (val < menor) menor = val;
            soma += val;
            count++;
        }

        double media = soma / (double) count;

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
        System.out.println("Média: " + media);
    }

    // Copia F1 para F2
    public static void copiarFila(Queue<Integer> origem, Queue<Integer> destino) {
        destino.clear();
        destino.addAll(origem);
    }

    // Conta ímpares
    public static int contarImpares(Queue<Integer> fila) {
        Queue<Integer> copia = new LinkedList<>(fila);
        int count = 0;
        while (!copia.isEmpty()) {
            if (copia.poll() % 2 != 0) count++;
        }
        return count;
    }

    // Conta pares
    public static int contarPares(Queue<Integer> fila) {
        Queue<Integer> copia = new LinkedList<>(fila);
        int count = 0;
        while (!copia.isEmpty()) {
            if (copia.poll() % 2 == 0) count++;
        }
        return count;
    }

    // Teste principal
    public static void main(String[] args) {
        Queue<Integer> f1 = new LinkedList<>();
        Queue<Integer> f2 = new LinkedList<>();

        f1.add(10);
        f1.add(20);
        f1.add(30);

        f2.add(10);
        f2.add(20);
        f2.add(30);

        System.out.println("Filas iguais? " + filasIguais(f1, f2));
        System.out.println(filaMaior(f1, f2));

        estatisticas(f1);

        f2.clear();
        copiarFila(f1, f2);
        System.out.println("Fila F2 após cópia: " + f2);

        System.out.println("Impares em F1: " + contarImpares(f1));
        System.out.println("Pares em F1: " + contarPares(f1));
    }
}