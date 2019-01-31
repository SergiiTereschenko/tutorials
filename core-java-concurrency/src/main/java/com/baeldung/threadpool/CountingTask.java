package com.baeldung.threadpool;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountingTask extends RecursiveTask<Integer> {

    private final TreeNode node;

    CountingTask(TreeNode node) {
        this.node = node;
    }

    @Override
    protected Integer compute() {
        System.out.println("Node.val: " + node.getValue());
        int sum = 0;
        for (TreeNode childNode : node.getChildren()) {
            ForkJoinTask<Integer> fork = new CountingTask(childNode).fork();
            int join = fork.join();
            sum += join;
        }
        return node.getValue() + sum;
    }

}
