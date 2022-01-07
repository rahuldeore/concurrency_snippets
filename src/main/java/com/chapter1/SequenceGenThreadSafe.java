package com.chapter1;

import com.rahul.annotations.NotThreadSafe;

/**
 * Created by Rahul Deore on 1/1/22
 *
 * This non threadsafe method getNext() can be made thread safe by adding synchronized keyword
 */
//@ThreadSafe
public class SequenceGenThreadSafe {

    static int val=0;
    public synchronized static int getNext() {
        return val++;
    }
    public synchronized static int getVal() {
        return val;
    }
    public static void main(String... args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    System.out.println(getNext());
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    System.out.println(getNext());
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    System.out.println(getNext());
                }
            }
        });
        t3.start();

        System.out.println("The val: " + getVal());
    }

}
