package com.wkgao.solitaire.test;

import java.util.concurrent.*;

public class IOTest {

    /**
     * 同步异步
     * @param args
     */
    public static void main(String[] args) {
        /*new Thread() {
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    System.out.println("===================== func1 =====================");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("===================== func2 =====================");
            }
        }.start();*/
        /*String a = "hello2";
        String b = "hello" + 2;
        System.out.println((a == b));*/

        String a = "hello2";
        String b = "hello";
        String c = b + 2;
        System.out.println((a == c));

        final Integer[] result = new Integer[5];
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                result[0] = 1;
            }
        };
        Future<Integer[]> future = Executors.newSingleThreadExecutor().submit(runnable,result);
        try {
            Integer[] integers = future.get();
            System.out.println(integers[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "result";
            }
        };
        Future<String> future1 = Executors.newSingleThreadExecutor().submit(callable);
        String s = null;
        try {
            s = future1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }

}

