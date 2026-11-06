import org.example.example1.Currency;
import org.example.example1.InvalidMoney;
import org.example.example1.Money;

import java.util.HashSet;

public static void main(String[] args) {
    HashSet<InvalidMoney> hashSet = new HashSet<>();
    InvalidMoney invalidMoney = new InvalidMoney(100, Currency.RUB);
    InvalidMoney invalidMoney2 = new InvalidMoney(100, Currency.RUB);


    hashSet.add(invalidMoney);
    hashSet.add(invalidMoney2);

    System.out.println("Некорректный hashcode! Ожидалось 1");
    System.out.println("Количество элементов: " + hashSet.size() + "\n" + hashSet);
    System.out.println("Equals()== " + invalidMoney.equals(invalidMoney2));
    System.out.println("hashCode()== " + invalidMoney.hashCode());
    System.out.println("hashCode2()== " + invalidMoney2.hashCode());
    System.out.println();

    HashSet<Money> hashSet2 = new HashSet<>();
    Money money = new Money(100, Currency.RUB);
    Money money2 = new Money(100, Currency.RUB);

    hashSet2.add(money);
    hashSet2.add(money2);

    System.out.println("Корректный hashcode");
    System.out.println("Количество элементов: " + hashSet2.size() + "\n" + hashSet2);
    System.out.println("Equals()== " + money.equals(money2));
    System.out.println("hashCode()== " + money.hashCode());
    System.out.println("hashCode2()== " + money2.hashCode());


}