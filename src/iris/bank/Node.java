package iris.bank;

public class Node {
    Account etiquette;
    Node filsGauche;
    Node filsDroit;

    public Account lookupOrCreate(String pNom)
    {
        System.out.println(pNom);
        return null;
    }

    public static Node create() {
        Node node = new Node();

        node.etiquette = null;
        node.filsGauche = null;
        node.filsDroit = null;

        return node;
    }
}
