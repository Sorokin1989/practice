package org.example.example1;

public class InvalidMoney {
    private int amount;
    private Currency currency;

    public InvalidMoney() {
    }

    public InvalidMoney(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvalidMoney that = (InvalidMoney) o;
        return amount == that.amount && currency == that.currency;
    }

    /**
     * БАГ: хеш зависит от identity объекта, а не от полей.
     * Для двух объектов с одинаковыми amount и currency equals() == true,
     * hashCode() разный → HashSet кладёт их в разные бакеты
     * не вызывает equals() → дубликат не отсекается.
     */
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "amount=" + amount + ", currency=" + currency;
    }
}
