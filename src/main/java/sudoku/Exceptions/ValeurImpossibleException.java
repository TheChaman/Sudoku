package sudoku.Exceptions;

/**
 * definition de ValeurImpossibleException.
 * @author Groupe R
 */
public class ValeurImpossibleException extends Exception {

    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public ValeurImpossibleException(final String error) {
        super(error);
    }
}
