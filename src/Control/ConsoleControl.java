package Control;

import model.Grids;
import view.ConsolePane;

public class ConsoleControl {
    private ConsoleControl(){}

    private static Grids grids = Grids.getGrids();
    private static ConsolePane consolePane = ConsolePane.getConsolePane();

    public static void addControlEvents(){

        // confirm/reload button
        consolePane.getButtons(0).setOnAction(event -> {

            // update parameters
            Grids.resetArgs(getSaForCow(), getCaForCow(), getRaForCow(), getRaForGrass());

            // update model part
            grids.resetCells();

            // update view part
            CellPaneControl.draw();
        });
    }

    // survival ability
    private static int getSaForCow(){
        String selection = consolePane.getSurvivalLevelBox().getValue();
        int res = 2;
        if("level 0".equals(selection)){
            res = 2;
        } else if("level 1".equals(selection)){
            res = 1;
        } else if("level 2".equals(selection)){
            res = 0;
        }
        return res;
    }

    // Consumption ability
    private static int getCaForCow(){
        String selection = consolePane.getConsumptionLevelBox().getValue();
        int res = 4;
        if("level 0".equals(selection)){
            res = 4;
        } else if("level 1".equals(selection)){
            res = 2;
        } else if("level 2".equals(selection)){
            res = 1;
        }
        return res;
    }

    // Reproductive ability of cows
    private static int getRaForCow(){
        String selection = consolePane.getReproductiveLevelBox().getValue();
        int res = 4;
        if("level 0".equals(selection)){
            res = 4;
        } else if("level 1".equals(selection)){
            res = 2;
        } else if("level 2".equals(selection)){
            res = 1;
        }
        return res;
    }

    // Reproductive ability of grass
    private static int getRaForGrass(){
        String selection = consolePane.getReproductiveLevelBox2().getValue();
        int res = 4;
        if("level 0".equals(selection)){
            res = 4;
        } else if("level 1".equals(selection)){
            res = 3;
        } else if("level 2".equals(selection)){
            res = 1;
        }
        return res;
    }
}
