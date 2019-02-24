
package ua.training.patterns.creational.singleton;

public class SingletonApp {

    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;

        Thread[] threads = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new R());
            threads[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            threads[i].join();
        }

        System.out.println(Singleton.counter);
    }

}

class R implements Runnable {
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    public static int counter = 0;
    private static volatile Singleton instance;

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

//    public static Singleton getInstance() {
//        return instance;
//    }

//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
}
