package org.example.example3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====Порядок закрытия ресурсов=====");
        try (
                Connection connection = new Connection("A");
                Session session = new Session("B");
        ) {
            System.out.println("Тело try");
        }


        System.out.println();
        System.out.println("=== 2. Suppressed exception ===");

        try (FailingResourse failingResourse = new FailingResourse("C")) {
            throw new RuntimeException("Ошибка внутри try (основная ошибка)");
        } catch (RuntimeException e) {
            System.out.println("Основное исключение: " + e.getMessage());


            Throwable[] suppressed = e.getSuppressed();
            System.out.println("Количество suppressed исключений: " + suppressed.length);

            for (Throwable throwable : suppressed) {
                System.out.println("Suppressed: " + throwable.getMessage());
            }
        }

//Suppressed exception — это исключение, которое возникает во время закрытия ресурса
// (в методе close()), когда в основном блоке try уже произошла ошибка.
//Если бы мы использовали обычный try-finally, исключение из close() «затерло» бы
// основную ошибку, и мы бы не узнали, что на самом деле сломалось в try.
//Блок try-with-resources решает эту проблему: исключение из тела try становится основным,
// а исключение из close() прикрепляется к нему как подавленное (suppressed).
// Достать подавленные ошибки можно через метод e.getSuppressed(), который возвращает массив
// Throwable[].


    }
}