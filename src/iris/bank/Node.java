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

    public Node successor()
    {
        Node courant = this;
        while (courant.filsGauche != null && courant.filsGauche.etiquette != null) {
            courant = courant.filsGauche;
        }
        return courant;
    }

    public Node delete(String pNom) {
        if (this.etiquette != null) {
            // Parcours horizontal de l'arbre pour trouver le noeud a supprimer
            if (this.etiquette.compareTo(pNom) < 0) {
                this.filsDroit = this.filsDroit.delete(pNom);
            } else if (this.etiquette.compareTo(pNom) > 0) {
                this.filsGauche = this.filsGauche.delete(pNom);
            } else {
                // On a trouvé le noeud à supprimer
                // On vérifie s'il n'a pas de fils gauche et un fils droit
                if (this.filsGauche == null && this.filsDroit != null) {
                    // On retourne le fils droit
                    return this.filsDroit;
                // On vérifie s'il n'a pas de fils droit et un fils gauche
                } else if (this.filsDroit == null && this.filsGauche != null) {
                    // On retourne le fils gauche
                    return this.filsGauche;
                }

                // Sinon c'est qu'il a deux fils, on part sur le fils droit (mais on pourrait partir sur le gauche)
                // On cherche le successeur au fils droit
                Node successor = this.filsDroit.successor();
                // S'il n'est pas vide
                if (successor.etiquette != null && successor.etiquette.name != this.etiquette.name) {
                    // On affecte le successeur au noeud courant (donc son etiquette et ses fils droit)
                    this.etiquette = successor.etiquette;
                    this.filsDroit = this.filsDroit.delete(successor.etiquette.name);
                } else {
                    // Sinon c'est qu'il n'a pas de fils, on supprime juste sa valeur
                    this.etiquette = null;
                }
            }
        }
        return this;
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
