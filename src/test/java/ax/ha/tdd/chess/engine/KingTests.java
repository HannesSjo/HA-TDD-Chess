package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {

    @Test
    public void testKingMove() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);

        boolean canMove = king.canMove(chessboard, new Square("e2"));

        assertTrue(canMove);
    }

    @Test
    public void testKingCaptureOpposingPiece() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Pawn(Color.BLACK, new Square("e2"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("e2"));

        assertTrue(canMove);
    }

    @Test
    public void testKingMoveIntoQueenCheck() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Queen(Color.BLACK, new Square("d8"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("d1"));

        assertFalse(canMove);
    }

    @Test
    public void testKingMoveIntoRookCheck() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Rook(Color.BLACK, new Square("e8"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("e2"));

        assertFalse(canMove);
    }

    @Test
    public void testKingMoveIntoBishopCheck() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Bishop(Color.BLACK, new Square("a5"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("d2"));

        assertFalse(canMove);
    }

    @Test
    public void testKingMoveIntoKnightCheck() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e1"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Knight(Color.BLACK, new Square("f3"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("g2"));

        assertFalse(canMove);
    }

    @Test
    public void testKingMoveIntoPawnCheck() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("e2"));
        chessboard.addPiece(king);
        ChessPiece opposingPiece = new Pawn(Color.BLACK, new Square("f2"));
        chessboard.addPiece(opposingPiece);

        boolean canMove = king.canMove(chessboard, new Square("e1"));

        assertFalse(canMove);
    }
}