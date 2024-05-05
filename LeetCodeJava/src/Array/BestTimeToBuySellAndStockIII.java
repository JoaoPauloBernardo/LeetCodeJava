package Array;

public class BestTimeToBuySellAndStockIII {
        public int maxProfit(int[] prices) {
            //custo (ou luro negativo) da primeira e segunda compra deve ser inicializado como -prices[0]
            int custoPrimeiraCompra = -prices[0];
            //ja o lucro da primeira e segunda venda deve ser inicializado como zero
            int lucroPrimeriaVenda = 0;

            int custoSegundaCompra = -prices[0];

            int lucroSegundaVenda = 0;
            //agora vamos iterar por toda a string precos
            //e atualizar cada estado com cara preço novo
            for (int i= 1; i < prices.length; i++)
            {
                custoPrimeiraCompra = Math.max(custoPrimeiraCompra, -prices[i]);
                //- prices por que eu to "gastando" o dinheiro
                lucroPrimeriaVenda = Math.max(lucroPrimeriaVenda, custoPrimeiraCompra + prices[i]);
                //compara com o custo da primeira compra + o preco atual, assim tendo o max de lucro
                custoSegundaCompra = Math.max(custoSegundaCompra, lucroPrimeriaVenda -prices[i]);
                //eu tenho que "extrair" o dinheiro da segunda compra do lucro da primeira
                //logo, o lucro total vai ser o que eu retornar no lucroSegundaVenda
                lucroSegundaVenda = Math.max(lucroSegundaVenda,custoSegundaCompra + prices[i]);
            }
            return lucroSegundaVenda;
        }
    }
