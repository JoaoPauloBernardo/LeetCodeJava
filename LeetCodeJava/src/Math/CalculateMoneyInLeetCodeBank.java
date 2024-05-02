package Math;

public class CalculateMoneyInLeetCodeBank {
    /**
     preciso calculo o numero de semanas, e adicionar o dinheiro com base no dia, resetando toda semana
     n é o numero de dias, e o retorno deve ser o tanto de dinheiro feito em n
     */
    public int totalMoney(int n) {
        // Calcula o numero de semanas completas
        int semanas = n / 7;

        // Calcula o numero de dias restantes depois das semanas completas
        int diasRestantes = n % 7;

        // Na primeira semana a pessoa SEMPRE salva 1+2+...+7 = 28 reais.
        // A quantidade aumenta em 7 para cada semana subsequente.
        int dinheiroSemanas = (28 + (28 + 7 * (semanas - 1))) * semanas / 2;
        //a primeira parte do calculo representa o dinheiro feito numa semana inteira
        //a segunda parte multiplica por semanas/2 para representar o dinheiro dos domingos

        // Calcula o numero de dinheiro ganho nos dias restantes
        // Starting day of the week determines the money saved on the first day of remaining days.
        int dinheiroDiasRestantes = ((semanas * 2) + diasRestantes + 1) * diasRestantes / 2;

        // Return the sum of money saved during the complete weeks and the remaining days.
        return dinheiroSemanas + dinheiroDiasRestantes;
    }
}
