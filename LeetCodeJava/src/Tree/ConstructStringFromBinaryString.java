package Tree;

/**
 * Deve-se construir uma string que consiste em parentesis e integers de uma arvore binaria
 * com uma ordem pré ordenada de travessia
 * <p>O nó vazio deve ser representado por "()".
 * E é preciso esconder todos os pares de parentesis que nao afetam o mapa de relacionamento entre
 * a árvore binária original e a string que voce ta formando, lembrando que o relaciomento é one-to-one
 *
 * Por exemplo, no exemplo 1 do exercicio dado o input Input: Binary tree: [1,2,3,4]
 * o output sera correto seria:
 * Output: "1(2(4))(3)"
 * e nao "1(2(4)())(3()())", por que voce TEM que esconder os parentesis desnecessários!
 */
public class ConstructStringFromBinaryString {
    // Deve seguir certas regras para a conversão, são elas:
    // 1. Omitir QUALQUER crianca se estiver entre nulos
    // 2. Inclua apenas a crianca da esquerda se a crianca da direita for nula
    // 3. Inclua ambas se nenhuma for nula
    public String tree2str(TreeNode root) {
        // Caso base: se o nó atual é nulo, retorna uma string vazia
        if (root == null) {
            return "";
        }

        // Caso 2: quando esquerda E direita sao nulos
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }

        // Caso 3: quando só a crianca da direita é nula
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }

        // Caso 3: quando nenhum dos 2 é nulo
        // Note: O nó da crianca da direita e representado mesmo podendo ser nulo,
        //       por que a crianca da esquerda NAO e nula
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    // Definicao de arvore binaria que o LeetCode deu
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}