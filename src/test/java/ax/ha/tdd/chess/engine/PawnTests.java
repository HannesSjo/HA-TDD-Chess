package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    @Test
    public void testMovePawnBackwardsShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        assertFalse(pawn.canMove(chessboard, new Square("e1")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testPawnForwardMove() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        boolean canMove = pawn.canMove(chessboard, new Square("e3"));
        assertTrue(canMove);
    }

    @Test
    public void testPawnFirstMoveTwoSquares() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        boolean canMove = pawn.canMove(chessboard, new Square("e4"));

        assertTrue(canMove);
    }

    @Test
    public void testPawnDiagonalCapture() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn whitePawn = new Pawn(Color.WHITE, new Square("e2"));
        Pawn blackPawn = new Pawn(Color.BLACK, new Square("d3"));
        chessboard.addPiece(whitePawn);
        chessboard.addPiece(blackPawn);

        boolean canMove = whitePawn.canMove(chessboard, new Square("d3"));
        assertTrue(canMove);
    }

    @Test
    public void testPawnIllegalMove() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        boolean canMove = pawn.canMove(chessboard, new Square("e5"));
        assertFalse(canMove);
    }

    @Test
    public void testPawnMoveDiagonallyToEmptySquare() {
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        boolean canMove = pawn.canMove(chessboard, new Square("d3"));

        assertFalse(canMove);
    }

}
