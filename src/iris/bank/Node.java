package iris.bank;

public class Node {
    Account etiquette;
    Node filsGauche;
    Node filsDroit;

    public Account lookupOrCreate(String pNom)
    {
        System.out.println(pNom);
        Account retour = null;
        if (this.etiquette != null) {
            if (this.etiquette.name.compareTo(pNom) == 0) {
                System.out.println("J'ai trouvé l'étiquette !");
                retour = this.etiquette;
            } else if (this.etiquette.compareTo(pNom) < 0) {
                System.out.println("Je vais à droite !");
                retour = this.filsDroit.lookupOrCreate(pNom);
            } else if (this.etiquette.compareTo(pNom) > 0) {
                System.out.println("Je vais à gauche !");
                retour = this.filsGauche.lookupOrCreate(pNom);
            }
        }

        if (retour == null) {
            System.out.println("Je n'ai rien trouvé donc je créé !");
            this.filsGauche = Node.create();
            this.filsDroit = Node.create();
            this.etiquette = Account.create(pNom);
            retour =  this.etiquette;
        }

        return retour;
    }

    public static Node create() {
        Node node = new Node();

        node.etiquette = null;
        node.filsGauche = null;
        node.filsDroit = null;

        return node;
    }
}
