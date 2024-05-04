package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTests {

    @Test
    public void testQueenMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("d4"));
        chessboard.addPiece(queen);

        boolean canMove = queen.canMove(chessboard, new Square("a1"));

        assertTrue(canMove);
    }

    @Test
    public void testQueenMoveVertically() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("d4"));
        chessboard.addPiece(queen);

        boolean canMove = queen.canMove(chessboard, new Square("d1"));

        assertTrue(canMove);
    }

    @Test
    public void testQueenMoveHorizontally() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("d4"));
        chessboard.addPiece(queen);

        boolean canMove = queen.canMove(chessboard, new Square("a4"));

        assertTrue(canMove);
    }

    @Test
    public void testQueenMoveBlockedByPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("d4"));
        chessboard.addPiece(queen);
        ChessPiece blockingPiece = new Pawn(Color.WHITE, new Square("d5"));
        chessboard.addPiece(blockingPiece);

        boolean canMove = queen.canMove(chessboard, new Square("d8"));

        assertFalse(canMove);
    }

    @Test
    public void testQueenCaptureOpponentPiece() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("d4"));
        chessboard.addPiece(queen);
        ChessPiece opponentPiece = new Pawn(Color.BLACK, new Square("d8"));
        chessboard.addPiece(opponentPiece);

        boolean canMove = queen.canMove(chessboard, new Square("d8"));

        assertTrue(canMove);
    }
}