package sudoku.Exceptions;

/**
 * definition de HorsBorneException.
 * @author Groupe R
 */
public class HorsBornesException extends Exception {

    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public HorsBornesException(final String error) {
        super(error);
    }
}
