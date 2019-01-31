package com.baeldung.concurrent.semaphores;

import java.util.concurrent.Semaphore;

class CounterUsingMutex {

    private final Semaphore mutex;
    private int count;

    CounterUsingMutex() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increase() throws InterruptedException {
        System.out.println("PRE mutex.acquire(); thread: " + Thread.currentThread().getName());
        mutex.acquire();
        System.out.println("mutex.acquire(); thread: " + Thread.currentThread().getName());
        this.count = this.count + 1;
        Thread.sleep(1000);
        mutex.release();
        System.out.println("RELEASE mutex.acquire() AND sleep; thread: " + Thread.currentThread().getName());

    }

    int getCount() {
        return this.count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }

}
