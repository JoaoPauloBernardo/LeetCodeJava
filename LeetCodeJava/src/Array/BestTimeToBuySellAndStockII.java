package Array;

public class BestTimeToBuySellAndStockII {
    public int maxProfit(int[] prices) {
        //é dada a array prices, eu quero o lucro maximo escolhendo um dia para comprar
        //e escolher um dia no futuro para vender, eu posso comprar mais de uma vez por Array
        //tambem posso vender no mesmo dia em que comprei sem ter lucro nenhum
        int lucroTotal = 0; //inicializa as compras de cada dia somadas como zero
        for (int i= 1; i < prices.length; i++)
        {
            int lucroDiario = Math.max(0,prices[i]- prices[i-1]);
            //comparacao o lucro atual e o valor do dia anterior e do dia atual pra saber o lucro do dia
            lucroTotal += lucroDiario;
        }
        return lucroTotal;
    }
}
