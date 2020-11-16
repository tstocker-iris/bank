package iris.bank;

public class Main {

    public static void main(String[] args) {
	    Account account = Account.create("Tyrion");
	    //Account.display(account);
        System.out.println(account.compareTo("Daenerys"));
        System.out.println(account.compareTo("Tyrion"));
        System.out.println(account.compareTo("Ygrid"));
    }
}
