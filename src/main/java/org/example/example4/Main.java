package org.example.example4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File source = new File("test.bin");
        File target = new File("no_buffer.bin");
        File target2 = new File("buffer.bin");

        if (!source.exists()) {
            System.out.println("Создаем файл 100мб...");
            try (FileOutputStream fos = new FileOutputStream(source)) {
                byte[] block = new byte[1024 * 1024];
                for (int i = 0; i < 100; i++) {
                    fos.write(block);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            System.out.println("Файл создан!");

        }

        //без буфера

        try {
            long start = System.currentTimeMillis();
            FileCopier.copyNotWithBuffer(source, target);
            long end = System.currentTimeMillis();
            System.out.println("Без буффера: " + (end - start) + "мс");
            target.delete();

            long start2 = System.currentTimeMillis();
            FileCopier.copyWithBuffer(source, target2);
            long end2 = System.currentTimeMillis();
            System.out.println("С буфером: " + (end2 - start2) + "мс");
            target2.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Результаты замеров (файл 100 МБ):
        //
        //Без буфера: 1 238 670 мс (≈ 20 минут)
        //
        //С буфером: 4 831 мс (≈ 5 секунд)
        //
        //Разница: в 256 раз быстрее.
        //
        //При копировании без буфера программа делает 100 миллионов
        // системных вызовов к ОС (на каждый байт).
        // Каждый вызов — это переключение процессора в режим ядра,
        // что крайне медленно.
        //Буферизация (BufferedInputStream/OutputStream) считывает данные блоками по 8 КБ.
        // Количество обращений к ОС сокращается в 8192 раза (до ~12 000 вызовов).
        // Данные копируются в быстрой оперативной памяти, что дает колоссальный прирост скорости.


    }
}