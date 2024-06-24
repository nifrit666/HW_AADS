public class Tree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;
        private boolean isRed;

        public Node(V value) {
            this.value = value;
            this.isRed = true;
        }

    }

    public void add(V value) {
        root = addNode(root, value);
        root.isRed = false;
    }

    private Node addNode(Node node, V value) {
        if (node == null) {
            return new Node(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = addNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = addNode(node.right, value);
        } else {
            return node;
        }

        // Балансировка дерева после добавления нового узла
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    public boolean contains(V value) {
        Node node = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return printTree(root, "", true, new StringBuilder()).toString();
    }

    private StringBuilder printTree(Node node, String prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            printTree(node.right, prefix + (isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.value.toString())
                .append(node.isRed ? " (Red)" : " (Black)").append("\n");
        if (node.left != null) {
            printTree(node.left, prefix + (isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }
}