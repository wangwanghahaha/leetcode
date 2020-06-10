package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Concurrent {
    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call(){
            return 123;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable my=new MyCallable();
        FutureTask ft=new FutureTask(my);
        Thread t1=new Thread(ft);
        t1.start();
        System.out.println(ft.get());

    }
}
