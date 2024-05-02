package String;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveNumberThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        int resposta = -1;
        Set<Integer> verifica = new HashSet<>();

        for (int num : nums) {
            if (verifica.contains(-num))
                resposta = Math.max(resposta, Math.abs(num));
            // o max vai pegar o maior numero entre os 2
            //ou seja, a resposta vai virar o número absoluto Math.abs que ele achou
            else
                verifica.add(num);
        }

        return resposta;
    }
}