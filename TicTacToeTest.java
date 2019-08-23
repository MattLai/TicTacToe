package game;

import org.junit.Before;
import org.junit.Test;

import game.TicTacToe.Peg;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
  TicTacToe ticTacToe;

  @Before
  public void setUp() {
    ticTacToe = new TicTacToe();
  }

  @Test
  public void Canary() {
    assertTrue(true);
  }

  @Test
  public void GameWonByNoneAtStart() {

    assertEquals(Peg.NONE, ticTacToe.winner());
  }

  @Test
  public void pickFirstPeg() {
    assertEquals(Peg.FIRST, ticTacToe.placePeg(0, 1));
  }

  @Test
  public void placeSecondPeg() {
    ticTacToe.placePeg(0, 2);
    assertEquals(Peg.SECOND, ticTacToe.placePeg(0, 1));
  }

  @Test
  public void placePegAtOccupiedPosition() {
    ticTacToe.placePeg(2, 1);
    assertEquals(Peg.FIRST, ticTacToe.placePeg(2, 1));
  }

  @Test
  public void placePegOutOfRowRange() {
    try {
      ticTacToe.placePeg(0, 7);
      fail("Expected exception for stepping out of bound");
    } catch (IndexOutOfBoundsException ex) {

    }
  }

  @Test
  public void winnerReportRowMatch() {
    ticTacToe = new TicTacToe() {
      @Override
      public Peg checkRowMatch() {
        return Peg.SECOND;
      }
    };
    assertEquals(Peg.SECOND, ticTacToe.winner());
  }

  @Test
  public void winByColumnMatch() {
    ticTacToe.placePeg(0,2);
    ticTacToe.placePeg(1, 1);
    ticTacToe.placePeg(2,2);
    ticTacToe.placePeg(0,1);
    ticTacToe.placePeg(0,0);
    ticTacToe.placePeg(2,1);
    assertEquals(Peg.SECOND, ticTacToe.checkColumnMatch());
  }

  @Test
  public void noWinByColumnMatch() {
    ticTacToe.placePeg(0,2);
    ticTacToe.placePeg(1, 1);
    ticTacToe.placePeg(2,2);
    ticTacToe.placePeg(0,1);
    ticTacToe.placePeg(0,0);
    assertEquals(Peg.NONE, ticTacToe.checkColumnMatch());
  }

  @Test
  public void winnerReportColumnMatch() {
    ticTacToe = new TicTacToe() {
      @Override
      public Peg checkRowMatch() {
        return Peg.NONE;
      }

      @Override
      public Peg checkColumnMatch() {
        return Peg.FIRST;
      }
    };
    assertEquals(Peg.FIRST, ticTacToe.winner());
  }
}
