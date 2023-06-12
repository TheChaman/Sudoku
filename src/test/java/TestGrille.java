
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import sudoku.Implementations.ElementDeGrilleImplAsChar;
import sudoku.Implementations.GrilleImpl;
import sudoku.ElementDeGrille;
import sudoku.Grille;

/**
 * @author groupe R
 *          
 */
public class TestGrille {

    @Test
    public void testGetValue() {
        char valeurTest = '1';
        Grille grille = new GrilleImpl();
        assertEquals('1', grille.getValue(0,0));
    }

    @Test
    public void testKOGetValue() {
        char valeurTest = '1';
        Grille grille = new GrilleImpl();
        assertEquals('1', grille.getValue(5,10));
    }

    @Test
    public void testSetValue() {
        ElementDeGrille valeurTest = new ElementDeGrilleImplAsChar('1');
        Grille grille = new GrilleImpl();
        assertEquals(true,grille.setValue(0,0,valeurTest));
    }

    @Test
    public void testKO1SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        ElementDeGrille sept = new ElementDeGrilleImplAsChar('7');
        
        ElementDeGrille[][] grilleRemplie = {
        {un,deux,trois,quatre},
        {deux,trois,quatre,un},
        {null,quatre,un,null},
        {null,un,null,trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie,);

        assertEquals(false,grille.setValue(3, 0, sept));
        
    }

    @Test
    public void testKO2SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        
        ElementDeGrille[][] grilleRemplie = {
        {un,deux,trois,quatre},
        {deux,trois,quatre,un},
        {null,quatre,un,null},
        {null,un,null,trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie,);

        assertEquals(false,grille.setValue(5, 0, trois));
    }

    @Test
    public void testKO3SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        
        ElementDeGrille[][] grilleRemplie = {
        {un,deux,trois,quatre},
        {deux,trois,quatre,un},
        {null,quatre,un,null},
        {null,un,null,trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie,);

        assertEquals(false,grille.setValue(3, 0, un));
    }

    @Test
    public void testKO4SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        
        ElementDeGrille[][] grilleRemplie = {
        {un,deux,trois,quatre},
        {deux,trois,quatre,un},
        {null,quatre,un,null},
        {null,un,null,trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie,);

        assertEquals(false,grille.setValue(0, 0, quatre));
    }

    @Test
    public void testIsPossible() {
        ElementDeGrille valeurTest = new ElementDeGrilleImplAsChar('1');
        Grille grille = new GrilleImpl();
        assertEquals(true, grille.isPossible(1, 1, valeurTest));

    }

    @Test
    public void testKOIsPossible() {

    }


}
