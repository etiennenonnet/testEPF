/*
 * la classe partie
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Etienne Nonnet
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    
    
    public void attribuerCouleursAuxJoueurs(){
        String r = "rouge";
        String j = "jaune";
        Random generateurAleat = new Random();
        int x = generateurAleat.nextInt(1);
        if (x == 0){
            ListeJoueurs[0].affecterCouleur(r);
            for (int i=0; i<21; i++){
                Jeton J1 = new Jeton(r);
                ListeJoueurs[0].ajouterJeton(J1);
            }
            ListeJoueurs[1].affecterCouleur(j);
            for (int i=0; i<21; i++){
                Jeton J2 = new Jeton(j);
                ListeJoueurs[1].ajouterJeton(J2);
            }
            System.out.println("Le Joueur1 est rouge et le Joueur2 est jaune");
        }
        else if (x == 1){
            ListeJoueurs[0].affecterCouleur(j);
            for (int i=0; i<21; i++){
                Jeton J1 = new Jeton(j);
                ListeJoueurs[0].ajouterJeton(J1);
            }
            ListeJoueurs[1].affecterCouleur(r);
            for (int i=0; i<21; i++){  
                Jeton J2 = new Jeton(r);
                ListeJoueurs[1].ajouterJeton(J2);
            }
            System.out.println("Le Joueur1 est jaune et le Joueur2 est rouge");
        }
    }
    
    public Grille initialiserPartie(){
        Grille GrilleJeu = new Grille();
            GrilleJeu.viderGrille();
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
        initialiserPartie();
        
        String x;
        Scanner sc = new Scanner (System.in);
        System.out.println("Entrer le nom du premier joueur : ");
        x = sc.next();
        Joueur Joueur1 = new Joueur(x);
        ListeJoueurs[0] = Joueur1;
        //System.out.println("Le Joueur1 s'appelle : "+Joueur1.Nom+"\n");
        
        String y;
        Scanner sc2 = new Scanner (System.in);
        System.out.println("Entrer le nom du deuxieme joueur : ");
        y = sc2.next();
        Joueur Joueur2 = new Joueur(y);
        ListeJoueurs[1] = Joueur2;
        //System.out.println("Le Joueur2 s'appelle : "+Joueur2.Nom+"\n");
        attribuerCouleursAuxJoueurs();
        Grille GrilleJeu = new Grille();
        GrilleJeu.afficherGrilleSurConsole();
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
        
        System.out.println ("\n"+"Le joueur "+c+" commence: ");
        
        int g;
        Scanner sc3 = new Scanner (System.in);
        System.out.println("Dans quel colonne voulez-vous ajoutez un jeton ? ");
        g = sc3.nextInt()-1;
        
        Jeton premierJeton = new Jeton(c);
        
        GrilleJeu.ajouterJetonDansColonne(premierJeton, g);
        GrilleJeu.afficherGrilleSurConsole();
        while(GrilleJeu.etreGagnantePourJoueur(Joueur1)==false & GrilleJeu.etreGagnantePourJoueur(Joueur2)==false){//tant que personne ne gagne
            //si la premiere couleur a jouer etait le rouge la suivant sera le jaune et ainsi de suite
            if ("jaune".equals(c)){
                c="rouge";
            }else{
                c="jaune";
            }
            
            
            System.out.println("\n Dans quel colonne ajoutez vous votre jeton ? ");
            g = sc3.nextInt()-1;
            if (GrilleJeu.etreRemplie()==true){
                System.out.println("match nul serrez vous la main");
                break;
            }
            while (GrilleJeu.colonneRemplie(g)==true){
                System.out.println("cette colonne est pleine, ou voulez vous placer votre jeton ? ");
                g = sc3.nextInt()-1;
            }
            Jeton JetonCourant = new Jeton(c);

            GrilleJeu.ajouterJetonDansColonne(JetonCourant, g);
            GrilleJeu.afficherGrilleSurConsole();
            
            
        }
        if(GrilleJeu.etreGagnantePourJoueur(Joueur1)==true){
            System.out.println(Joueur1.Nom+" à gagné, bravo à tous !");
        }else{
            System.out.println(Joueur2.Nom+" à gagné, bravo à tous !");
        }
        
       
    }
    
    
}
