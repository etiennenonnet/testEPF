/*
 * la classe joueur
 */
package tp2_super_puissance4_emma_renois_etienne_nonnet;

/**
 *
 * @author Etienne Nonnet
 */
public class Joueur {
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreDesintegrateurs;
    int nombreJetonsrestants;
    
    public Joueur(String unNom){
        Nom = unNom;
        nombreDesintegrateurs = 0;
        nombreJetonsrestants = 21;
        
    }
    
    public void affecterCouleur (String uneCouleur){
        Couleur = uneCouleur;
    }
    
    public boolean ajouterJeton(Jeton Jeton_a_ajouter){
        boolean Reponse = false;
        if (nombreJetonsrestants < 21){
            ListeJetons[nombreJetonsrestants] = Jeton_a_ajouter;
            Reponse = true;
            
        }
        return Reponse;
    }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs+=1;
    }
    public boolean utiliserDesintegrateur(){
        boolean reponse = false;
        if (nombreDesintegrateurs>0 ){
            nombreDesintegrateurs-=1;
            reponse = true;
        }
        return reponse;
        
        
    }
    
}
