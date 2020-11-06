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
        //System.out.println("Le Joueur1 s'appelle : "+Joueur1.Nom+"\n");
        
        String y;
        Scanner sc2 = new Scanner (System.in);
        System.out.println("Entrer nom Joueur2 : ");
        y = sc2.next();
        Joueur Joueur2 = new Joueur (y);
        //System.out.println("Le Joueur2 s'appelle : "+Joueur2.Nom+"\n");
        
        Partie P1 = new Partie();
        P1.initialiserPartie().afficherGrilleSurConsole();
        Grille GrilleDeJeu = new Grille();
        GrilleDeJeu=P1.initialiserPartie();
        P1.attribuerCouleursAuxJoueurs(Joueur1, Joueur2);
        System.out.println("\n"+"la couleur de "+Joueur1.Nom+" est: "+Joueur1.Couleur);
        System.out.println("la couleur de "+Joueur2.Nom +" est: "+Joueur2.Couleur);
        //on tire une couleur au hasard pour savoir qui commance:
        double n = Math.random();
        int a = (int)n;
        a = (int)(Math.random()*2);
        String couleurTire;
        if(a==0){
            couleurTire="rouge";
            
        }else{
            couleurTire="jaune";
        }
        System.out.println(couleurTire);
        
        if(couleurTire==Joueur1.Couleur){//si la couleur tire est celle du joueur 1
            
            System.out.println("le premier joueur a jouer sera "+Joueur1.Nom);//il joura en premier
        }else{
            System.out.println("le premier joueur a jouer sera "+Joueur2.Nom);//sinon c'est le joueur 2 qui commence
        }
        //la partie commence
        int g;
        Scanner sc3 = new Scanner (System.in);
        System.out.println("Dans quel colonne voulez-vous ajoutez un jeton ? ");
        g = sc3.nextInt()-1;
        
        Jeton premierJeton = new Jeton(couleurTire);
        
        GrilleDeJeu.ajouterJetonDansColonne(premierJeton, g);
        GrilleDeJeu.afficherGrilleSurConsole();
        while(GrilleDeJeu.etreGagnantePourJoueur(Joueur1)==false & GrilleDeJeu.etreGagnantePourJoueur(Joueur2)==false){//tant que personne ne gagne
            //si la premiere couleur a jouer etait le rouge la suivant sera le jaune et ainsi de suite
            if (couleurTire=="jaune"){
                couleurTire="rouge";
            }else{
                couleurTire="jaune";
            }
            
            
            System.out.println("\n Dans quel colonne ajoutez vous votre jeton ? ");
            g = sc3.nextInt()-1;
            Jeton JetonCourant = new Jeton(couleurTire);

            GrilleDeJeu.ajouterJetonDansColonne(JetonCourant, g);
            GrilleDeJeu.afficherGrilleSurConsole();
            
        }
        // Main du code (relit toutes les classes entre elles)
        //Jeton j1 = new Jeton("rouge");
        //System.out.println(j1.lireCouleur());
        //Joueur joueur1 = new Joueur("Etienne");
        //Cellule c1 = new Cellule();
        //System.out.println(c1.affecterJeton(j1));
        
        
        //System.out.println(c1.recupererJeton());
        //System.out.println(c1.placerTrouNoir());
        //System.out.println(c1.recupererDesintegrateur());
        //System.out.println(c1.presenceTrouNoir());
        //System.out.println(c1.activerTrouNoir());
        //Grille g1 = new Grille();
        //System.out.println(g1.ajouterJetonDansColonne(j1, 0));
        //System.out.println(g1.etreRemplie());
        //System.out.println(g1.lireCouleurDuJeton(5,0));
        //joueur1.affecterCouleur("jaune");
        //System.out.println(joueur1.Couleur);
        //g1.afficherGrilleSurConsole();
        //System.out.println(g1.etreGagnantePourJoueur(joueur1));

    }
    
}
