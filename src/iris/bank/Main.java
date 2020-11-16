package iris.bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = Bank.create();
        bank.lookupOrCreate("Tyrion");
    }
}
