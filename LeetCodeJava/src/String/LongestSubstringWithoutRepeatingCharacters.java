package String;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public String lengthOfLongestSubstring(String s) {
        int n = s.length(); // Guarda o tamanho da string
        boolean[][] dp = new boolean[n][n]; // Cria uma tabela de programacao dinamica

        // Iniciliza todas as substrings de 1 caractere como palindromo
        for (boolean[] row : dp) {
            Arrays.fill(row, true);
        }

        int startIdx = 0; // comecando o index da maior substring de palindromo encontrada
        int maxLength = 1; // Tamanho da maior substring de palindromo inicializada como um

        // Cria a tabela de dp
        for (int i = n - 2; i >= 0; --i) { // Comeca do penultimo e se move ao contrario
            for (int j = i + 1; j < n; ++j) { // Compara com os caracteres a frente
                dp[i][j] = false; // Inicializa a substring I J como nao palindromo
                if (s.charAt(i) == s.charAt(j)) { // Se os caracteres baterem
                    dp[i][j] = dp[i + 1][j - 1]; // Checa de remove-los gera um palindromo
                    // Atualizada a posicao e o tamanho se um palindromo maior for encontrado
                    if (dp[i][j] && maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }

        // Extrai o palindromo mais longo da substring
        return s.substring(startIdx, startIdx + maxLength);
    }
}
//a solucao mais otimizada fornecida pelo leetcode e essa
//class Solution {
//    int start;
//    int end;
//    public String longestPalindrome(String s) {
//        if(s == null) return "";
//        char[] chArray = s.toCharArray();
//        findPalindrome(chArray, 0);
//        return s.substring(start, end + 1);
//    }
//    //not my code
//    private void findPalindrome(char[] chArray, int index) {
//        int low = index, high = index, length = chArray.length;
//
//        if(index > length) {
//            return;
//        }
//
//        while(high < length - 1 && chArray[high] == chArray[high+1]) {
//            high++;
//        }
//
//        index = high;
//
//        while(low-1 >= 0 && high+1 <= length-1 && chArray[low-1] == chArray[high+1]) {
//            low--;
//            high++;
//        }
//
//        if(end - start < high - low) {
//            end = high;
//            start = low;
//        }
//
//        findPalindrome(chArray, index+1);
//    }
