package String;

import java.util.HashSet;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        //crio uma HashSet para guardar os caracteres sem precisar criar uma duplicata
        int ponteiroEsquerdo = 0;
        String palindromo = null;
        HashSet<Character> charSet = new HashSet<>(); //fazer com arraylist
        //inicializo os dois ponteiros pra poder percorrer a string
        for(int ponteiroDireito = 0; ponteiroDireito < s.length(); ponteiroDireito ++){
            char caractereAtual = s.charAt(ponteiroDireito);

        }
        return palindromo.substring(ponteiroEsquerdo);
    }
}
