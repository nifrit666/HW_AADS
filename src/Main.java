
public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        tree.add(15);
        tree.add(16);
        tree.add(17);
        tree.add(18);
        tree.add(19);
        tree.add(20);

        System.out.println(tree.contains(3));
        System.out.println(tree.contains(10));
        System.out.println();
        System.out.println(tree.toString());

    }
}
