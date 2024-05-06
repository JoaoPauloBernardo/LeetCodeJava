package String;

public class MergeStringAlternately {
    //leetcode ja deu o metodo
    public String mergeAlternately(String word1, String word2) {
        // Tamanho das 2 palavras
        int tamanhopalavra1 = word1.length(), tamanhopalavra2 = word2.length();
        // Builder de string pra criar uma string de resultado
        StringBuilder mergedString = new StringBuilder();

        // Itera ate que tenha caracter restante em pelo menos uma das palavras
        for (int index = 0; index < tamanhopalavra1 || index < tamanhopalavra2; ++index) {
            // Se o index estiver dentro dos limites da primeira palavra, adiciona o caractere dela
            if (index < tamanhopalavra1) {
                mergedString.append(word1.charAt(index));
            }
            // Ja se estiver dentro dos limites da palavra 2, adiciona o respectivo caractere
            if (index < tamanhopalavra2) {
                mergedString.append(word2.charAt(index));
            }
        }
        // Retorna a string resultante
        return mergedString.toString();
    }
}
