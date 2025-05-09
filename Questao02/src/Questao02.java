import java.util.Stack;

public class Questao02 {

    public static Stack<Integer> ordenarPilha(Stack<Integer> pilha) {
        Stack<Integer> auxiliar = new Stack<>();

        while (!pilha.isEmpty()) {
            int temp = pilha.pop();

            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                pilha.push(auxiliar.pop());
            }

            auxiliar.push(temp);
        }

        return auxiliar;
    }

    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(34);
        pilha.push(3);
        pilha.push(31);
        pilha.push(98);
        pilha.push(92);
        pilha.push(23);

        System.out.println("Pilha original: " + pilha);
        Stack<Integer> ordenada = ordenarPilha(pilha);
        System.out.println("Pilha ordenada (menor no topo): " + ordenada);
    }
}