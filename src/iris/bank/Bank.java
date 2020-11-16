package iris.bank;

public class Bank {
    Node root;

    public Account lookupOrCreate(String pNom)
    {
        return root.lookupOrCreate(pNom);
    }

    public static Bank create()
    {
        Bank bank = new Bank();

        bank.root = null;

        return bank;
    }
}
