package LinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class RemoveNodesFromALinkedList {
    public ListNode removeNodes(ListNode head) {
        // Inicializa uma array pra pegar os valores dos nós
        List<Integer> nodeValues = new ArrayList<>();

        //coleta valores
        while (head != null) {
            nodeValues.add(head.val);
            head = head.next;
        }

        // Usa a stack pra manter as infos dos nós e preservar eles
        Deque<Integer> stack = new ArrayDeque<>();
        for (int value : nodeValues) {
            // Remove todos os valores do stack que são menores do que o valor atual
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
            // Coloca o valor atual no stack
            stack.push(value);
        }

        // Cria um "dummy node" pra criar a linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Cria a linked list colocando os valores do stack
        while (!stack.isEmpty()) {
            // Como o stack é LIFO(Last in fist out), vou usar stack.pollLast() pra manter a ordem dos nós originais
            current.next = new ListNode(stack.pollLast());
            current = current.next;
        }

        // Retorna o próximo nó depois do "dummy" pq o primeiro nó é só um place holder
        return dummy.next;
    }
}

///** exemplo de codigo melhor feito pelo proprio leetcode, com uma run time de apenas 4ms, porém não é meu
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//class Solution {
//    public ListNode removeNodes(ListNode head) {
//        if(head.next == null){
//            return head;
//        }
//        ListNode prevNode = head;
//        ListNode currentNode = head.next;
//
//        while(currentNode != null){
//            ListNode nextNode = currentNode.next;
//            currentNode.next = prevNode;
//            prevNode = currentNode;
//            currentNode = nextNode;
//        }
//        head.next = null;
//        head = prevNode;
//
//        prevNode = head;
//        currentNode = head.next;
//        while(currentNode != null){
//            if(currentNode.val < prevNode.val){
//                currentNode = currentNode.next;
//            }
//            else{
//                ListNode nextNode = currentNode.next;
//                currentNode.next = prevNode;
//                prevNode = currentNode;
//                currentNode = nextNode;
//            }
//
//        }
//        head.next = null;
//        head = prevNode;
//        return head;
//    }
//}
