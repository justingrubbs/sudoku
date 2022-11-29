package Sudoku;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class CellView extends Parent {
    private Rectangle cell;
    private Label label;
    private Sudoku sudoku;
    private int index;


    public CellView(int y,  int x, double width, double height, Sudoku sudoku, int index) {
        this.sudoku = sudoku;
        this.cell = new Rectangle(0, 0, width, height);
        this.index = index;
        if (sudoku.currentKey.get((9 * y) + (x + 1)) != 0) {
            this.label = new Label("" + sudoku.currentKey.get((9 * y) + (x + 1)));
        } else {
            this.label = new Label("");
        }
        cell.setFill(Color.WHITE);
        cell.setStroke(Color.BLACK);

        cell.setTranslateX(x * width);
        cell.setTranslateY(y * height);
        label.setTranslateX(x * width + (width / 3) - 1);
        label.setTranslateY(y * height + (height / 3) - 9);
        label.setFont(new Font("Arial", 30));


        getChildren().add(cell);
        getChildren().add(label);



    }

    public void changeCellValue(int x) {
        sudoku.currentKey.put(index, x);
        label.setText("" + x);
        if (sudoku.currentKey.get(index) != sudoku.answerKey.get(index)) {
            changeColor(4);
        } else {
            changeColor(3);
        }
    }

    public void changeColor(int x) {
        if (x == 0) {
            cell.setFill(Color.WHITE);
        } else if (x == 1) {
            cell.setFill(Color.LIGHTSTEELBLUE);
        } else if (x == 2) {
            cell.setFill(Color.LIGHTGREY);
        } else if (x == 3) {
            cell.setFill(Color.LIGHTGREEN);
        } else if (x == 4) {
            cell.setFill(Color.PALEVIOLETRED);
        }
    }
}
