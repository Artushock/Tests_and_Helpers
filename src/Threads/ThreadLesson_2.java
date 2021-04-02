package Threads;/*
    @author Artiom Ponomariov
*/

import java.util.Scanner;

public class ThreadLesson_2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }
}

class MyThread extends Thread{
    /*
    volatile - накладывает некоторые дополнительные условия на чтение/запись переменной.
    1. Операции чтения/записи volatile переменной являются атомарными.
    2. Результат операции записи значения в volatile переменную одним потоком, становится виден всем другим потокам, которые используют эту переменную для чтения из нее значения.
    3. Java-машина не будет помещать ее в кэш. Так что ситуация, когда 10 потоков работают со своими локальными копиями исключена.
    4. Она всегда будет атомарно читаться и записываться. Даже если это 64-битные double или long.
     */
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}