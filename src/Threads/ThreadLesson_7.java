package Threads;/*
    @author Artiom Ponomariov
*/

import java.util.Scanner;

public class ThreadLesson_7 {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        System.out.println("State of thread1 is: " + thread1.getState());
        System.out.println("State of thread2 is: " + thread2.getState());
        thread2.start();
        System.out.println("State of thread1 is: " + thread1.getState());
        System.out.println("State of thread2 is: " + thread2.getState());

        thread1.join();
        System.out.println("State of thread1 is: " + thread1.getState());
        System.out.println("State of thread2 is: " + thread2.getState());
        thread2.join();
        System.out.println("State of thread1 is: " + thread1.getState());
        System.out.println("State of thread2 is: " + thread2.getState());

    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {

        synchronized (this){
            System.out.println("Producer thread started...");
            wait(); // 1 - отдаем intrinsic lock; 2 - ждем пока будет вызван notify()
            System.out.println("Producer thread resumed...");
        }

    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for return key pressed...");
            scanner.nextLine();
            notify();
        }
    }
}