package com.druidwood;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // Create some items for the binary tree
        Random rand = new Random();

        BinaryTree binaryTree = new BinaryTree(new Payload(500));

         IntStream.range(0, 10)
            .forEach(index -> binaryTree.insert(new Payload(rand.nextInt(1000))));

//        binaryTree.insert(new Payload(300));
//        binaryTree.insert(new Payload(400));
//        binaryTree.insert(new Payload(350));
//        //binaryTree.insert(new Payload(650));
//        //binaryTree.insert(new Payload(675));
    }
}
