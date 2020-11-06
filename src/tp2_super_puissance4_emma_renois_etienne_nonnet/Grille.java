/*
 * la classe grille
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Grille {
    Cellule [][] Cellules = new Cellule [6][7];
    public Grille(){
        for(int i=0; i<6;i++){
            for (int j=0; j<7;j++){
                Cellules[i][j]=new Cellule();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton jeton_a_ajouter, int une_colonne){
        boolean reponse=false;//si le module ne renvoit rien c'est qu'il n'a pas marché
        int a;
        for(int i=0; i<=5;i++){
            a=5-i;//on demarre de la cellule la plus basse de la colonne
            //Cellule c = Cellules[i][une_colonne];
            if (Cellules[a][une_colonne].jetonCourant==null){//si la cellule contient le jeton nul
                Cellules[a][une_colonne].jetonCourant=jeton_a_ajouter;//alors le jeton à ajouté ce met dans cette cellule
                reponse = true;//laors le programme a correctement fonctionné
                break;//on arret la boucle pour ce la remplissage s'arret apres l'ajoute d'un jeton
            }
        }
        return reponse;//on retourne si le jeton à etait correctement ajouté
        
    }
    public boolean etreRemplie(){
        boolean reponse=false;// initialisation à grille pas remplit
        int a=0;
        for(int i=0; i<6; i++){//on parcourt le tableau en long et en large
            for(int j=0; j<7;j++){
                if (Cellules[i][j].jetonCourant==null){//si une cellule n'a "pas" de jeton
                    a+=1; //alors a devient different de 0
                }
            }
        }
        if (a==0){//si est egal à 0 alors le tableau est remplit
            reponse=true;//le tableau est remplit
        }
        return reponse;
    }
    public void viderGrille(){
        for(int i=0; i<6; i++){//on parcourt le tableau en long et en large
            for(int j=0; j<7;j++){
                Cellules[i][j].jetonCourant=null;
            }
            
        }
    }
    // bosser dessus
    public void afficherGrilleSurConsole(){// afficher le tableau
        for (int i=0; i<6;i++){
            System.out.print("\n");
        
            for(int j=0; j<7;j++){
                
            
                if(Cellules[i][j].trouNoir){
                    System.out.print("\u001B[0m T ");
                }else if (Cellules[i][j].desintegrateur){
                   System.out.print("\u001B[0m D ");

                }else if (Cellules[i][j].jetonCourant == null){
                    System.out.print("\u001B[0m N ");
                }else{
                    if (Cellules[i][j].jetonCourant.lireCouleur()=="rouge"){
                
                        System.out.print("\u001B[0m R ");
                    }else{
                        System.out.print("\u001B[0m J ");
                    }
                }
                
            }
            
        }
        
    }
    public boolean celluleOccupee(int ligne_donnée ,int colonne_donnée){
        boolean reponse= false;
        if(Cellules[ligne_donnée][colonne_donnée].jetonCourant!=null){//si la cellule n'est pas vide (occupé)
            reponse= true;//la cellule est occupé
        }
        return reponse;
    }
    public String lireCouleurDuJeton(int ligne_donnée, int colonne_donnée){//premiere ligne premiere colonne =[0][0]
        
        String CouleurDuJeton=Cellules[ligne_donnée][colonne_donnée].jetonCourant.lireCouleur();//lit la couleur du jeton de la cellule des coordonnés donnés
        return CouleurDuJeton;//renvoit la couleur du jeton
    }
    
    public boolean etreGagnantePourJoueur(Joueur JoueurChoisit){
        boolean reponse= false;
        String CouleurDuJoueur= JoueurChoisit.Couleur;//la couleur associé au joueur
        //si 4 jeton aligné sur une ligne
        for(int i= 0; i<6; i++){
            int a=0;//a chaque nouvelle ligne le compte reviens à zero
            for(int j=0; j<7; j++){
                if (Cellules[i][j].lireCouleurDuJeton().equals(CouleurDuJoueur)){//si c est la couleur du joueur
                    a+=1;
                       
                }else{//sinon a revient à zero car ca doit etre consecutif
                    a=0;
                }
                if (a==4){//si il y a quatre jeton aligné sur une ligne
                    reponse=true;
                    return reponse;// est ce que ca n'arrete pas le programme ?
                    
                }
            }
        }
        //si 4 jeton allignés sur une colonne
        for(int j=0 ; j<7; j++){
            int a=0;
            for(int i=0; i<6; i++){
                if (Cellules[i][j].lireCouleurDuJeton().equals(CouleurDuJoueur)){
                    a+=1;
                       
                }else{
                    a=0;
                }
                if (a==4){
                    reponse=true;
                    return reponse;
                    

                }
            }
            
        }
       
        //diagonal y=-x
        for (int i=0; i<7; i++){//on parcourt la premiere ligne du tableau (i la colonne)
            int a=0;
            for (int k=0; k<6; k++){// on a deja (k<6)
                if ((k+i)<7){//test si la cellule est dans le tableau
                    if (Cellules[0+k][i+k].lireCouleurDuJeton().equals(CouleurDuJoueur)){//si c'est la couleur du joueur
                        a+=1;
                    }else{
                        a=0;
                    }
                    if (a==4){
                        reponse=true;
                        return reponse;
                        
                    }
                }
                
            }
        }
        //diagonal y=-x sur le triangle inferieur
        for (int i=0; i<6; i++){//on parcourt la premiere colonne du tabeau (i le numéro de la ligne)
            int a=0;
            for (int k=0; k<7; k++){
                if ((i+k)<6){// rappel: commence à zero
                    if (Cellules[i+k][0+k].lireCouleurDuJeton().equals(CouleurDuJoueur)){//si c'est la couleur du joueur
                        a+=1;
                    }else{
                        a=0;
                    }
                    if (a==4){
                        reponse=true;
                        return reponse;
                    }
                }
            }
        }
        //y=x
        for(int i=6; i>=0;i--){//on parcourt la premiere ligne de droite à gauche
            
            int a=0;
            for (int k=0; k<6; k++){//k inférieur on nombre de ligne
                if((i-k)<7 & (i-k)>=0){
                    if (Cellules[k][i-k].lireCouleurDuJeton().equals(CouleurDuJoueur)){
                        a+=1;

                    }else{
                        a=0;
                       
                    }
                    if (a==4){
                        reponse=true;
                        return reponse;
                    }
                }   
            }
        }
        for(int i=0; i<6;i++){//on parcourt la derniere colonne de haut en bas
            //i parcourt les lignes de la derniere colonne
            int a=0;
            for (int k=0; k<6; k++){
                if((i+k)<6 & (i+k)>=0){
                    if (Cellules[i+k][6-k].lireCouleurDuJeton().equals(CouleurDuJoueur)){//commence à la derniere colonne colonne=6
                        a+=1;

                    }else{
                        a=0;
                       
                    }
                    if (a==4){
                        reponse=true;
                        return reponse;
                    }
                }   
            }
        }
        return reponse;
    }
    
    public void tasserGrille(){
        for (int i=5; i>0; i--){
            for (int j=6; i>0; i--){
                if (celluleOccupee(i,j)==true){//regarde si la cellule contient un jeton. Si oui, regarde si la cellule d'en dessous contient également un jeton
                    if (celluleOccupee(i,(j-1))==false){// si non :
                        Jeton jeton_a_deplacer = Cellules[i][j].recupererJeton();// prend le jeton de la cellule
                        Cellules[i][j].supprimerJeton();// vide la cellule
                        Cellules[i][j-1].jetonCourant=jeton_a_deplacer;// place le jeton dans la cellule d'en dessous
                    }
                }
                
            }
            
            
        }
    }
    public boolean colonneRemplie(int colonne_vise){
        boolean reponse= false;
        int a=0;
        for (int i=0; i<6;i++){//on parcourt une colonne
            if(Cellules[i][colonne_vise].lireCouleurDuJeton().equals("rouge")|Cellules[i][colonne_vise].lireCouleurDuJeton().equals("jaune")){//si les cellules sont toute rouge ou jaunes
                a+=1;
            }
        }
        if (a==6){//si toute la colonne est remplit
            reponse= true;
        }
        return reponse;
    }
    public boolean placerTrouNoir(int ligne, int colonne){
        boolean reponse=false;
        if (Cellules[ligne][colonne].trouNoir==false){
            Cellules[ligne][colonne].trouNoir=true;
            reponse=true;
        }
        return reponse;
    } 
    
    public boolean placerDesintegrateur(int ligne, int colonne){
        boolean reponse=false;
        if (Cellules[ligne][colonne].desintegrateur==false){
            Cellules[ligne][colonne].desintegrateur=true;
            reponse=true;
        }
        return reponse;
    }
    
    public boolean supprimerJeton(int ligne, int colonne){
        boolean reponse=false;
        if (celluleOccupee(ligne,colonne)==true){
            Cellules[ligne][colonne]=null;
            reponse=true;
        }
        return reponse;
    }
    public Jeton recupererJeton(int ligne, int colonne){
        Jeton a =Cellules[ligne][colonne].jetonCourant;
        Cellules[ligne][colonne].supprimerJeton();
        return a;
    }
}
