package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class ConsolePane {
    private VBox vBox;
    private HBox[] hBox;
    private Label[] labels;
    private ComboBox<String> survivalLevelBox;
    private ComboBox<String> consumptionLevelBox;
    private ComboBox<String> reproductiveLevelBox;
    private ComboBox<String> reproductiveLevelBox2;
    private ArrayList<String> survivalLevels;
    private ArrayList<String> consumptionLevels;
    private ArrayList<String> reproductiveLevels;
    private ArrayList<String> reproductiveLevels2;
    private Button[] buttons;
    private Rectangle cow;
    private Rectangle grass;
    private Label[] names;
    private Rectangle[] icons;

    private ConsolePane(){
        int i;

        vBox = new VBox(30);
        hBox = new HBox[5];
        hBox[0] = new HBox(67);
        hBox[1] = new HBox(20);
        hBox[2] = new HBox(20);
        hBox[3] = new HBox(12);
        hBox[4] = new HBox(20);

        labels = new Label[4];
        names = new Label[2];
        for(i = 0; i < 4; ++i)
            labels[i] = new Label();

        for(i = 0; i < 2; ++i)
            names[i] = new Label();

        survivalLevelBox = new ComboBox<>();
        consumptionLevelBox = new ComboBox<>();
        reproductiveLevelBox = new ComboBox<>();
        reproductiveLevelBox2 = new ComboBox<>();

        survivalLevels = new ArrayList<>();
        consumptionLevels = new ArrayList<>();
        reproductiveLevels = new ArrayList<>();
        reproductiveLevels2 = new ArrayList<>();

        buttons = new Button[3];
        for(i = 0; i < 3; ++i)
            buttons[i] = new Button();

        cow = new Rectangle(40, 40, Color.BLACK);
        grass = new Rectangle(40, 40, Color.rgb(0, 200,0));

        icons = new Rectangle[4];
        for(i = 0; i < 4; ++i)
            icons[i] = new Rectangle(20, 20, Color.BLACK);
        icons[3] = new Rectangle(20, 20, Color.rgb(0, 200, 0));

        setModule();
        loadModule();
    }

    private static ConsolePane consolePane = null;

    public static ConsolePane getConsolePane(){
        if(consolePane == null)
            consolePane = new ConsolePane();
        return consolePane;
    }

    public VBox getvBox() {
        return vBox;
    }

    public ComboBox<String> getSurvivalLevelBox() {
        return survivalLevelBox;
    }

    public ComboBox<String> getConsumptionLevelBox() {
        return consumptionLevelBox;
    }

    public ComboBox<String> getReproductiveLevelBox() {
        return reproductiveLevelBox;
    }

    public ComboBox<String> getReproductiveLevelBox2() {
        return reproductiveLevelBox2;
    }

    public Button getButtons(int i) {
        return buttons[i];
    }

    private void setModule(){
        int i;

        for(i = 0; i < 4; ++i)
            labels[i].setFont(Font.font(18));

        for(i = 0; i < 2; ++i)
            names[i].setFont(Font.font(18));

        labels[0].setText("Survival ability:");
        labels[1].setText("Consumption ability:");
        labels[2].setText("Reproductive ability:");
        labels[3].setText("Reproductive ability:");

        names[0].setText("Cow");
        names[1].setText("Grass");

        survivalLevelBox.setPrefSize(120, 30);
        consumptionLevelBox.setPrefSize(120, 30);
        reproductiveLevelBox.setPrefSize(120, 30);
        reproductiveLevelBox2.setPrefSize(120, 30);

        survivalLevelBox.setCursor(Cursor.HAND);
        consumptionLevelBox.setCursor(Cursor.HAND);
        reproductiveLevelBox.setCursor(Cursor.HAND);
        reproductiveLevelBox2.setCursor(Cursor.HAND);

        survivalLevels.add("level 0");
        survivalLevels.add("level 1");
        survivalLevels.add("level 2");

        consumptionLevels.add("level 0");
        consumptionLevels.add("level 1");
        consumptionLevels.add("level 2");

        reproductiveLevels.add("level 0");
        reproductiveLevels.add("level 1");
        reproductiveLevels.add("level 2");

        reproductiveLevels2.add("level 0");
        reproductiveLevels2.add("level 1");
        reproductiveLevels2.add("level 2");

        survivalLevelBox.getItems().addAll(survivalLevels);
        consumptionLevelBox.getItems().addAll(consumptionLevels);
        reproductiveLevelBox.getItems().addAll(reproductiveLevels);
        reproductiveLevelBox2.getItems().addAll(reproductiveLevels2);
        survivalLevelBox.setValue("level 0");
        consumptionLevelBox.setValue("level 0");
        reproductiveLevelBox.setValue("level 0");
        reproductiveLevelBox2.setValue("level 0");

        buttons[0].setText("Confirm/Reload");
        buttons[1].setText("Pause");
        buttons[2].setText("Run");

        for(i = 0; i < 3; ++i){
            buttons[i].setPrefSize(328, 48);
            buttons[i].setFont(Font.font(18));
            buttons[i].setCursor(Cursor.HAND);
        }

        cow.setArcHeight(10);
        cow.setArcWidth(10);
        grass.setArcWidth(10);
        grass.setArcHeight(10);

        for(i = 0; i < 3; ++i){
            icons[i].setArcHeight(4);
            icons[i].setArcWidth(4);
        }

    }

    private void loadModule(){
        hBox[3].getChildren().addAll(cow, names[0], grass, names[1]);
        hBox[0].getChildren().addAll(icons[0], labels[0], survivalLevelBox);
        hBox[1].getChildren().addAll(icons[1], labels[1], consumptionLevelBox);
        hBox[2].getChildren().addAll(icons[2], labels[2], reproductiveLevelBox);
        hBox[4].getChildren().addAll(icons[3], labels[3], reproductiveLevelBox2);

        vBox.getChildren().addAll(hBox[3], hBox[0], hBox[1], hBox[2], hBox[4], buttons[0], buttons[1], buttons[2]);

        for(int i = 0; i < 3; ++i)
            hBox[i].setAlignment(Pos.CENTER_LEFT);
        hBox[3].setAlignment(Pos.CENTER_RIGHT);
        vBox.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(hBox[3], new Insets(0, 0, 20, 0));
        VBox.setMargin(buttons[0], new Insets(0, 0, 0, 20));
        VBox.setMargin(buttons[1], new Insets(0, 0, 0, 20));
        VBox.setMargin(buttons[2], new Insets(0, 0, 0, 20));

        HBox.setMargin(icons[0], new Insets(0, -46, 0, 0));
        HBox.setMargin(names[0], new Insets(0, 58, 0, 0));
    }
}
