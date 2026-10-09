/**
 * Name: Joshua Spencer
 * Course: CPT 237 - Advanced Java Programming
 * Section: W38
 * Semester: Fall 2026
 * 
 * Title:        Lab Program - File Dump (JavaFX Version)
 * Description:  This program converts the original Swing-based FileDumpExample 
 *               UI to JavaFX. It sets up the stage, layouts (BorderPane, VBox, 
 *               HBox, GridPane), menus, buttons, text areas, and event handler 
 *               stubs for the file dump utility.
 */

import java.io.File;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileDump extends Application {

    // Menu Components
    private Menu menuFile = new Menu("File");
    private MenuItem menuFileOpen = new MenuItem("Open");
    private MenuItem menuFileExit = new MenuItem("Exit");

    private Menu menuHelp = new Menu("Help");
    private MenuItem menuHelpAbout = new MenuItem("About");

    private MenuBar mb = new MenuBar();

    // North Panel (Top Layout)
    private HBox northPanel = new HBox();
    private Label fileName = new Label("No file currently open");
    private TitledPane fileTitledPane = new TitledPane("Open File:", fileName);

    // East Panel (Right Layout)
    private VBox eastPanel = new VBox(10);
    private Button up = new Button("Up");
    private Button down = new Button("Down");

    // South Panel (Bottom Layout)
    private HBox southPanel = new HBox(10);
    private Button resetButton = new Button("Reset");
    private Button exitButton = new Button("Exit");

    // Center Panel
    private BorderPane centerPanel = new BorderPane();
    private TextArea offsetArea = new TextArea();
    private TableView<Object> dataTable = new TableView<>();
    private TextArea asciiArea = new TextArea();

    // File handling fields
    private RandomAccessFile file = null;
    private int fileIndex;
    private int fileOffset;
    private File choosenFile;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Dump Utility");

        // Main Layout Container
        BorderPane root = new BorderPane();

        // -----------------------------------------------------------------
        // Event Handlers (Stubs - Logic to be added in future assignments)
        // -----------------------------------------------------------------
        menuFileOpen.setOnAction(e -> {
            // FILE OPEN CODE HERE
        });

        menuFileExit.setOnAction(e -> {
            // EXIT APPLICATION CODE HERE
            Platform.exit();
        });

        menuHelpAbout.setOnAction(e -> {
            // HELP MENU CODE HERE
        });

        up.setOnAction(e -> {
            // UP BUTTON CODE HERE
        });

        down.setOnAction(e -> {
            // DOWN BUTTON CODE HERE
        });

        resetButton.setOnAction(e -> {
            // RESET BUTTON CODE HERE
        });

        exitButton.setOnAction(e -> {
            // EXIT BUTTON CODE HERE
            Platform.exit();
        });

        // -----------------------------------------------------------------
        // Assembly of UI Components
        // -----------------------------------------------------------------

        // Menu Setup
        menuFile.getItems().addAll(menuFileOpen, menuFileExit);
        menuHelp.getItems().add(menuHelpAbout);
        mb.getMenus().addAll(menuFile, menuHelp);

        // North Panel Setup
        fileTitledPane.setCollapsible(false);
        fileTitledPane.setMaxWidth(Double.MAX_VALUE);
        northPanel.setPadding(new Insets(5));
        northPanel.getChildren().add(fileTitledPane);
        HBox.setHgrow(fileTitledPane, Priority.ALWAYS);

        // Top VBox holding MenuBar and Top Titled Pane
        VBox topContainer = new VBox();
        topContainer.getChildren().addAll(mb, northPanel);
        root.setTop(topContainer);

        // East Panel Setup
        eastPanel.setPadding(new Insets(10));
        eastPanel.setAlignment(Pos.TOP_CENTER);
        up.setPrefWidth(75);
        down.setPrefWidth(75);
        eastPanel.getChildren().addAll(up, down);
        root.setRight(eastPanel);

        // Center Panel Setup
        Font fixedFont = Font.font("Courier", 12);

        offsetArea.setEditable(false);
        offsetArea.setFont(fixedFont);
        offsetArea.setPrefColumnCount(6);
        offsetArea.setPrefRowCount(8);

        asciiArea.setEditable(false);
        asciiArea.setFont(fixedFont);
        asciiArea.setPrefColumnCount(18);
        asciiArea.setPrefRowCount(8);

        centerPanel.setLeft(offsetArea);
        centerPanel.setCenter(dataTable);
        centerPanel.setRight(asciiArea);
        root.setCenter(centerPanel);

        // South Panel Setup
        southPanel.setPadding(new Insets(10));
        southPanel.setAlignment(Pos.CENTER_RIGHT);
        southPanel.getChildren().addAll(resetButton, exitButton);
        root.setBottom(southPanel);

        // Disable controls until a file is opened
        up.setDisable(true);
        down.setDisable(true);
        resetButton.setDisable(true);

        // Scene Configuration
        Scene scene = new Scene(root, 620, 330);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayData() {
        // CODE TO DISPLAY DATA HERE
    }

    public static void main(String[] args) {
        launch(args);
    }
}