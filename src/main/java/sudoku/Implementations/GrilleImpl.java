package sudoku.Implementations;
import sudoku.ElementDeGrille;
import sudoku.Grille;

/**
 * Implementation de l'interface Grille.
 */
public class GrilleImpl implements Grille {
    
/**cl
 * Grille
 */
private final ElementDeGrille[][] grille;

/**
 * Valeurs autorises
 */
private final ElementDeGrille[] vaGrille;

/**
 * Constructeur de la grille
 * @param grille .
 */

public GrilleImpl(final ElementDeGrille[] edg, final ElementDeGrille[][] g){

this.grille = new ElementDeGrille[g.length][g.length];

vaGrille = new ElementDeGrille[edg.length];

for(int i=0; i<g[0].length; i++){
    vaGrille[i]=edg[i];

    for(int j=0; j<g[0].length; j++){
        this.grille[i][j] = g[i][j];
    }

}

}

ElementDeGrille[] getElements(){

    ElementDeGrille[] myElements;

    for(int i=0; i<this.vaGrille.length; i++){
        myElements.add(this.vaGrille[i]);
    }

    return myElements;
}

}
