package sudoku.Exceptions;

/**
 * definition de ValeurInitialeModificationException.
 * @author Groupe R
 */
public class ValeurInitialeModificationException extends Exception {

    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public ValeurInitialeModificationException(final String error) {
        super(error);
    }
}
