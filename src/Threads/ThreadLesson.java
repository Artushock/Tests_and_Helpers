package Threads;
/*

*/

public class ThreadLesson {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        MyThread1 myThread1_1 = new MyThread1();
        myThread1_1.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();

        Thread thread = new Thread(new Runner());
        thread.start();

        System.out.println("Hello from main thread");
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<1000; i++){
            System.out.println("Hello from Threads.MyThread1");
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<1000; i++){
            System.out.println("Hello from Threads.MyThread2");
        }
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<1000; i++){
            System.out.println("Hello from Threads.MyThread3");
        }
    }
}

class Runner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<1000; i++){
            System.out.println("Hello from Threads.Runner");
        }
    }
}