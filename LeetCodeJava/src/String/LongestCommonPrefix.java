package String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int numberOfStrings = strs.length; // Numero de todas as strings de um array

        for (int index = 0; index < strs[0].length(); ++index) {
            //loop pelo primeiro caractere de cada string
            // Compara o caractere com a mesma posicao no restante das strings
            for (int stringIndex = 1; stringIndex < numberOfStrings; ++stringIndex) {
                // 1. Se a string atual e menor do que o index do caractere
                // 2. Se o caractere atual nao e igual ao caractere na primeira string
                // Em qualquer um dos casos achamos o prefixo comum
                if (strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)) {
                    // Assim retornamos a substring do comeco ate o index do caractere
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }
}
