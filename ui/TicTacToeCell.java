package game.ui;

import javax.swing.*;

public class TicTacToeCell extends JButton {
  public final int row;
  public final int column;
  public TicTacToeCell(int theRow, int theColumn) {
    row = theRow;
    column = theColumn;
    setSize(150, 150);
  }
}
