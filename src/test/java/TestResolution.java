import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import sudoku.ElementDeGrille;
import sudoku.Grille;
import sudoku.Resolution;

import sudoku.Implementations.ElementDeGrilleImplAsChar;
import sudoku.Implementations.GrilleImpl;

import sudoku.Exceptions.ElementInterditException;
import sudoku.Exceptions.HorsBornesException;
import sudoku.Exceptions.ValeurImpossibleException;
import sudoku.Exceptions.ValeurInitialeModificationException;

/*
 * 
 * @author groupe R
 */
public class TestResolution {
    

    @Test
    public void testSolveur() throws HorsBornesException, ElementInterditException, ValeurImpossibleException,
            ValeurInitialeModificationException {
        
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
        
        Grille grille = new GrilleImpl(valeursAcceptees, grilleRemplie);

        Resolution solveur = new Resolution();

        // Affichage de la grille avant la resolution
        System.out.println(grille);

        boolean resolue = solveur.solve(grille);

        System.out.println("la grille resolue : ");

        System.out.println(grille);

        //Si isComplete() et resolue ne sont pas égales à true à la fin de la résolution c'est que la grille n'a pas été résolue
        assertEquals(true, grille.isComplete());

        assertEquals(true, resolue);

    }

    @Test
    public void testKOSolveur() throws HorsBornesException, ElementInterditException, ValeurImpossibleException,
            ValeurInitialeModificationException {
        
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
        
        
        //La case [0][0] ne peut pas être remplie
        ElementDeGrille[][] grilleImpossible = {
                {null,trois,deux,quatre,sept,cinq,six,huit,neuf},
                {six,null,null,un,neuf,cinq,null,null,null},
                {un,neuf,huit,null,null,null,null,six,null},
                {huit,null,null,null,six,null,null,null,trois},
                {quatre,null,null,huit,null,trois,null,null,un},
                {sept,null,null,null,deux,null,null,null,six},
                {null,six,null,null,null,null,deux,huit,null},
                {null,null,null,quatre,un,neuf,null,null,cinq},
                {null,null,null,null,huit,null,null,sept,neuf}
        };
        
        Grille grille = new GrilleImpl(valeursAcceptees, grilleImpossible);

        Resolution solveur = new Resolution();

        // Affichage de la grille avant la resolution
        System.out.println(grille);

        boolean resolue = solveur.solve(grille);

        System.out.println("la grille est impossible à résoudre : ");

        System.out.println(grille);

        //Si isComplete() et resolue ne sont pas égales à true à la fin de la résolution c'est que la grille n'a pas été résolue
        //Cela sera le cas puisque la grille est impossible à résoudre
        assertEquals(false, grille.isComplete());

        assertEquals(false, resolue);

    }
}
