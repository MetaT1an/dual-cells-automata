package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application{
    public void start(Stage stage){

        // get integral parts
        BorderPane borderPane = new BorderPane();
        CellsPane cellsPane = CellsPane.getCellsPane();
        ConsolePane consolePane = ConsolePane.getConsolePane();

        // setting layout
        borderPane.setCenter(cellsPane.getCanvas());
        borderPane.setRight(consolePane.getvBox());
        BorderPane.setMargin(borderPane.getRight(), new Insets(0, 20, 0, 0));

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Dual Cells Version");

        // run
        stage.show();
    }
}
