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
    
    
    public void attribuerCouleursAuxJoueurs(Joueur LeJoueur1, Joueur LeJoueur2){
        
        double n = Math.random();
        int x = (int)n;
        x = (int)(Math.random()*2);
        ListeJoueurs[0]=LeJoueur1;
        ListeJoueurs[1]=LeJoueur2;
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
    
    public Grille initialiserPartie(){
        Grille GrilleJeu = new Grille();
        if (GrilleJeu != null){
            GrilleJeu.viderGrille();
        }
        for (int i=0; i<5; i++){
            int n = (int)(Math.random() * 5);
            int m = (int)(Math.random() * 6);
            GrilleJeu.placerTrouNoir(n,m);  
        }
        for (int i=0; i<5; i++){
            int o = (int)(Math.random() * 5);
            int p = (int)(Math.random() * 6);
            GrilleJeu.placerDesintegrateur(o,p);
        }
        return GrilleJeu;
        
        
    }
    
    public void debuterPartie(){
        
        //preparation de la partie
        Partie P1 = new Partie();
        
        P1.attribuerCouleursAuxJoueurs();
        int o = (int)(Math.random());
        String c;
        if(o==0){
            c="rouge";
            
        }else{
            c ="jaune";//c la couleur tirée au hasard
        }
        if(ListeJoueurs[0].Couleur.equals(c)){
            joueurCourant=ListeJoueurs[0];
        }else{
            joueurCourant=ListeJoueurs[1];
        }
        Grille GrilleJeu= new Grille();
        GrilleJeu=P1.initialiserPartie();
        
    }
    
    
}
