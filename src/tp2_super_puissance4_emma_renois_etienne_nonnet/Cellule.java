/*
 * la classe cellule
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule(){//la methode cellule
        trouNoir=false;
        desintegrateur=false;
        
    }
    public boolean affecterJeton(Jeton jeton_a_affecter){
        boolean reponse= false;
        if(jetonCourant == null){
            jetonCourant = jeton_a_affecter;
            reponse = true;
        }
        return reponse;
        
    }
    public Jeton recupererJeton(){
        
            
        return jetonCourant;
        
    }
    public boolean supprimerJeton (){
        boolean reponse= false;
        if(jetonCourant!=null){//si le la casse n'ai pas vide
            jetonCourant=null;//alors on supprime le jeton
            reponse=true;//alors la suppression va bien se passer
        }
        return reponse;//sinon la suppresion c'est pas effectué on renvoye donc faux
        
    }
    public boolean placerTrouNoir(){
        boolean reponse=false;
        if(trouNoir==false){
            trouNoir=true;
            
            reponse = true;
            
        }
        return reponse;
    }
    public boolean placerDesintegrateur(){
        boolean reponse=false;
        if(desintegrateur==false){
            desintegrateur=true;
            reponse=true;
            
        }
        return reponse;
    }
    public boolean presenceTrouNoir(){
        boolean reponse = false;
        
        if(trouNoir==true){
            reponse = true;
        }
        return reponse;
    }
    public boolean presenceDesintegrateur(){
        boolean reponse=false;
        if(desintegrateur==true){//si un desintegrateur et present sur la cellule
            reponse = true;
        }
        return reponse;
    }
    public String lireCouleurDuJeton(){
        String couleur="rouge";
        if(jetonCourant==null){
            return "vide?";
        }
        if ("jaune".equals(jetonCourant.lireCouleur())){
            couleur="jaune";
        }
        
    
        return couleur;
    }
    public boolean recupererDesintegrateur(){
        boolean reponse= false;
        if(desintegrateur==true){
            desintegrateur=false;
            reponse=true;
        }
        return reponse;
    }
    public boolean activerTrouNoir(){
        boolean reponse = false;
        if(trouNoir==true){
           jetonCourant=null; 
           reponse= true;
        }
        return reponse;
        
        
    }
}
