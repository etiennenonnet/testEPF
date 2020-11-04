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
            ListeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
        }
    }
    
    public void initialiserPartie(){
        Grille [] GrilleJeu = new Grille[1];
        if (GrilleJeu[0] != null){
            GrilleJeu[0] = null;
        }
        int n = (int)(Math.random() * 42);
        for (int i=0; i<5; i++){
            if (Cellule.presenceTrouNoir() == false){
                
            }
        }
        
    }
    
    public void debuterPartie(){
        
        
    }
    
    
}
