/*
 * la classe partie
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    
    public void attribuerCouleursAuxJoueurs(){
        double x = Math.random();
        if (x == 0){
            ListeJoueurs[0].affecterCouleur("rouge");
            for (int i=0; i<21; i++){
                Jeton J1 = new Jeton("rouge");
                ListeJoueurs[0].ajouterJeton(J1);
            }
            ListeJoueurs[1].affecterCouleur("jaune");
            for (int i=0; i<21; i++){
                Jeton J2 = new Jeton("jaune");
                ListeJoueurs[1].ajouterJeton(J2);
            }
        }
        else{
            ListeJoueurs[0].affecterCouleur("jaune");
            for (int i=0; i<21; i++){
                Jeton J1 = new Jeton("jaune");
                ListeJoueurs[0].ajouterJeton(J1);
            }
            ListeJoueurs[1].affecterCouleur("rouge");
            for (int i=0; i<21; i++){  
                Jeton J2 = new Jeton("rouge");
                ListeJoueurs[1].ajouterJeton(J2);
            }
        }
    }
    
    public void initialiserPartie(){
        Grille [] GrilleJeu = new Grille[1];
        if (GrilleJeu[0] != null){
            GrilleJeu[0] = null;
        }
        for (int i=0; i<5; i++){
            int n = (int)(Math.random() * 5);
            int m = (int)(Math.random() * 6);
            GrilleJeu[0].placerTrouNoir(n,m);  
        }
        for (int i=0; i<5; i++){
            int o = (int)(Math.random() * 5);
            int p = (int)(Math.random() * 6);
            GrilleJeu[0].placerDesintegrateur(o,p);
        }
        
        
    }
    
    public void debuterPartie(){
        
        
    }
    
    
}
