package com.druidwood;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.*;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public static class Node<T> {
        T payload;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T payload, Node<T> left, Node<T> right, Node<T> parent) {
            this.payload = payload;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * insert a new Node into the tree
     *
     * @param payload
     * @return Added node
     */
    protected Node<T> insert(T payload) {
        return insert(payload, this.root, 0);
    }

    protected Node<T> insert(T payload, Node<T> current, int depth) {
        // Add at level 0 (root)
        if (current == null) {
            this.root = new Node<>(payload, null, null, null);
            return this.root;
        }

        if (payload.compareTo(current.payload) < 0) {
            if (current.left == null) {
                // Add to the left
                current.left = new Node<>(payload, null, null, current);
                return current.left;
            } else {
                // Traverse left
                return insert(payload, current.left, ++depth);
            }
        } else {
            // Add to the right
            if (current.right == null) {
                current.right = new Node<>(payload, null, null, current);
                return current.left;
            } else {
                // Traverse right
                return insert(payload, current.right, ++depth);
            }
        }
    }

    protected Node<T> scanAscend() {
        Set<Node<T>> visited = new HashSet<>();
        return scanAscend(this.root, visited);
    }

    protected Node<T> scanAscend (Node<T> current, Set<Node<T>> visited) {
        if (current == null) {
            return null;
        }

        if (current.left != null && !visited.contains(current.left)) {
            return scanAscend(current.left, visited);
        }

        if (current.right != null && !visited.contains(current.right)) {
            out.println(current.payload);
            visited.add(current);
            return scanAscend(current.right, visited);
        }

        if (!visited.contains(current)) {
            out.println(current.payload);
            visited.add(current);
        }

        return scanAscend(current.parent, visited);
    }
}
