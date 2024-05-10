package Array;

import java.util.Arrays;

public class MaximazeHappinnesOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

    // Inicializa a soma de felicidade
    long totalHappiness = 0;

    // Varre a array comecando pelo final pra achar o maior valor
        for (int i = 0; i < k; ++i) {
        // Calcula a felicidade atual
        // Faz n - i - 1 pra achar k maiores elementos
        int currentHappiness = happiness[happiness.length - i - 1] - i;

        // Soma so os valores positivos da felicidade atual
        totalHappiness += Math.max(currentHappiness, 0);
    }

    // Retorna a felicidade atual
        return totalHappiness;
}
}
