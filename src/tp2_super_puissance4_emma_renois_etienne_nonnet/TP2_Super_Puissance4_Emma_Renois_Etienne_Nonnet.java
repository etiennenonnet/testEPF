/*
 * TP2 super puissance 4
 *etienne Nonnet et Emma Renois
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

import java.util.Scanner;
/**
 *
 * @author Etienne Nonnet
 */
public class TP2_Super_Puissance4_Emma_Renois_Etienne_Nonnet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String x;
        Scanner sc = new Scanner (System.in);
        System.out.println("Entrer nom Joueur1 : ");
        x = sc.next();
        Joueur Joueur1 = new Joueur (x);
        System.out.println("Le Joueur1 s'appelle : "+Joueur1.Nom+"\n");
        
        String y;
        Scanner sc2 = new Scanner (System.in);
        System.out.println("Entrer nom Joueur2 : ");
        y = sc2.next();
        Joueur Joueur2 = new Joueur (y);
        System.out.println("Le Joueur2 s'appelle : "+Joueur2.Nom+"\n");
        
        // Main du code (relit toutes les classes entre elles)
        Jeton j1 = new Jeton("rouge");
        //System.out.println(j1.lireCouleur());
        Joueur joueur1 = new Joueur("Etienne");
        Cellule c1 = new Cellule();
        //System.out.println(c1.affecterJeton(j1));
        
        
        //System.out.println(c1.recupererJeton());
        //System.out.println(c1.placerTrouNoir());
        //System.out.println(c1.recupererDesintegrateur());
        //System.out.println(c1.presenceTrouNoir());
        //System.out.println(c1.activerTrouNoir());
        Grille g1 = new Grille();
        System.out.println(g1.ajouterJetonDansColonne(j1, 0));
        System.out.println(g1.etreRemplie());
        System.out.println(g1.lireCouleurDuJeton(5,0));
        joueur1.affecterCouleur("jaune");
        System.out.println(joueur1.Couleur);
        g1.afficherGrilleSurConsole();
        System.out.println(g1.etreGagnantePourJoueur(joueur1));

    }
    
}
