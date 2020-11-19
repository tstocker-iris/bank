package iris.bank;

public class Node {
    Account etiquette;
    Node filsGauche;
    Node filsDroit;

    public Account lookupOrCreate(String pNom)
    {
        //System.out.println(pNom);
        Account retour = null;
        if (this.etiquette != null) {
            if (this.etiquette.name.compareTo(pNom) == 0) {
                //System.out.println("J'ai trouvé l'étiquette !");
                retour = this.etiquette;
            } else if (this.etiquette.compareTo(pNom) < 0) {
                //System.out.println("Je vais à droite !");
                retour = this.filsDroit.lookupOrCreate(pNom);
            } else if (this.etiquette.compareTo(pNom) > 0) {
                //System.out.println("Je vais à gauche !");
                retour = this.filsGauche.lookupOrCreate(pNom);
            }
        }

        if (retour == null) {
            //System.out.println("Je n'ai rien trouvé donc je créé !");
            this.filsGauche = Node.create();
            this.filsDroit = Node.create();
            this.etiquette = Account.create(pNom);
            retour =  this.etiquette;
        }

        return retour;
    }

    /**
     * @url https://developpement-informatique.com/article/173/parcours-d%E2%80%99un-arbre-binaire
     */
    public void display()
    {
        if (this.filsGauche != null) {
            this.filsGauche.display();
        }
        if (this.etiquette != null) {
            System.out.println(this.etiquette.name + " : " + this.etiquette.balance);
        }
        if (this.filsDroit != null) {
            this.filsDroit.display();
        }
    }

    public void display(int n)
    {
        if (this.filsGauche != null) {
            this.filsGauche.display(n + 1);
        }
        if (this.etiquette != null) {
            System.out.println(padLeft(" ", n) + this.etiquette.name + " : " + this.etiquette.balance);
        }
        if (this.filsDroit != null) {
            this.filsDroit.display(n + 1);
        }
    }

    public static String padLeft(String s, int n) {
        if (n > 0)
            return String.format("%" + n + "s", s);
        else
            return "";
    }

    public static Node create() {
        Node node = new Node();

        node.etiquette = null;
        node.filsGauche = null;
        node.filsDroit = null;

        return node;
    }
}
