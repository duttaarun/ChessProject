package com.solarwindsmsp.chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

	private ChessBoard chessBoard;
	private Pawn testSubject;
	private Pawn testSubjectWhite;

	@Before
	public void setUp() {
		this.chessBoard = new ChessBoard();
		this.testSubject = new Pawn(PieceColor.BLACK);
		this.testSubjectWhite = new Pawn(PieceColor.WHITE);
	}

	@Test
	public void testChessBoard_Add_Sets_XCoordinate() {
		this.chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
		assertEquals(6, testSubject.getXCoordinate());
	}

	@Test
	public void testChessBoard_Add_Sets_YCoordinate() {
		this.chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
		assertEquals(3, testSubject.getYCoordinate());
	}

	@Test
	public void testChessBoard_Add_Sets_XCoordinate_White() {
		this.chessBoard.addPiece(testSubjectWhite, 1, 2, PieceColor.WHITE);
		assertEquals(1, testSubjectWhite.getXCoordinate());
	}

	@Test
	public void testChessBoard_Add_Sets_YCoordinate_White() {
		this.chessBoard.addPiece(testSubjectWhite, 1, 2, PieceColor.WHITE);
		assertEquals(2, testSubjectWhite.getYCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
		testSubject.move(MovementType.MOVE, 7, 3);
		assertEquals(6, testSubject.getXCoordinate());
		assertEquals(3, testSubject.getYCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
		chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
		testSubject.move(MovementType.MOVE, 4, 3);
		assertEquals(6, testSubject.getXCoordinate());
		assertEquals(3, testSubject.getYCoordinate());
	}

	@Test
	public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
		//Change of TC as pawn can only move forward (forward diagonal in case of capture only)
		chessBoard.addPiece(testSubject, 6, 3, PieceColor.BLACK);
		testSubject.move(MovementType.MOVE, 5, 3);
		assertEquals(5, testSubject.getXCoordinate());
		assertEquals(3, testSubject.getYCoordinate());
	}
	
	
	/**
	 * TCs added for White pawn
	 */	
	@Test
	public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 4, PieceColor.WHITE);
		testSubjectWhite.move(MovementType.MOVE, 0, 4);
		assertEquals(1, testSubjectWhite.getXCoordinate());
		assertEquals(4, testSubjectWhite.getYCoordinate());
	}

	@Test
	public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 4, PieceColor.WHITE);
		testSubjectWhite.move(MovementType.MOVE, 3, 4);
		assertEquals(1, testSubjectWhite.getXCoordinate());
		assertEquals(4, testSubjectWhite.getYCoordinate());
	}

	@Test
	public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates_White() {
		chessBoard.addPiece(testSubjectWhite, 1, 4, PieceColor.WHITE);
		testSubjectWhite.move(MovementType.MOVE, 2, 4);
		assertEquals(2, testSubjectWhite.getXCoordinate());
		assertEquals(4, testSubjectWhite.getYCoordinate());
	}

}