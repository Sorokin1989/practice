package org.example.example3;

public class Session implements AutoCloseable {

    private final String name;

    public Session(String name) {
        this.name = name;
        System.out.println("Creating session " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing session " + name);

    }
}
