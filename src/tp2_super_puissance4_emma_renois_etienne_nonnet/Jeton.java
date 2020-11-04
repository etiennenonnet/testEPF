/*
 * la classe des jetons
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Jeton {
    String Couleur;
    
    public Jeton(String uneCouleur){
        Couleur=uneCouleur;
    }
    public String lireCouleur(){
        return Couleur;
    }
}
