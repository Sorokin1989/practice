package org.example.example2;


public class Main {
    public static void main(String[] args) {
        //проверка методов put,get,remove,getSize,getCapacity
        System.out.println("=====проверка методов=====");
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("apple", 1);
        myHashMap.put("orange", 2);
        myHashMap.put("pear", 3);
        myHashMap.put("banana", 4);
        myHashMap.put("kiwi", 5);
        myHashMap.put("cherry", 6);
        myHashMap.put("pineapple", 7);
        myHashMap.put("pine", 8);
        myHashMap.put("pinle", 9);
        myHashMap.put("pineape", 10);
        myHashMap.put("peapple", 11);
        myHashMap.put("peanut", 12);


        System.out.println(myHashMap.get("apple"));
        System.out.println(myHashMap.get("orange"));
        System.out.println(myHashMap.get("pear"));

        myHashMap.remove("apple");

        System.out.println(myHashMap.get("apple"));
        System.out.println(myHashMap.get("orange"));
        System.out.println(myHashMap.get("pear"));

        myHashMap.put("apple", 4);
        System.out.println(myHashMap.get("apple"));
        System.out.println(myHashMap.get("orange"));

        System.out.println("size " + myHashMap.getSize());

        System.out.println("capacity " + myHashMap.getCapacity());

        //пустая коллекция
        System.out.println("=======Пустая коллекция==========");
        MyHashMap<String, Integer> empty = new MyHashMap<>();

        System.out.println(empty.get("apple"));
        System.out.println(empty.remove("apple"));
        System.out.println("size " + empty.getSize());
        System.out.println("capacity " + empty.getCapacity());

        //один элемент

        System.out.println("======Один элемент===============");

        MyHashMap<String, Integer> oneElement = new MyHashMap<>();
        oneElement.put("apple", 1);

        System.out.println(oneElement.get("apple"));
        System.out.println("size " + oneElement.getSize());
        System.out.println("capacity " + oneElement.getCapacity());

        oneElement.remove("apple");
        System.out.println("size " + oneElement.getSize());
        System.out.println("capacity " + oneElement.getCapacity());

        //обновление значения по ключу

        MyHashMap<String, Integer> update = new MyHashMap<>();
        update.put("apple", 1);
        update.put("apple", 200);
        System.out.println("get(apple) " + update.get("apple"));
        System.out.println("Size " + update.getSize());

        //ресайз
        System.out.println("==========Ресайз=============");

        MyHashMap<String, Integer> resized = new MyHashMap<>();

        for (int i = 0; i < 13; i++) {
            resized.put(i + " apple", i);
        }

        System.out.println("Size " + resized.getSize());
        System.out.println("capacity " + resized.getCapacity());

        System.out.println("get(0 apple) " + resized.get(0 + " apple"));
        System.out.println("get(12 apple) " + resized.get(12 + " apple"));


        // ===== 5. Коллизии =====
        System.out.println("\n--- Коллизии (Aa / BB) ---");
        System.out.println("hashCode(Aa) = " + "Aa".hashCode());
        System.out.println("hashCode(BB) = " + "BB".hashCode());


        MyHashMap<String, Integer> col = new MyHashMap<>();

        col.put("Aa", 1);
        col.put("BB", 2);
        System.out.println("get(Aa) = " + col.get("Aa"));
        System.out.println("get(BB) = " + col.get("BB"));
        System.out.println("size = " + col.getSize());

        col.remove("Aa");
        System.out.println("после remove(Aa):");
        System.out.println("get(Aa) = " + col.get("Aa"));
        System.out.println("get(BB) = " + col.get("BB"));
        System.out.println("size = " + col.getSize());


    }
}