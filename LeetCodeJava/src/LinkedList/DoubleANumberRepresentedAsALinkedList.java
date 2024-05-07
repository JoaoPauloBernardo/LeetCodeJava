package LinkedList;

public class DoubleANumberRepresentedAsALinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    // Metodo pra dobrar o valor de cada nó na lista ligada
    public ListNode doubleIt(ListNode head) {
        // Primeiro inverte a lista pra comeca a multiplicacao pelo digito menos significativo
        head = reverse(head);
        // Cria um dummy node pra simplificar a construcao da lista ligada
        ListNode dummy = new ListNode();
        ListNode noAtual = dummy; // Vai ser usado pra colocar os nós na lista resultante
        int multiplicador = 2; // O valor pelo qual queremos multiplicar cada digito
        int carry = 0; // Pra guardar o valor que recebemos da multiplicacao
        //esse carry vai funcionar basicamente pra quando o valor do resultado da multiplicacao
        //for maior do que o tamanho da lista fornecida pelo leetcode
        //ou seja, vou poder adicionar nós extras com base no valor remanescente da carry
        //e o programa nao vai bugar caso a lista resultante seja maior que a lista fornecida

        // Atravessa a lista revertida pra multiplicar cada digito
        while (head != null) {
            int produto = head.val * multiplicador + carry; // Multiplica o valor do no atual e adiciona o carry
            carry = produto / 10; //  Computa o carry pra proxima vez que for iterar
            noAtual.next = new ListNode(produto % 10); // Coloca o digito na lista nova
            noAtual = noAtual.next; // Move o ponteiro pro proximo
            head = head.next; // Move pro proximo nó na lista dada pelo LeetCode
        }

        // Seo carry ainda existe depois de passar por todos os digitos adiciona um no novo pro carry
        if (carry > 0) {
            noAtual.next = new ListNode(carry);
        }

        //Reverte a lista resultado pra ficar na ordem correta e retorna ela
        return reverse(dummy.next);
    }

    // Metodo helper pra reverter uma lista ligada (importei da internet)
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(); // Dummy node to simplify list reversal
        ListNode current = head; // Pointer to traverse the original list
        // Iterate over the original list and reverse the links
        while (current != null) {
            ListNode next = current.next; // Remember the next node
            current.next = dummy.next; // Make current node point to the beginning of the new reversed list
            dummy.next = current; // Update the beginning of the reversed list to be the current node
            current = next; // Move to the next node in the original list
        }
        // Return the reversed list, excluding the dummy node
        return dummy.next;
    }
}
