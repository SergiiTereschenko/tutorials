package com.baeldung.concurrent.semaphores;

import java.util.concurrent.Semaphore;

class LoginQueueUsingSemaphore {

    private final Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        boolean b = semaphore.tryAcquire();
        System.out.println("semaphore.tryAcquire() : " + b + " thr: " + Thread.currentThread().getName());
        availableSlots();
        return b;
    }

    void logout() {
        System.out.println("semaphore.release() " + " thr: " + Thread.currentThread().getName());
        semaphore.release();
    }

    int availableSlots() {
        int i = semaphore.availablePermits();
        System.out.println("AvailablePermits : " + i + " thr: " + Thread.currentThread().getName());
        return i;
    }

}
