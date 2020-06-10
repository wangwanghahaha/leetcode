package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {
    private static final Lock lock=new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(()->test(),"ThreadA").start();
        new Thread(()->test(),"ThreadB").start();
        new Thread(()->test(),"ThreadC").start();
        new Thread(()->test(),"ThreadD").start();
        new Thread(()->test(),"ThreadE").start();
    }
    public static void test() {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得了锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("释放了");
                lock.unlock();
            }
        }
    }
}

