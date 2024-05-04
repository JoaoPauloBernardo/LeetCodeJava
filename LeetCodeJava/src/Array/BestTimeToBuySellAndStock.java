package Array;

public class BestTimeToBuySellAndStock {
    public int maxProfit(int[] prices) {
        //é dada a array prices, eu quero o lucro maximo escolhendo um unico dia para comprar
        //e escolher um dia no futuro para vender
        int lucroMaximo = 0;
        int precoMinimo = prices[0];

        for (int preco : prices) {
            // eu poderia usar um if para comparar se o precominimo é menor do que o i anterior
            //mas para isso e mais facil usar funcoes Math de comparação em array

            lucroMaximo = Math.max(lucroMaximo, preco - precoMinimo);
            precoMinimo = Math.min(precoMinimo, preco); //o primeiro é o que eu quero comparar com o segundo
        }
        return lucroMaximo;
    }
}
