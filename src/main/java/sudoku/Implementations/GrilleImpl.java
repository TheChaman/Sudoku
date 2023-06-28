package sudoku.Implementations;
import sudoku.ElementDeGrille;
import sudoku.Exceptions.*;
import sudoku.Grille;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Implementation de l'interface Grille.
 * 
 */
public class GrilleImpl implements Grille {
    
/**
 * Grille.
 */
private final ElementDeGrille[][] grille;

/**
 * Valeurs autorises.
 */
private final ElementDeGrille[] vaGrille;

private final boolean [][] valeursInitial;


/**
 * Constructeur de la grille.
 * @param grille .
 */
public GrilleImpl(final ElementDeGrille[] valeurAcceptees, final ElementDeGrille[][] g){

this.valeursInitial = new boolean[g.length][g.length];
this.grille = new ElementDeGrille[g.length][g.length];
this.vaGrille = new ElementDeGrille[valeurAcceptees.length];

for(int i=0; i<g[0].length; i++){
    this.vaGrille[i]=valeurAcceptees[i];
    for(int j=0; j<g[0].length; j++){
        this.grille[i][j] = g[i][j];
        if(g[i][j] != null){
            this.valeursInitial[i][j] = false;
        }

    }
}


}

@Override
public int getDimension(){ 
    return this.grille[0].length;
}

@Override
public Set<ElementDeGrille> getElements(){
    return new HashSet<>(Arrays.asList(this.vaGrille));
}

@Override
public void setValue (int x, int y, ElementDeGrille value) throws HorsBornesException,ValeurInitialeModificationException,ElementInterditException,ValeurImpossibleException{

    if(x > this.grille[0].length || y  > this.grille[0].length){
        throw new HorsBornesException("erreur");
    }
    
    if( isValeurInitiale(x,y) ){
        throw new ValeurInitialeModificationException("Erreur, on tente de modifier la valeur Initiale :"+this.valeursInitial+"a la position x:"+x+"et y:"+y);      
    }
            
    if( !(Arrays.asList(this.vaGrille).contains(value))){
        throw new ElementInterditException("L'element de grille :"+value+" n'est pas autorise");      
    }

    //Les règles du Sudoku pour une sous-grille sont respectés ?
    int tailleSG = (int)Math.sqrt( this.grille[0].length );
    int indiceSGXDebut = x - (x % tailleSG);
    int indiceDGXFin = indiceSGXDebut + tailleSG;
    int indiceSGYDebut = y - (y % tailleSG);
    int indiceSGYFin = indiceSGYDebut + tailleSG;

    for (int i = indiceSGXDebut; i <= indiceDGXFin; i++) {
        for (int j = indiceSGYDebut; j <= indiceSGYFin; j++) {
            if (getValue(x,y) == value) {
                throw new ValeurImpossibleException("Votre coup ne respecte pas les règles du sudoku");
            }
        }
    }

    // Les règles du Sudoku pour une grille sont respectés ?

    // La valeur est-elle déjà présente dans la colonne ?
    for(int i=0; i<this.grille[0].length; i++){
        if(this.grille[i][y] == value && (i != x)){
            throw new ValeurImpossibleException("Votre coup ne respecte pas les règles du sudoku");
        }
    }
    
    // La valeur est-elle déjà présente dans la colonne ?
    for( int j=0; j < this.grille[0].length; j++){
        if( this.grille[x][j] == value && (j != y)){
            throw new ValeurImpossibleException("Votre coup ne respecte pas les règles du sudoku");
        }
    }
          
    
}

@Override
public ElementDeGrille getValue(int x, int y) throws HorsBornesException{

    if(x > this.grille[0].length || y  > this.grille[0].length){
        throw new HorsBornesException("error");
    } else {
        return this.grille[x][y];
    }
}


@Override
public boolean isComplete(){
    
    boolean isComplete = true;

    for(int i=0; i<this.grille[0].length; i++){
        for(int j=0; j<this.grille[0].length; j++){
            if(this.grille[i][j] == null){
                isComplete = false;
            }
    }
}
    return isComplete;

}

@Override
public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException {

    boolean isPossible = true;

    // Grille[x,y] dépasse les bornes ??
    if (x > this.grille[0].length || y > this.grille[0].length ) {
        isPossible = false;
        throw new HorsBornesException("L'indice x :"+x+" et y :"+y+" est hors borne");
    } 
    
    // La valeur est-elle une valeur autorisée
    if( ! ( Arrays.asList(this.vaGrille).contains(value) )){
        isPossible = false;
        throw new ElementInterditException("L'element de grille :"+value+" n'est pas autorise");      
    }

    return isPossible;
}

@Override
public boolean isValeurInitiale(int x,int y){

    boolean isValeuriIni = false;

    if(this.valeursInitial[x][y]){
        return isValeuriIni = true;
    }

    return isValeuriIni;
}

}
