package org.example.example3;

public class FailingResourse implements AutoCloseable {

    private final String name;

    public FailingResourse(String name) {
        this.name = name;
        System.out.println("Creating FailingResours " + name);
    }

    @Override
    public void close() {
        System.out.println("Failing closed " + name);
        throw new RuntimeException("FailingResourse closed " + name);

    }
}
