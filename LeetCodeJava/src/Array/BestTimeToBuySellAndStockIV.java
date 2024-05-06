package Array;

public class BestTimeToBuySellAndStockIV {
    public int maxProfit(int k, int[] prices) {
                int numDias = prices.length;
                //setar uma variavel pro numero de dias

                // Agora inicializa uma array com a quantidade de transacoes e o ESTADO da transacao
                // 0 significa sem nada no estoque, e 1 signica com alguma no estoque
                int[][] lucros = new int[k + 1][2];

                // Pro caso da gente nao ter feito nenhuma transacao, mas ter estoque
                // o lucro inicial deve ser negativo, que seria o custo do estoque do primeiro dia
                for (int contagemTransacoes = 1; contagemTransacoes <= k; ++contagemTransacoes) {
                    lucros[contagemTransacoes][1] = -prices[0];
                }

                // Iterar a array comecando pelo segundo dia
                for (int indexDia = 1; indexDia < numDias; ++indexDia) {
                    // Iterar pra CADA transação desde k até 1
                    for (int contagemTransacoes = k; contagemTransacoes > 0; --contagemTransacoes) {
                        // Atualiza o lucro pra caso eu decida vender hoje
                        // Max of (lucro anterior por segurar um estoque e vender ele hoje, lucro anterior sem ter nenhum estoque)
                        lucros[contagemTransacoes][0] = Math.max(lucros[contagemTransacoes][1] + prices[indexDia], lucros[contagemTransacoes][0]);

                        // Atualiza o lucro caso eu decida comprar hoje
                        // Max of (lucro da transacao anterior menos o preco do estoque de hoje, lucro anterior com um estoque)
                        lucros[contagemTransacoes][1] = Math.max(lucros[contagemTransacoes - 1][0] - prices[indexDia], lucros[contagemTransacoes][1]);
                    }
                }

                // Retorna o maior lucro possivel durante k dias sem ter nenhum estoque
                return lucros[k][0];
            }
        }
