package org.example.example4;

import java.io.*;

public class FileCopier {

    // без буфера
    public static void copyNotWithBuffer(File source, File target) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(target)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }


    }

    // с буфером
    public static void copyWithBuffer(File source, File target) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target))) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }
}