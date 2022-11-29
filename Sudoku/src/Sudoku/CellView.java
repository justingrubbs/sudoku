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


    public CellView(int y,  int x, double width, double height) {
        this.cell = new Rectangle(0, 0, width, height);
        this.label = new Label("" + sudoku.currentKey.get((9 * y) + (x + 1)));

        cell.setFill(Color.WHITE);
        cell.setStroke(Color.BLACK);

        cell.setTranslateX(x * width);
        cell.setTranslateY(y * height);
        label.setTranslateX(x * width + (width / 3));
        label.setTranslateY(y * height + (height / 3));
        label.setFont(new Font("Arial", 20));


        getChildren().add(cell);
        getChildren().add(label);



    }

    public void changeCellValue(int x) {

    }

    public void changeColor(int x) {
        if (x == 0) {
            cell.setFill(Color.WHITE);
        } else if (x == 1) {
            cell.setFill(Color.LIGHTSTEELBLUE);
        } else if (x == 2) {
            cell.setFill(Color.LIGHTGREY);
        }
    }
}
