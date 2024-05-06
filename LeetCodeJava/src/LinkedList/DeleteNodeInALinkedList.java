package LinkedList;

public class DeleteNodeInALinkedList{
    public class ListNode{
    int val; // Valor do nó
    ListNode next; // Referencia pra chegar no proximo nó na list

    //Construtor pra inicilizar o nó com um valor
    ListNode(int x) {
        val = x;
    }
    }
//tudo isso acima foi dado pelo proprio leetcode
    public class Solution {
    /**
     * Deletes a node (except the tail) from a singly-linked list, given only access to that node.
     * The input node should not be the tail, and the list should have at least two elements.
     * @param node the node to be deleted
     */
    public void deleteNode(ListNode node) {
        // Basta copiar o valor do proximo nó no nó atual
        node.val = node.next.val;
        // Seta o ponteiro do nó atual para pular o proximo nó, deletando ele
        node.next = node.next.next;
    }
    }
}
