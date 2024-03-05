import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        BinaryTreeNode<Integer> A = new BinaryTreeNode<>(5);// Yeni değer(root) girişi


        BinaryTreeNode<Integer> B = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> C = new BinaryTreeNode<>(28);

        BinaryTreeNode<Integer> D = new BinaryTreeNode<>(16);
        BinaryTreeNode<Integer> E = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> F = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> G = new BinaryTreeNode<>(39);

        BinaryTreeNode<Integer> H = new BinaryTreeNode<>(88);
        BinaryTreeNode<Integer> I = new BinaryTreeNode<>(98);

        A.left = B;//sağ ve sol olarak konum belirttik
        A.right = C;

        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;

        System.out.print("Ilk eklenme: ");
        Listele(A);
        heapifyTree(A);
        System.out.print("\n heapify: ");
        Listele(A);

    }
    public static <T extends Comparable<T>> void heapifyTree(BinaryTreeNode<T> root) {
        if (root == null) {//boş olup olmadığını kontrol et
            return;
        }

        heapifyTree(root.left);//kök konumuna göre yığını düzenle.
        heapifyTree(root.right);
        bubbleDown(root);
    }

    private static <T extends Comparable<T>> void bubbleDown(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> sm = node;

        if (node.left != null && node.left.value.compareTo(node.value) < 0) {
            sm = node.left;
        }

        if (node.right != null && node.right.value.compareTo(node.value) < 0) {
            sm = node.right;
        }

        if (sm != node) {
            NodeData(node, sm);
            bubbleDown(sm);
        }
    }

    private static <T extends Comparable<T>> void NodeData(BinaryTreeNode<T> tmp1, BinaryTreeNode<T> tmp2) {
        T temp = tmp1.value;//kök datasını kaybetmemek için gecici tanımlayıp güncelledik.
        tmp1.value = tmp2.value;
        tmp2.value = temp;
    }

    public static <T extends Comparable<T>> void Listele(BinaryTreeNode<T> root) {
        if (root == null) {//Listeyi Kontol et
            return;
        }

        Queue<BinaryTreeNode<T>> toVisit = new ArrayDeque<>();//Kuyruktan çıkart ve listele.
        toVisit.add(root);//kökü gez ve ekle

        while (!toVisit.isEmpty()) {//Gezinme için boş olmadığını kontrol et.
            BinaryTreeNode<T> node = toVisit.poll();// Sıranın başından null olana dek gezer.En son return null yapar ve çıkar.
            System.out.print("\t"+node.value);

            if (node.left != null) {
                toVisit.add(node.left);
            }

            if (node.right != null) {
                toVisit.add(node.right);
            }
        }
    }

    private static class BinaryTreeNode<T extends Comparable<T>> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T value) {

            this.value = value;
        }
    }
}

