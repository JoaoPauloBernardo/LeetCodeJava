package Array;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        // acha o tamanho do grid
        int gridSize = grid.length;

        // Inicializa o grid de resposta com o tamanho reduzido
        int[][] maxLocalValues = new int[gridSize - 2][gridSize - 2];

        // Varra o grid considerando todos os subgrids 3x3
        for (int i = 0; i <= gridSize - 3; ++i) {
            for (int j = 0; j <= gridSize - 3; ++j) {
                // Inicializa o maior valor pro subgrid atual 3x3
                int maxVal = Integer.MIN_VALUE;

                // Loop para varrer todos os elementos no subgrid 3X3
                for (int x = i; x <= i + 2; ++x) {
                    for (int y = j; y <= j + 2; ++y) {
                        // Atualiza o valor maximo se um valor maior for encontrado
                        maxVal = Math.max(maxVal, grid[x][y]);
                    }
                }

                // Coloca o valor maximo no grid de resposta
                maxLocalValues[i][j] = maxVal;
            }
        }
        // Retorna o grid resposta
        return maxLocalValues;
    }
}
