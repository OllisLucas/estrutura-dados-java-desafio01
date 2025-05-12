# 🔹 Questão 3:

Nessa questão, basicamente precisamos juntar duas estruturas: fila e pilha. A fila vai guardar várias pilhas, como se fosse uma "fila de caixas", e cada caixa é uma pilha de números. Eu criei uma fila com `LinkedList<Stack<Integer>>`, porque o LinkedList já funciona como fila em Java. Aí implementei funções para adicionar uma nova pilha na fila `(enfileirarPilha)` e remover uma pilha `(desenfileirarPilha)`. Também fiz funções para colocar e tirar números de dentro da pilha da frente da fila. Então dá pra trabalhar com as pilhas dentro da fila como se fossem objetos separados.
