package iris.bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = Bank.create();
        bank.lookupOrCreate("Tyrion");
        bank.lookupOrCreate("Jaime");
        bank.lookupOrCreate("Cersei");
        bank.lookupOrCreate("Tywin");
        bank.lookupOrCreate("Kevan");
        bank.lookupOrCreate("Lancel");
        bank.lookupOrCreate("Alton");
        bank.lookupOrCreate("Martyn");
        bank.lookupOrCreate("Willem");
    }
}
