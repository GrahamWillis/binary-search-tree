package com.druidwood;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // Create some items for the binary tree
        Random rand = new Random();

        BinaryTree<Payload> binaryTree = new <Payload>BinaryTree();

         IntStream.range(0, 50)
            .forEach(index -> binaryTree.insert(new Payload(rand.nextInt(1000))));

        binaryTree.scanAscend();
    }
}
