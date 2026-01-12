package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        //Alterando para nova versão no git

        List<Integer> list = Arrays.asList(2, 4, 5, 10, 7);

        //Criação do Stream relacionado a list, pegando todos os elementos da lista e multiplicando por 10.
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // 0 é o valor inicial da redução, chama-se valor indetidiade
        // (x,y) é uma função acumuladora, ela pega o valor atual no caso 0 e soma com o proximo elemento da stream.
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("SUM = " + sum);

        //Cria uma Stream a partir da lista original
        List<Integer> newList = list.stream()
                //Aplica um filtro: só passam os elementos que são divisíveis por 2.
                //Da lista original, sobram apenas [4, 10].
                .filter(x -> x % 2 == 0)
                //Transforma cada elemento que passou pelo filtro.
                //Multiplica por 10: [40, 100].
                .map(x -> x * 10)
                //Converte a Stream resultante em uma nova lista.
                //Resultado final: newList = [40, 100].
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(newList.toArray()));
    }
}
