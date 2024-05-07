package Array;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxPorfit(int[] prices) {
        int venda = 0, ontem_venda = 0, comprar = Integer.MIN_VALUE, ontem_compra;
        for (int price : prices) {
            ontem_compra = comprar;
           comprar = Math.max(ontem_venda - price, ontem_compra);
            ontem_venda = venda;
            venda = Math.max(ontem_compra + price, ontem_venda);
        }
        return venda;
    }
}

