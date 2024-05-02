package String;

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        // Iterate do fim da string até o começo
        for (int index = num.length() - 1; index >= 0; index--) {
            // Converte o caracter do index atual em um integer
            int digit = num.charAt(index) - '0';

            // Checa de o digito é ímpar
            if ((digit & 1) == 1) {
                // Se o digito é impar, retorna a substring do comeco ate o index atual + 1
                // Isso porque a funcao substring em Java é end-exclusive
                return num.substring(0, index + 1);
            }
        }
        // Se nao tiver um digito impar, retorna so "", como pediu no exericico
        return "";
    }
}
