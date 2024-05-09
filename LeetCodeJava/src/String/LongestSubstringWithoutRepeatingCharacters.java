package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Usa o hashset pra guardar os caracteres sem precisar criar uma duplicata
        Set<Character> charSet = new HashSet<>();
        int leftPointer = 0; // inicializa o ponteiro esquerdo
        int maxLength = 0; // variavel pra guardar qual a substring mais longa

        // Percorre a string com o ponteiro DIREITO
        for (int rightPointer = 0; rightPointer < s.length(); ++rightPointer) {
            char currentChar = s.charAt(rightPointer); // Caractere atual no ponteiro esquerdo

            // Se o caractere atual ja estiver no hashset quer dizer que achamos um caractere repetido
            // Passamos o ponteiro esquerdo para a direita ate o caractere duplicado ser removido
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(leftPointer++));
            }

            charSet.add(currentChar);

            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }
        return maxLength;
    }
}
