package Sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;


public class SudokuController {

    private class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Sudoku sudoku;

    private boolean showIntersects = true;

    private boolean highlightValues = true;

    @FXML
    private Pane gameGrid;

    @FXML
    private Button newGame;

    @FXML
    private Button toggleIntersects;

    @FXML
    private Button toggleHighlightValues;


    @FXML
    public void initialize() {
        sudoku = new Sudoku();
    }

    @FXML
    public void reset() {
        sudoku = new Sudoku();
        drawGrid();
    }

    @FXML
    public void toggleIntersects() {
        showIntersects = !showIntersects;
    }

    @FXML
    public void highlightValues() {
        highlightValues = !highlightValues;
    }


    @FXML
    public void setShowIntersects(HashMap<Integer, Rectangle> cellMap, int[] intersectArray) {
        if (showIntersects) {
            for (int j = 1; j < 82; j++) {
                for (int k = 0; k < intersectArray.length; k++) {
                    if (j == intersectArray[k]) {
                        Rectangle newCell = cellMap.get(j);
                        newCell.setFill(Color.LIGHTGREY);
                    }
                }
            }
        }
    }


    @FXML
    public void drawGrid() {
        gameGrid.getChildren().clear();
        double cellWidth = gameGrid.getWidth() / sudoku.getLength2();
        double cellHeight = gameGrid.getHeight() / sudoku.getLength2();
        HashMap<Integer, Rectangle> cellMap = new HashMap<>(81);
        int count = 0;
        for (int i = 0; i < sudoku.getLength1(); i++) {
            for (int n = 0; n < sudoku.getLength2(); n++) {
                Rectangle cell = new Rectangle(n * cellWidth, i * cellHeight, cellWidth, cellHeight);
//                Label label = new Label("" + sudoku.currentKey.get((9 * i) + (n + 1)));
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
//                gameGrid.getChildren().add(label);
                gameGrid.getChildren().add(cell);
                count++;
                cellMap.put(count, cell);
                int selectedCell = sudoku.grid[n][i];
                int[] intersectArray = sudoku.intersectionKey.get(selectedCell);
                Position p = new Position(i, n);

                int finalCount = count;
//                int finalI = i;
//                int finalN = n;

                cell.setOnMouseClicked(event -> {
                    for (int j = 1; j < 82; j++) {
                        Rectangle newCell = cellMap.get(j);
                        newCell.setFill(Color.WHITE);
                    }
                    cell.setFill(Color.LIGHTSTEELBLUE);

//                    System.out.println((9 * finalI) + (finalN + 1));
                    System.out.println(finalCount);
                    System.out.println(selectedCell);

                    // Need to highlight cells with the same value as well

                    setShowIntersects(cellMap, intersectArray);
                });
            }
        }
    }
}