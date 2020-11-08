/*
 * la classe partie
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

import java.util.Random;// permet de renvoyer un nombre aleatoirement
import java.util.Scanner;// permet de demander a l'utilisaeur

/**
 *
 * @author Etienne Nonnet
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[2]; // represente les deux joueurs
    Joueur joueurCourant;// represente le joueur en train de jouer 
    Grille GrilleJeu = new Grille();//represente la grille de jeu
    
    public void attribuerCouleursAuxJoueurs(){
        String r = "rouge";
        String j = "jaune";
        Random generateurAleat = new Random();
        int x = generateurAleat.nextInt(2);//prend un nombre aléatoire entre 1 et 2
        if (x == 1){
            ListeJoueurs[0].affecterCouleur(r);//affecte la couleur rouge au Joueur 1
            for (int i=0; i<21; i++){//crée 21 jetons de la couleur du joueur
                Jeton J1 = new Jeton(r);
                ListeJoueurs[0].ajouterJeton(J1);//donne les jetons au joueur
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
        GrilleJeu.viderGrille();//permet de vider la grille de jeu
        int m = 0;
        while (m<5){
            Random ligne = new Random();
            int a = ligne.nextInt(5);
            Random colonne = new Random();
            int b = colonne.nextInt(6);
            if (GrilleJeu.Cellules[a][b].presenceTrouNoir() == false){//s'il n'y a pas de trou noir, en place un
                GrilleJeu.placerTrouNoir(a ,b);//place 5 trous noirs aleatoirement sur la gille
                if (m>2){
                    if (GrilleJeu.Cellules[a][b].presenceDesintegrateur() == false){//s'il n'y a pas de desintegrateur, en place un 
                        GrilleJeu.placerDesintegrateur(a ,b);//place 2 desintegrateurs derriere les trous noirs (insvisible)
                    }
                }
                m++;//incrémente lorsque les trous noirs sont bien places a des endroits differents
            }
        }
        int q = 0;
        while (q<3){
            Random ligne = new Random();
            int a = ligne.nextInt(5);
            Random colonne = new Random();
            int b = colonne.nextInt(6);
            if (GrilleJeu.Cellules[a][b].presenceDesintegrateur() == false){//s'il n'y a pas de desintegrateur, en place un 
                        GrilleJeu.placerDesintegrateur(a ,b);//place les 3 autres desintegrateurs sur la grille (visible)
                        q++;//incrémente lorsque les desintegrateurs sont bien places a des endroits differents
                    }
        }
        return GrilleJeu;  
    }
    
    public static int choix(){
        // On demande à l'utilisateur de choisir entre recuperer un jeton ou jouer.
        int rep;
        Scanner sc = new Scanner (System.in);//demande a l'utilisateur de faire un choix
        System.out.println("Saisissez le nombre correspondant a votre choix :");
        System.out.println("1) Jouer un jeton");
        System.out.println("2) Recuperer un jeton");
        rep = sc.nextInt();
        return rep;//retourne le choix de l'utilisateur
    }
    
    public void debuterPartie(){
        
        //preparation de la partie
        initialiserPartie();
        
        String x;
        Scanner sc = new Scanner (System.in);
        System.out.println("Entrer le nom du premier joueur : ");
        x = sc.next();
        Joueur Joueur1 = new Joueur(x);// attribut le nom du joueur au Joueur1
        ListeJoueurs[0] = Joueur1;//ListeJoueurs[0] est represente par le Joueur1
        //System.out.println("Le Joueur1 s'appelle : "+Joueur1.Nom+"\n");
        
        String y;
        Scanner sc2 = new Scanner (System.in);
        System.out.println("Entrer le nom du deuxieme joueur : ");
        y = sc2.next();
        Joueur Joueur2 = new Joueur(y);
        ListeJoueurs[1] = Joueur2;
        //System.out.println("Le Joueur2 s'appelle : "+Joueur2.Nom+"\n");
        attribuerCouleursAuxJoueurs();
        
        GrilleJeu.afficherGrilleSurConsole();// permet d'affciher la grille
        Random couleur = new Random();//permet de choisir une couleur au hasard pour decider de qui commence
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
        System.out.println("Dans quelle colonne voulez-vous ajoutez votre jeton ? ");
        g = sc3.nextInt()-1;
        
        int i = 0;
            int z = 0;
            while (GrilleJeu.celluleOccupee(i, g)==true){//ca je vais le changer je commente pas 
                z = i;
                i++;
            }
            if (GrilleJeu.Cellules[z][g].presenceTrouNoir() == true){//permet d'activer le trou noir lorsque l'on place un jeton dessus
                System.out.println ("Oh mince, votre jeton a disparu dans un trou noir!");
                GrilleJeu.Cellules[z][g].activerTrouNoir();
            }
        
        Jeton premierJeton = new Jeton(c);
        
        GrilleJeu.ajouterJetonDansColonne(premierJeton, g);
        GrilleJeu.afficherGrilleSurConsole();
        
        
        while(GrilleJeu.etreGagnantePourJoueur(Joueur1)==false & GrilleJeu.etreGagnantePourJoueur(Joueur2)==false){//tant que personne ne gagne
            //si la premiere couleur a jouer etait le rouge la suivant sera le jaune et ainsi de suite
            String p;
            if ("jaune".equals(c)){//permet d'afficher le nom du joueur en fonction de la couleur qui doit jouer 
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
                System.out.println("\n"+p+" dans quelle colonne ajoutez vous votre jeton "+c+" ?");
                g = sc3.nextInt()-1;
                
                int j = 0;
                int h = 0;
                while (GrilleJeu.celluleOccupee(j, g)==true){// je vais changer aussi
                    h = j;
                    j++;
                }
                if (GrilleJeu.Cellules[h][g].presenceTrouNoir() == true){
                    System.out.println ("Oh mince, votre jeton a disparu dans un trou noir!");
                    GrilleJeu.Cellules[h][g].activerTrouNoir();
                }
            }
            if (rep == 2){
                int reponse = 0;
                while (reponse == 0){
                    Scanner ligne = new Scanner(System.in);
                    int a;
                    System.out.println("Quel jeton voulez-vous recuperer?");
                    System.out.println("Veuillez indiquer la ligne correspondante :");
                    a = ligne.nextInt();
                
                    Scanner colonne = new Scanner(System.in);
                    int b;
                    System.out.println("Veuiller indiquer la colonne correspondante :");
                    b = colonne.nextInt();
                
                    if (GrilleJeu.recupererJeton(a, b) != null){
                        System.out.println("Vous venez de récuperer le jetont de coordonnées ["+a+", "+b+"]");
                        reponse = 1;
                    }
                    
                }
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
