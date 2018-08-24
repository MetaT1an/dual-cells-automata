package Control;

import javafx.scene.paint.Color;
import model.Cell;
import model.Cow;
import model.Grids;
import view.CellsPane;

public class CellPaneControl {

    private CellPaneControl(){ }

    private static Grids grids= Grids.getGrids();
    private static CellsPane cellsPane = CellsPane.getCellsPane();

    public static void draw(){
        int i, j;
        Cell cell;
        for(i = 0; i < Grids.N; ++i){
            for(j = 0; j < Grids.N; ++j) {
                cell = grids.getCell(i, j);
                if (cell.isDie()) {
                    cellsPane.getGc().setFill(Color.WHITE);
                } else if (cell instanceof Cow){
                    cellsPane.getGc().setFill(Color.rgb(36, 36, 36));
                } else {
                    cellsPane.getGc().setFill(Color.rgb(0, 200, 0));
                }
                drawOneCell(i, j);
            }
        }
    }

    private static void drawOneCell(int i, int j){
        double x = i*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
        double y = j*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
        cellsPane.getGc().fillRect(x, y, CellsPane.CELL_SIZE, CellsPane.CELL_SIZE);
    }
}
