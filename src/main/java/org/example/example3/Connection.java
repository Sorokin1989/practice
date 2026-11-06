package org.example.example3;

public class Connection implements AutoCloseable {

    private final String name;

    public Connection(String name) {
        this.name = name;
        System.out.println("Creating connection " + name);
    }


    @Override
    public void close() {
        System.out.println("Closing connection " + name);
    }
}
