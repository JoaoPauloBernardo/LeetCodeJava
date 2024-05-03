package HashTable;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Criando um hash map pra ter o integer e o target
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Iterate over the array elements
        for (int i = 0; i < nums.length; i++) {
            int atual = nums[i]; // Elemento atual
            int complemento = target - atual;
            // Quando adicionado ao "atual" tem que ser igual ao target

            if (indexMap.containsKey(complemento)) {
                //basta checar se o complemento ja ta no mapa
                //e se ja estiver retorna o complemento dos 2 numeros
                return new int[] {indexMap.get(complemento), i};
            }


            indexMap.put(atual, i); //Colocando o "i" do atual e o proprio atual no mapa
        }
        throw new IllegalArgumentException("Sem solução");
    }
}

