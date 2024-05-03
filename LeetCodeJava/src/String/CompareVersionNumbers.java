package String;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int length1 = version1.length(), length2 = version2.length();
        //guarda os tamanhos das strings

        // Inicializando os ponteiros pra percorrer a string
        for (int i = 0, j = 0; (i < length1) || (j < length2); ++i, ++j) {
            int chunkVersion1 = 0, chunkVersion2 = 0; // Inicializando os numeros

            while (i < length1 && version1.charAt(i) != '.') {
                chunkVersion1 = chunkVersion1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            while (j < length2 && version2.charAt(j) != '.') {
                chunkVersion2 = chunkVersion2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            // Compara os chunks das strings
            if (chunkVersion1 != chunkVersion2) {
                // Retorna -1 se for menor e 1 se for maior
                return chunkVersion1 < chunkVersion2 ? -1 : 1;
            }
            // Se os chunks forem iguais, vai pro próximo
        }
        // Se todos forem checados e forem iguais, retorna 0
        return 0;
    }
}
