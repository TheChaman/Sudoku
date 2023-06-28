import org.junit.jupiter.api.Test;
import sudoku.ElementDeGrille;
import sudoku.Exceptions.ElementInterditException;
import sudoku.Exceptions.HorsBornesException;
import sudoku.Exceptions.ValeurImpossibleException;
import sudoku.Exceptions.ValeurInitialeModificationException;
import sudoku.Grille;
import sudoku.Implementations.ElementDeGrilleImplAsChar;
import sudoku.Implementations.GrilleImpl;

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
    }

    @Test
    public void testKOConstructionRespectantLesRegles() {

        ElementDeGrille element1 = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille element2 = new ElementDeGrilleImplAsChar('2');

            try {
                new GrilleImpl(new ElementDeGrille[]{element1, element2}, new ElementDeGrille[][]{{element1, element2},{element2, element1, element1}});
            } catch (Exception e) {

            }
    }

    @Test
    public void testGetValue() throws HorsBornesException {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, null, null},
                {deux, null, null, null},
                {null, quatre, null, null},
                {null, null, null, null}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        grille.getValue(0,0);
    }

    @Test
    public void testKOGetValue() {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, null, null},
                {deux, null, null, null},
                {null, quatre, null, null},
                {null, null, null, null}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        try{
            grille.getValue(5, 10);
        } catch (HorsBornesException e) {

        }
    }

    @Test
    public void testSetValue() throws Exception {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, null, null},
                {deux, null, null, null},
                {null, quatre, null, null},
                {null, null, null, null}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        grille.setValue(0, 2, trois);
        
    }

    @Test
    public void testKO1SetValue() throws ValeurInitialeModificationException, HorsBornesException, ValeurImpossibleException {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        ElementDeGrille sept = new ElementDeGrilleImplAsChar('7');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        try {
            grille.setValue(3, 0, sept);
            fail();
        } catch (ElementInterditException e){
            // ok
        }

    }

    @Test
    public void testKO2SetValue() throws ElementInterditException, ValeurInitialeModificationException, ValeurImpossibleException {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        try {
            grille.setValue(5, 0, trois);
            fail();
        } catch (HorsBornesException e) {

        }
        
    }

    @Test
    public void testKO3SetValue() throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees ,grilleRemplie);

        try {
            grille.setValue(3, 0, un);
            fail();
        } catch (ValeurImpossibleException e) {
            
        }
        
    }

    @Test
    public void testKO4SetValue() throws HorsBornesException, ElementInterditException, ValeurImpossibleException {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};
        
        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie );

        try {
            grille.setValue(0, 0, quatre);
            fail();
        } catch (ValeurInitialeModificationException e) {

        }
        
    }

     @Test
    public void testKO5SetValue() throws HorsBornesException, ElementInterditException, ValeurInitialeModificationException {
        
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        ElementDeGrille cinq = new ElementDeGrilleImplAsChar('5');
        ElementDeGrille six = new ElementDeGrilleImplAsChar('6');
        ElementDeGrille sept = new ElementDeGrilleImplAsChar('7');
        ElementDeGrille huit = new ElementDeGrilleImplAsChar('8'); 
        ElementDeGrille neuf = new ElementDeGrilleImplAsChar('9');

    
        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre,cinq,six,sept,huit,neuf};
        
        ElementDeGrille[][] grilleRemplie = {
                {cinq,trois,null,null,sept,null,null,null,null},
                {six,null,null,un,neuf,cinq,null,null,null},
                {null,neuf,huit,null,null,null,null,six,null},
                {huit,null,null,null,six,null,null,null,trois},
                {quatre,null,null,huit,null,trois,null,null,un},
                {sept,null,null,null,deux,null,null,null,six},
                {null,six,null,null,null,null,deux,huit,null},
                {null,null,null,quatre,un,neuf,null,null,cinq},
                {null,null,null,null,huit,null,null,sept,neuf}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie );

        try {
            grille.setValue(7, 7, deux);
            fail();
        } catch ( ValeurImpossibleException e) {
            

        }
        
    }

    @Test
    public void testIsPossible() throws Exception {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        grille.isPossible(3, 0, trois);


    }

    @Test
    public void testKOIsPossible() throws HorsBornesException {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');
        ElementDeGrille sept = new ElementDeGrilleImplAsChar('7');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        try {
            grille.isPossible(3, 0, sept);
            fail();
        } catch (ElementInterditException e){
            // ok
        }
    }

    @Test
    public void testKO2IsPossible() throws ElementInterditException {
        ElementDeGrille un = new ElementDeGrilleImplAsChar('1');
        ElementDeGrille deux = new ElementDeGrilleImplAsChar('2');
        ElementDeGrille trois = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille quatre = new ElementDeGrilleImplAsChar('4');

        ElementDeGrille[] valeursAcceptees = new ElementDeGrille[]{un,deux,trois,quatre};

        ElementDeGrille[][] grilleRemplie = {
                {un, deux, trois, quatre},
                {deux, trois, quatre, un},
                {null, quatre, un, null},
                {null, un, null, trois}
        };

        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        try {
            grille.isPossible(17, 5, deux);
            fail();
        } catch (HorsBornesException e){
            // ok
        }
    }


}
