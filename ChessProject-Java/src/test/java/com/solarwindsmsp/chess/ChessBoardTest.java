package com.solarwindsmsp.chess;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends TestCase {

	private ChessBoard testSubject;

	@Before
	public void setUp() throws Exception {
		testSubject = new ChessBoard();
	}

	@Test
	// Change to TC made
	public void testHas_MaxBoardWidth_of_8() {
		assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
	}

	@Test
	// Change to TC made
	public void testHas_MaxBoardHeight_of_8() {
		assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
	}

	@Test
	public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(0, 0);
		assertTrue(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(5, 5);
		Assert.assertTrue(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(11, 5);
		// assertTrue(isValidPosition);
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(0, 9);
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(11, 0);
		assertFalse(isValidPosition);
	}

	@Test
	public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
		boolean isValidPosition = testSubject.isLegalBoardPosition(5, -1);
		Assert.assertFalse(isValidPosition);
	}

	@Test
	public void testAvoids_Duplicate_Positioning() {
		Pawn firstPawn = new Pawn(PieceColor.BLACK);
		Pawn secondPawn = new Pawn(PieceColor.BLACK);
		testSubject.addPiece(firstPawn, 6, 3, PieceColor.BLACK);
		testSubject.addPiece(secondPawn, 6, 3, PieceColor.BLACK);
		assertEquals(6, firstPawn.getXCoordinate());
		assertEquals(3, firstPawn.getYCoordinate());
		assertEquals(-1, secondPawn.getXCoordinate());
		assertEquals(-1, secondPawn.getYCoordinate());
	}

	@Test
	public void testLimits_The_Number_Of_Pawns_Black() {
		for (int i = 0; i < 10; i++) {
			Pawn pawn = new Pawn(PieceColor.BLACK);
			// Change to TC made
			int row = i / ChessBoard.MAX_BOARD_HEIGHT;
			// Change to TC made
			testSubject.addPiece(pawn, 6 + row, i % ChessBoard.MAX_BOARD_WIDTH, PieceColor.BLACK);
			if (row < 1) {
				assertEquals(6 + row, pawn.getXCoordinate());
				assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getYCoordinate());
			} else {
				assertEquals(-1, pawn.getXCoordinate());
				Assert.assertEquals(-1, pawn.getYCoordinate());
			}
		}
	}

	// TC added for adding White Pawn piece
	@Test
	public void testLimits_The_Number_Of_Pawns_White() {
		for (int i = 0; i < 10; i++) {
			Pawn pawn = new Pawn(PieceColor.WHITE);
			// Change to TC made
			int row = i / ChessBoard.MAX_BOARD_HEIGHT;
			// Change to TC made
			testSubject.addPiece(pawn, 1 - row, i % ChessBoard.MAX_BOARD_WIDTH, PieceColor.WHITE);
			if (row < 1) {
				assertEquals(1 - row, pawn.getXCoordinate());
				assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getYCoordinate());
			} else {
				assertEquals(-1, pawn.getXCoordinate());
				Assert.assertEquals(-1, pawn.getYCoordinate());
			}
		}
	}
}