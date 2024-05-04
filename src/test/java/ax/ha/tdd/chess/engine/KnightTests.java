package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTests {

    @Test
    public void testKnightMoveLShape() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("d4"));
        chessboard.addPiece(knight);

        boolean canMove1 = knight.canMove(chessboard, new Square("e6"));
        boolean canMove2 = knight.canMove(chessboard, new Square("f5"));
        boolean canMove3 = knight.canMove(chessboard, new Square("f3"));
        boolean canMove4 = knight.canMove(chessboard, new Square("e2"));
        boolean canMove5 = knight.canMove(chessboard, new Square("c2"));
        boolean canMove6 = knight.canMove(chessboard, new Square("b3"));
        boolean canMove7 = knight.canMove(chessboard, new Square("b5"));
        boolean canMove8 = knight.canMove(chessboard, new Square("c6"));

        assertTrue(canMove1);
        assertTrue(canMove2);
        assertTrue(canMove3);
        assertTrue(canMove4);
        assertTrue(canMove5);
        assertTrue(canMove6);
        assertTrue(canMove7);
        assertTrue(canMove8);
    }

    @Test
    public void testKnightCannotMoveStraight() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("d4"));
        chessboard.addPiece(knight);

        boolean canMove1 = knight.canMove(chessboard, new Square("d5"));
        boolean canMove2 = knight.canMove(chessboard, new Square("d6"));
        boolean canMove3 = knight.canMove(chessboard, new Square("d3"));
        boolean canMove4 = knight.canMove(chessboard, new Square("d2"));
        boolean canMove5 = knight.canMove(chessboard, new Square("e4"));
        boolean canMove6 = knight.canMove(chessboard, new Square("f4"));
        boolean canMove7 = knight.canMove(chessboard, new Square("c4"));
        boolean canMove8 = knight.canMove(chessboard, new Square("b4"));

        assertFalse(canMove1);
        assertFalse(canMove2);
        assertFalse(canMove3);
        assertFalse(canMove4);
        assertFalse(canMove5);
        assertFalse(canMove6);
        assertFalse(canMove7);
        assertFalse(canMove8);
    }

    @Test
    public void testKnightCannotMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("d4"));
        chessboard.addPiece(knight);

        boolean canMove1 = knight.canMove(chessboard, new Square("e5"));
        boolean canMove2 = knight.canMove(chessboard, new Square("e3"));
        boolean canMove3 = knight.canMove(chessboard, new Square("c5"));
        boolean canMove4 = knight.canMove(chessboard, new Square("c3"));

        assertFalse(canMove1);
        assertFalse(canMove2);
        assertFalse(canMove3);
        assertFalse(canMove4);
    }

    @Test
    public void testKnightCaptureOpponentPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("d4"));
        chessboard.addPiece(knight);
        ChessPiece opponentPiece = new Pawn(Color.BLACK, new Square("e6"));
        chessboard.addPiece(opponentPiece);

        boolean canMove = knight.canMove(chessboard, new Square("e6"));

        assertTrue(canMove);
    }
}