package Array;

public class MedianOfTwoSortedArrays {
    private int tamanhoNums1, tamanhoNums2;
    private int[] nums1;
    private int[] nums2;
    //variaveis FORA da funcao principal para guardar as arrays e o tamanho delas
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        tamanhoNums1 = nums1.length;
        tamanhoNums2 = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;

        int medianaEsquerda = achaKthEelemento(0,0, (tamanhoNums1 + tamanhoNums2 +1)/2);
        int medianaDireita = achaKthEelemento(0,0, (tamanhoNums1 + tamanhoNums2 + 2)/2);

        return (medianaDireita + medianaEsquerda)/2.0; //2.0 pq o return é de uma funcao DOUBLE
    }
    private int achaKthEelemento(int startNums1, int startNums2, int k){
        //caso base pra recursividade
        if(startNums1 >= tamanhoNums1){
            return nums2[startNums2 + k -1]; //seleciona o elemento Kth do nums2
        }
        if(startNums2 >= tamanhoNums2){
            return nums1[startNums1 +k -1]; //seleciona o elemento Kth do nums1
        }
        if(k==1){//se o k for 1, entao retorna o minimo dos startNums atuais
            return Math.min(nums1[startNums1], nums2[startNums2]);
        }
        //agora, basta calcular o ponto medio para comparar os elementos
        int midIndex = k/2;
        //atribui INT_MAX pra caso o midIndex esteja pra fora dos limites da array
        int midValNums1 = startNums1 + midIndex -1 < tamanhoNums1 ? nums1[startNums1 + midIndex - 1] : Integer.MAX_VALUE;
        int midValNums2 = startNums2 + midIndex -1 < tamanhoNums2 ? nums2[startNums2 + midIndex - 1] : Integer.MAX_VALUE;
        //discarta metade dos elementos da array que sejam menores do que o valor mediano
        //ja que nenhum desses valores NUNCA teria o valor k
        if(midValNums1 < midValNums2){
            return achaKthEelemento(startNums1 + midIndex, startNums2, k - midIndex);
        }else {
            return achaKthEelemento(startNums1, startNums2 + midIndex, k - midIndex);
        }
    }
}
