package Control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Grids;
import view.ConsolePane;

public class AnimationControl {

    private AnimationControl(){}

    private static Grids grids = Grids.getGrids();
    private static ConsolePane consolePane = ConsolePane.getConsolePane();

    public static void addAnimation(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            grids.scan();
            CellPaneControl.draw();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        consolePane.getButtons(1).setOnAction(event -> timeline.pause());
        consolePane.getButtons(2).setOnAction(event -> timeline.play());
    }
}
