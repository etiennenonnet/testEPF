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
            int n=1;
            for (int i=0; i<21; i++){
                Jeton J2 = new Jeton(j);
                ListeJoueurs[1].ajouterJeton(J2);
                n+=1;
            }
            ListeJoueurs[1].nombreJetonsrestants =0;
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
            int a = ligne.nextInt(6);
            Random colonne = new Random();
            int b = colonne.nextInt(7);
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
            int a = ligne.nextInt(6);
            Random colonne = new Random();
            int b = colonne.nextInt(7);
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
        System.out.println("3) Placer un desintegrateur");
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
        
        
        Jeton premierJeton = new Jeton(c);
        
        int s=GrilleJeu.ajouterJetonDansColonne(premierJeton, g);
        if (GrilleJeu.Cellules[s][g].presenceTrouNoir() == true){//permet d'activer le trou noir lorsque l'on place un jeton dessus
                System.out.println ("Oh mince, votre jeton a disparu dans un trou noir!");
                GrilleJeu.Cellules[s][g].activerTrouNoir();
            }
        GrilleJeu.afficherGrilleSurConsole();
        
        
        while(GrilleJeu.etreGagnantePourJoueur(Joueur1)==false & GrilleJeu.etreGagnantePourJoueur(Joueur2)==false){//tant que personne ne gagne
            //si la premiere couleur a jouer etait le rouge la suivant sera le jaune et ainsi de suite
            String p;
            if ("jaune".equals(c)){//permet d'afficher le nom du joueur en fonction de la couleur qui doit jouer 
                c="rouge";//si la derniere couleur jouée etait le jaune la nouvelle couleur le rouge
                if(ListeJoueurs[0].Couleur.equals(c)){//si le premier joueur à des jeton rouge c'est à lui de jouer
                    p = Joueur1.Nom;
                    joueurCourant=ListeJoueurs[0];
                    
                }
                else{//sinon à l'autre
                    p = Joueur2.Nom;
                    joueurCourant=ListeJoueurs[1];
                }
            }
            else{
                c="jaune";
                if(ListeJoueurs[0].Couleur.equals(c)){
                    p = Joueur1.Nom;
                    joueurCourant=ListeJoueurs[0];
                }
                else{
                    p = Joueur2.Nom;
                    joueurCourant=ListeJoueurs[1];
                }
            }
            
            System.out.println("\n"+p+" a vous de jouer, que voulez-vous faire ?");
            
            String fini = "non";
            while (fini == "non"){
                int rep = choix();
                if (rep == 1){//veut ajouter un jeton
                    System.out.println("Dans quelle colonne ajoutez vous votre jeton "+c+" ?");
                    g = sc3.nextInt()-1;// g la colonne souhaité

                    Jeton JetonCourant = new Jeton(c);
                    int k=GrilleJeu.ajouterJetonDansColonne(JetonCourant, g);//met le jeton dans la cellule choisie par le joueur et nous indique la ligne du jeton
                    if (joueurCourant == Joueur1){
                        Joueur1.nombreJetonsrestants -= 1;
                    }
                    else{
                        Joueur2.nombreJetonsrestants -=1;
                    }

                    if (GrilleJeu.Cellules[k][g].presenceTrouNoir() == true){//permet d'activer le trou noir lorsque l'on place un jeton dessus
                        System.out.println ("Oh mince, votre jeton a disparu dans un trou noir!");
                        GrilleJeu.Cellules[k][g].activerTrouNoir();//fais disparaitre le jeton
                    }
                    //si il y a un desintegrateur sur la case le nbre de desintegrateur du joueur augment de 1
                    if (GrilleJeu.Cellules[k][g].presenceDesintegrateur()==true){
                        System.out.println("Felicitation ! Vous avez reçu un desintegrateur !");
                        if (joueurCourant==Joueur1){
                            GrilleJeu.Cellules[k][g].recupererDesintegrateur();
                           Joueur1.nombreDesintegrateurs+=1;
                           System.out.println(p+" vous avez : "+Joueur1.nombreDesintegrateurs+" desintegrateur");
                        }else{
                            GrilleJeu.Cellules[k][g].recupererDesintegrateur();
                            Joueur2.nombreDesintegrateurs+=1;
                            System.out.println(p+" vous avez : "+Joueur1.nombreDesintegrateurs+" desintegrateur");
                        }

                    }
                    fini = "oui";
                }
                if (rep == 2){//permet de recuperer un jeton deja place
                    int reponse = 0;
                    while (reponse == 0){
                        Scanner ligne = new Scanner(System.in);//on demande les coordonné du jeton a l'utilisateur
                        int a;
                        System.out.println("Quel jeton de couleur "+c+" voulez-vous recuperer?");
                        System.out.println("Veuillez indiquer la ligne correspondante :");
                        a = ligne.nextInt()-1;//ligne correspondnat au jeton a recuperer

                        Scanner colonne = new Scanner(System.in);
                        int b;
                        System.out.println("Veuiller indiquer la colonne correspondante :");
                        b = colonne.nextInt()-1;//colonne correspondant au jeton a recuperer
                        Jeton JetonRecupere = new Jeton(c);
                        JetonRecupere = GrilleJeu.Cellules[a][b].jetonCourant;
                        if(joueurCourant == Joueur1){
                                if (JetonRecupere.Couleur.equals(Joueur1.Couleur)){//si la couleur du jeton a recuperer est la meme que celle du joueur:
                                    GrilleJeu.recupererJeton(a, b);
                                    System.out.println("Vous venez de récuperer le jeton de coordonnées ["+a+", "+b+"]");
                                    reponse = 1;
                                    Joueur1.nombreJetonsrestants += 1;
                                    System.out.println(p+" tu recuperes :"+Joueur1.nombreJetonsrestants+" jetons");
                                    fini = "oui";
                                }
                                else{
                                    System.out.println("Ce jeton n'est pas a toi ! Choisis un jeton de ta couleur");
                                    reponse = 1;
                                }
                            }
                        if(joueurCourant == Joueur2){
                                if (JetonRecupere.Couleur.equals(Joueur2.Couleur)){//si la couleur du jeton a recuperer est la meme que celle du joueur:
                                    GrilleJeu.recupererJeton(a, b);
                                    System.out.println("Vous venez de récuperer le jeton de coordonnées ["+a+", "+b+"]");
                                    reponse = 1;
                                    Joueur2.nombreJetonsrestants += 1;
                                    System.out.println(p+" tu recuperes :"+Joueur2.nombreJetonsrestants+" jetons");
                                    fini = "oui";
                                }
                                else{
                                    System.out.println("Ce jeton n'est pas a toi ! Choisis un jeton de ta couleur");
                                    reponse = 1;
                                }
                        }

                    }
                }
                if (rep == 3){
                    if (joueurCourant.nombreDesintegrateurs>0){
                        Scanner ligne = new Scanner(System.in);
                        int a;
                        String v = "rouge";
                        if (c.equals(v)){
                            v="jaune";    
                        }
                        Jeton J = new Jeton(v);
                        System.out.println("Quel jeton de couleur "+v+" voulez-vous desintegrer?");
                        System.out.println("Veuillez indiquer la ligne correspondante :");
                        a = ligne.nextInt();//ligne correspondant au jeton a desintegrer

                        Scanner colonne = new Scanner(System.in);
                        int b;
                        System.out.println("Veuiller indiquer la colonne correspondante :");
                        b = colonne.nextInt();//colonne correspondant au jeton a desintegrer
                        if (J.Couleur.equals(GrilleJeu.lireCouleurDuJeton(a,b))){//si la couleur du jeton a desintegrer n'est pas la même que celle du joueur:
                            GrilleJeu.supprimerJeton(a,b);//supprime le jeton selectionne
                            System.out.println("Tu viens de desintegrer le jeton de l'adversaire !");
                            System.out.println("Tu ne peux pas desintegrer ton propre jeton!");
                        }
                        else{//si la couleur est la meme
                            System.out.println("Tu ne peux pas desintegrer ton propre jeton!");
                        }

                    }
                    else{
                        System.out.println("Vous n'avez pas de desintegrateur, faites un autre choix");
                        choix();
                    }
                }
            }
            if (GrilleJeu.etreRemplie()==true){//si la grille est remplie et qu'il n'y a pas de gagnant, match nul, fin de la partie
                System.out.println("match nul serrez vous la main");
            }
            while (GrilleJeu.colonneRemplie(g)==true){//si la colonne est deja rempli, on ne peut pas y mettre un jeton
                System.out.println("Cette colonne est pleine ! Ou voulez vous placer votre jeton ? ");
                g = sc3.nextInt()-1;
            }
            
             
            
            
            
            GrilleJeu.afficherGrilleSurConsole();
            
            
        }
        if(GrilleJeu.etreGagnantePourJoueur(Joueur1)==true){//si un joeur rempli les conditions pour gagner, fin de la partie
            System.out.println("\n"+Joueur1.Nom+" à gagné, bravo à tous !");
        }else{
            System.out.println("\n"+Joueur2.Nom+" à gagné, bravo à tous !");
        }
        
        
        
        
       
    }
    
    
}
