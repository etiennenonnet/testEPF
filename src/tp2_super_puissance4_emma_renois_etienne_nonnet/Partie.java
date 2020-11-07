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
        int x = generateurAleat.nextInt(2);
        if (x == 1){
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
        else{
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
    
    public static int choix(){
        // On demande à l'utilisateur de choisir entre recuperer un jeton ou jouer.
        int rep;
        Scanner sc = new Scanner (System.in);
        System.out.println("\n Saisissez le nombre correspondant a votre choix :");
        System.out.println("1) Jouer un jeton");
        System.out.println("2) Recuperer un jeton");
        rep = sc.nextInt();
        return rep;
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
        Random couleur = new Random();
        int o = couleur.nextInt(2);
        String c;
        if(o==1){
            c="rouge";
            
        }else{
            c ="jaune";//c la couleur tirée au hasard
        }
        if(ListeJoueurs[0].Couleur.equals(c)){
            joueurCourant=ListeJoueurs[0];
            System.out.println ("\n"+Joueur1.Nom+" commence avec la couleur "+c+" : ");
        }else{
            joueurCourant=ListeJoueurs[1];
            System.out.println ("\n"+Joueur2.Nom+" commence avec la couleur "+c+" : ");
        }
        
        
        int g;
        Scanner sc3 = new Scanner (System.in);
        System.out.println("Dans quel colonne voulez-vous ajoutez votre jeton ? ");
        g = sc3.nextInt()-1;
        
        Jeton premierJeton = new Jeton(c);
        
        GrilleJeu.ajouterJetonDansColonne(premierJeton, g);
        GrilleJeu.afficherGrilleSurConsole();
        while(GrilleJeu.etreGagnantePourJoueur(Joueur1)==false & GrilleJeu.etreGagnantePourJoueur(Joueur2)==false){//tant que personne ne gagne
            //si la premiere couleur a jouer etait le rouge la suivant sera le jaune et ainsi de suite
            String p;
            if ("jaune".equals(c)){
                c="rouge";
                if(ListeJoueurs[0].Couleur.equals(c)){
                    p = Joueur1.Nom;
                }
                else{
                    p = Joueur2.Nom;
                }
            }
            else{
                c="jaune";
                if(ListeJoueurs[0].Couleur.equals(c)){
                    p = Joueur1.Nom;
                }
                else{
                    p = Joueur2.Nom;
                }
            }
            
            System.out.println("\n"+p+" a vous de jouer, que voulez-vous faire ?");
            
            int rep = choix();
            if (rep == 1){
                System.out.println("\n"+p+" Dans quel colonne ajoutez vous votre jeton "+c+" ?");
                g = sc3.nextInt()-1;
            }
            if (rep == 2){
                Scanner ligne = new Scanner(System.in);
                int a;
                System.out.println("Quel jeton voulez-vous receperer?");
                System.out.println("Veuillez indiquer la ligne correspondante :");
                a = ligne.nextInt();
                
                Scanner colonne = new Scanner(System.in);
                int b;
                System.out.println("Veuiller indiquer la colonne correspondante :");
                b = colonne.nextInt();
                
                GrilleJeu.recupererJeton(a, b);
                
                System.out.println("Vous venez de récuperer le jetont de coordonnées ["+a+", "+b+"]");
            }
            if (GrilleJeu.etreRemplie()==true){
                System.out.println("match nul serrez vous la main");
            }
            while (GrilleJeu.colonneRemplie(g)==true){
                System.out.println("Cette colonne est pleine ! Ou voulez vous placer votre jeton ? ");
                g = sc3.nextInt()-1;
            }
            Jeton JetonCourant = new Jeton(c);

            GrilleJeu.ajouterJetonDansColonne(JetonCourant, g);
            GrilleJeu.afficherGrilleSurConsole();
            
            
        }
        if(GrilleJeu.etreGagnantePourJoueur(Joueur1)==true){
            System.out.println("\n"+Joueur1.Nom+" à gagné, bravo à tous !");
        }else{
            System.out.println("\n"+Joueur2.Nom+" à gagné, bravo à tous !");
        }
        
        
        
        
       
    }
    
    
}
