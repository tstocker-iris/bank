package iris.bank;

public class Account {
    String name;
    double balance;

    public static Account create(String pName)
    {
        Account account = new Account();
        double balance;

        balance = Math.random() * 100;
        balance = Math.floor(balance);

        account.name = pName;
        account.balance = balance;


        return account;
    }

    public void display()
    {
        System.out.println(this.name + " : " + this.balance + "€");
    }

    public int compareTo(String name)
    {
        return this.name.compareTo(name);
    }
}
