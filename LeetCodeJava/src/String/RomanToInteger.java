package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
        public int romanToInt(String s) {
            //String pra representar todos os simbolos romanos
            String simbolosRomanos = "IVXLCDM";
            int[] valores = {1, 5, 10, 50, 100, 500, 1000};
            //array de valores correspondentes pra cada um dos caracteres da string
            Map<Character, Integer> numeralToValue = new HashMap<>();
            //por fim, um hashmap pra guardar os numeros e os valores, com Character e Iteger
            // Insere os simbolos-valores no mapa
            for (int i = 0; i < valores.length; ++i) {
                numeralToValue.put(simbolosRomanos.charAt(i), valores[i]);
            }

            int length = s.length();
            // Comeca com o valor do ultimo simbolo
            int totalValue = numeralToValue.get(s.charAt(length - 1));

            //  Varre a string ao contrario parando antes do primeiro numero
            for (int i = 0; i < length - 1; ++i) {
                // Determina o simbolo bom base se o caractere atual é menor do que o
                // proximo para seguir a regra dos numeros romanos
                int sign = numeralToValue.get(s.charAt(i)) < numeralToValue.get(s.charAt(i + 1)) ? -1 : 1;
                // Adiciona ou subtrai o valor do simbolo pro valor total
                totalValue += sign * numeralToValue.get(s.charAt(i));
            }

            // Retorna o valor total
            return totalValue;
        }
    }
