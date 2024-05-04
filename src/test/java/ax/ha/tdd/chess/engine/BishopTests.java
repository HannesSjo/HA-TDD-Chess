package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTests {

    @Test
    public void testBishopMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("d1"));
        chessboard.addPiece(bishop);

        boolean canMove = bishop.canMove(chessboard, new Square("g4"));

        assertTrue(canMove);
    }

    @Test
    public void testBishopCannotMoveHorizontally() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("d1"));
        chessboard.addPiece(bishop);

        boolean canMove = bishop.canMove(chessboard, new Square("g1"));

        assertFalse(canMove);
    }

    @Test
    public void testBishopCannotMoveVertically() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("d1"));
        chessboard.addPiece(bishop);

        boolean canMove = bishop.canMove(chessboard, new Square("d4"));

        assertFalse(canMove);
    }

    @Test
    public void testBishopCanCaptureOpposingPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("d1"));
        chessboard.addPiece(bishop);
        chessboard.addPiece(new Pawn(Color.BLACK, new Square("g4")));

        boolean canMove = bishop.canMove(chessboard, new Square("g4"));

        assertTrue(canMove);
    }

    @Test
    public void testBishopBlockedByPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("d1"));
        chessboard.addPiece(bishop);
        chessboard.addPiece(new Pawn(Color.WHITE, new Square("e2")));

        boolean canMove = bishop.canMove(chessboard, new Square("f3"));

        assertFalse(canMove);
    }
}