package sudoku.Implementations;
import sudoku.ElementDeGrille;
import sudoku.Grille;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
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
vaGrille = new ElementDeGrille[valeurAcceptees.length];

for(int i=0; i<g[0].length; i++){
    vaGrille[i]=valeurAcceptees[i];
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
public void setValue(int x, int y, ElementDeGrille value){
    this.grille[x][y] = value;
}

@Override
public ElementDeGrille getValue(int x, int y){

    return this.grille[x][y];
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
public boolean isPossible(int x, int y, ElementDeGrille value){

    boolean isPossible = true;

    if(x > this.grille[0].length || y > this.grille[0].length){
        isPossible = false;
    }else{
       if( !(Arrays.asList(this.vaGrille).contains(value) )){
            isPossible = false;
       }
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
