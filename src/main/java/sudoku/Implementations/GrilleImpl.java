package sudoku.Implementations;
package sudoku.ElementDeGrille;


import sudoku.Grille;

/**
 * Implementation de l'interface Grille.
 */
public class GrilleImpl implements Grille {
    
/**
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
    
GrilleImpl(final ElementDeGrille[][] g){

this.grille = ElementDeGrille[g.length][g.length];

for(int i=0; i<g[0].length; i++){
    vaGrille.add(new ElementDeGrille((i+1)));
    for(int j=0; j<g[0].length; j++){
        this.grille[i][j] = g[i][j];
    }

}



}

}
