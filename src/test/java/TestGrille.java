import org.junit.jupiter.api.Test;
import sudoku.ElementDeGrille;
import sudoku.Exceptions.ElementInterditException;
import sudoku.Exceptions.HorsBornesException;
import sudoku.Exceptions.ValeurImpossibleException;
import sudoku.Exceptions.ValeurInitialeModificationException;
import sudoku.Grille;
import sudoku.Implementations.ElementDeGrilleImplAsChar;
import sudoku.Implementations.GrilleImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author groupe R
 *  
 */
public class TestGrille {

    @Test
    public void testConstructionRespectantLesRegles() {

        ElementDeGrille element1 = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille element2 = new ElementDeGrilleImplAsChar('2');
        new GrilleImpl(
                new ElementDeGrille[]{element1, element2},
                new ElementDeGrille[][]{
                        {element1, element2},
                        {element2, element1}
                }
        );

        assertThrows(ValeurImpossibleException.class,()->
            new GrilleImpl(
                    new ElementDeGrille[]{element1, element2},
                    new ElementDeGrille[][]{
                            {element1, element1},
                            {element1, element1}
                    }
            )
        );

    }

    @Test
    public void testGetValue() throws HorsBornesException {
        char valeurTest = '1';
        Grille grille = new GrilleImpl();
        assertEquals('1', grille.getValue(0, 0));
    }

    @Test
    public void testKOGetValue() {
        char valeurTest = '1';
        Grille grille = new GrilleImpl();
        assertEquals('1', grille.getValue(5, 10));
    }

    @Test
    public void testSetValue() {
        ElementDeGrille valeurTest = new ElementDeGrilleImplAsChar('1');
        Grille grille = new GrilleImpl();
        assertEquals(true, grille.setValue(0, 0, valeurTest));
    }

    @Test
    public void testKO1SetValue() throws ElementInterditException, ValeurInitialeModificationException, HorsBornesException, ValeurImpossibleException {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        ElementDeGrille sept = new ElementDeGrilleImplAsChar('7');

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie, );

        assertThrows(ElementInterditException.class,()->   grille.setValue(3, 0, sept));

        try {
            grille.setValue(3, 0, sept);
            fail();
        } catch (ElementInterditException e){
            // ok
        }

    }

    @Test
    public void testKO2SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie, );

        assertEquals(false, grille.setValue(5, 0, trois));
    }

    @Test
    public void testKO3SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie, );

        assertEquals(false, grille.setValue(3, 0, un));
    }

    @Test
    public void testKO4SetValue() {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(grilleRemplie, );

        assertEquals(false, grille.setValue(0, 0, quatre));
    }

    @Test
    public void testIsPossible() {
        ElementDeGrille valeurTest = new ElementDeGrilleImplAsChar('1');
        Grille grille = new GrilleImpl();
        assertTrue(grille.isPossible(1, 1, valeurTest));

    }

    @Test
    public void testKOIsPossible() {

    }


}
