package com.druidwood;

import static java.lang.System.*;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(T payload) {
        this.root = new Node<>(payload, null, null);
    }

    public static class Node<T> {
        T payload;
        Node<T> left;
        Node<T> right;

        public Node(T payload, Node<T> left, Node<T> right) {
            this.payload = payload;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * insert a new Node into the tree
     *
     * @param payload
     * @return Added node
     */
    public Node<T> insert(T payload) {
        // Start at the root node
        Node<T> current = this.root;
        int depth = 2;
        while (true) {

            if (payload.compareTo(current.payload) < 0) {
                if (current.left == null) {
                    current.left = new Node<>(payload, null, null);
                    out.printf("Adding %s to the left of %s at level %d\n", payload.toString(), current.payload.toString(), depth);
                    return current.left;
                } else {
                    out.println("Traversing left");
                    current = current.left;
                    depth++;
                    continue;
                }
            }

            if (payload.compareTo(current.payload) > 0) {
                if (current.right == null) {
                    current.right = new Node<>(payload, null, null);
                    out.printf("Adding %s to the right of %s at level %d\n", payload.toString(), current.payload.toString(), depth);
                    return current.left;
                } else {
                    out.println("Traversing right");
                    current = current.right;
                    depth++;
                    continue;
                }
            }

           break;
        }
        return current;
    }
}
