package sudoku.Exceptions;

/**
 * definition de CaractereInterditException.
 * @author Groupe R
 */
public class ElementInterditException extends Exception {

    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public ElementInterditException(final String error) {
        super(error);
    }
}
