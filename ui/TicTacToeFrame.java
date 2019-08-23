package game.ui;

import game.TicTacToe;
import game.TicTacToe.Peg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
  private static final int SIZE = 3;
  TicTacToe ticTacToe;
  @Override
  protected void frameInit() {
    super.frameInit();
    ticTacToe = new TicTacToe();
    setLayout(new GridLayout(3, 3));
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        TicTacToeCell cell = new TicTacToeCell(i, j);
        getContentPane().add(cell);

        cell.addActionListener(new CellClickedHandler());
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new TicTacToeFrame();
    frame.setSize(250, 250);
    frame.setVisible(true);
  }

  private class CellClickedHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      TicTacToeCell cell = (TicTacToeCell)actionEvent.getSource();

      TicTacToe.Peg placed = ticTacToe.placePeg(cell.row, cell.column);
      if (placed == Peg.FIRST)
        cell.setText("X");

      if (placed == Peg.SECOND)
        cell.setText("O");

      Peg winner = ticTacToe.winner();
      if (winner != Peg.NONE) {
        JOptionPane.showMessageDialog(cell,"We have a winner!: " + winner.toString());
      }
    }
  }
}
