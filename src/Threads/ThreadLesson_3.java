package Threads;/*
    @author Artiom Ponomariov
*/

public class ThreadLesson_3 {
    private  int counter;

    public static void main(String[] args) throws InterruptedException {
        ThreadLesson_3 threadLesson_3 = new ThreadLesson_3();
        threadLesson_3.doWork();
    }

    /*
    Ключевое слово synchronized применяется только к методам.
    Метод помеченный как synchronized может выполняться только одним потоком

     */

    private synchronized void increment(){
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++){
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
