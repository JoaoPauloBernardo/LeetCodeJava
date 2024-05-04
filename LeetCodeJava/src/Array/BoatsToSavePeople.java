package Array;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        //quero carregar o máximo de []people no minimo possivel de totalDeBarcos
        //para isso vou usar uma tecnica de two-pointer, a ideia e colocar a pessoa mais pesada com uma leve
        //que nao ultrapasse o limite de peso, assim, otimizando o uso dos barcos
        //primeiro inicializado o total de barcos como zero, ja que o esperado e o minimo possivel
        int totalDeBarcos = 0;
        Arrays.sort(people); //colocando a array em ordem crescente para facilitar a busca e o uso de two-pointers
        //inicializando os 2 ponteiros
        for(int leve = 0, pesado = people.length - 1; leve <= pesado; pesado--){
            //se o leve couber com o pesado, leve++ indicando que ele entrou no barco
            //de qualquer forma pesado-- indica que o pesado entrou no barco, visto que ele SEMPRE vai estar no barco
            if(people[leve] + people[pesado] <= limit){
                leve++;
            }
            totalDeBarcos++;
        }
    return totalDeBarcos;
    }
}

