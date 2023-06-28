package sudoku;
import java.util.Set;

import sudoku.Exceptions.ElementInterditException;
import sudoku.Exceptions.HorsBornesException;
import sudoku.Exceptions.ValeurImpossibleException;
import sudoku.Exceptions.ValeurInitialeModificationException;
/**
 * Interface de résolveur de Grille
 *
 * @author groupe R
 */
public class Resolution implements Solveur {
    /**
     * Résoud une Grille
     *
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     */
    public final boolean solve(final Grille grille) throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException, ValeurImpossibleException {
        System.out.println(grille);

        Set<ElementDeGrille> elementsValides = grille.getElements();

        boolean mouvementPossible = false;

        int nombreLignes = grille.getDimension();
        int nombreCol = nombreLignes;

        // Si la grille de Sudoku est complète, on arrête le programme puisque le sudoku est résolu
        if(grille.isComplete()) {
            return true;
        }

        for(int i = 0; i < nombreLignes; i++) {
            for(int j = 0; j < nombreCol; j++) {
                for(ElementDeGrille caseATester: elementsValides) {
                    mouvementPossible = grille.isPossible(i, j, caseATester);
                    ElementDeGrille valeurASaisir = grille.getValue(i, j);

                    if(mouvementPossible && valeurASaisir == null) {
                        grille.setValue(i, j, caseATester);
                    } else {
                        grille.setValue(i, j, null);
                    }
                }
            }
        }

        return false;
    }
}