package sudoku;

import sudoku.Exceptions.ElementInterditException;
import sudoku.Exceptions.HorsBornesException;
import sudoku.Exceptions.ValeurImpossibleException;
import sudoku.Exceptions.ValeurInitialeModificationException;

/**
 * Interface de résolveur de Grille
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface Solveur {
    /**
     * Résout une Grille
     *
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     */
    boolean solve(Grille grille) throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException, ValeurImpossibleException;
}
