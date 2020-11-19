package iris.bank;

public class Bank {
    Node root;

    public Account lookupOrCreate(String pNom)
    {
        if (this.root == null) {
            this.root = Node.create();
            this.root.etiquette = Account.create(pNom);
            this.root.filsGauche = Node.create();
            this.root.filsDroit = Node.create();
        }
        return root.lookupOrCreate(pNom);
    }

    public void display()
    {
        if (this.root != null) {
            this.root.display();
        }
    }

    public void displayWithPad()
    {
        if (this.root != null) {
            this.root.display(0);
        }
    }

    public static Bank create()
    {
        Bank bank = new Bank();

        bank.root = null;

        return bank;
    }
}
