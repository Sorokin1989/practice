package org.example.example1;

import java.util.Objects;

public class Money {

    private double amount;
    private Currency currency;

    public Money() {

    }

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(amount, money.amount) == 0 && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "amount=" + amount +
                ", currency=" + currency;
    }
}
