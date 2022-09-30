package me.benji.b1;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Looper());
        thread.start();
    }
}