package sudoku.Implementations;
import sudoku.ElementDeGrille;
import sudoku.Grille;
import java.util.Set;
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

/**
 * Constructeur de la grille.
 * @param grille .
 */
public GrilleImpl(final ElementDeGrille[] valeurAcceptees, final ElementDeGrille[][] g){

this.grille = new ElementDeGrille[g.length][g.length];
vaGrille = new ElementDeGrille[valeurAcceptees.length];

for(int i=0; i<g[0].length; i++){
    vaGrille[i]=valeurAcceptees[i];

    for(int j=0; j<g[0].length; j++){
        this.grille[i][j] = g[i][j];
    }
}

}


@Override
public int getDimension(){ 
    //return 1;
    return this.grille[0].length;
}

/**
 * Methode pour récupérer les éléments de la grille.
 */
@Override
public Set<ElementDeGrille> getElements(){
    return null;
}

@Override
public void setValue(int x, int y, ElementDeGrille value){
}

@Override
public ElementDeGrille getValue(int x, int y){
    return null;
}

@Override
public boolean isComplete(){
    return true;
}

@Override
public boolean isPossible(int x, int y, ElementDeGrille value){
    return true;
}

@Override
public boolean isValeurInitiale(int x,int y){
    return true;
}

}
