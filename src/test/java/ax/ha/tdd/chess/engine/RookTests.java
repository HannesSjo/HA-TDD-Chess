package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {

    @Test
    public void testRookCanMoveHorizontally() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("e1"));
        chessboard.addPiece(rook);

        boolean canMove = rook.canMove(chessboard, new Square("a1"));

        assertTrue(canMove);
    }

    @Test
    public void testRookCanMoveVertically() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("e1"));
        chessboard.addPiece(rook);

        boolean canMove = rook.canMove(chessboard, new Square("e8"));

        assertTrue(canMove);
    }

    @Test
    public void testRookCannotMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("e1"));
        chessboard.addPiece(rook);

        boolean canMove = rook.canMove(chessboard, new Square("h4"));

        assertFalse(canMove);
    }

    @Test
    public void testRookBlockedByPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("e1"));
        chessboard.addPiece(rook);
        chessboard.addPiece(new Pawn(Color.BLACK, new Square("e2")));

        boolean canMove = rook.canMove(chessboard, new Square("e8"));

        assertFalse(canMove);
    }

    @Test
    public void testRookCanCaptureOpposingPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("e1"));
        chessboard.addPiece(rook);
        chessboard.addPiece(new Pawn(Color.BLACK, new Square("e8")));

        boolean canMove = rook.canMove(chessboard, new Square("e8"));

        assertTrue(canMove);
    }
}