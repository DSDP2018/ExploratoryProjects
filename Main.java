package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Main extends Application {
	
	static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	
    static int screenWidth = (int) primaryScreenBounds.getWidth();
    static int screenHeight = (int) primaryScreenBounds.getHeight();
    static int fieldWidthAlignment = screenWidth/45;
    static int proportionalHeight = screenHeight/10;
    static double proportionalWidth = screenWidth/16;
	
	@Override
	public void start(Stage stage) {
		
		Group root = new Group();
		
        int screenProportionHeightby25 = screenHeight/25;   

        Line line11 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenProportionHeightby25,screenHeight-80);

        Line line2 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenProportionHeightby25+40);     

        Line line3 = LineBlackNoFill(screenWidth-screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenHeight-80);
       
        Line line = LineBlackNoFill(screenWidth-screenProportionHeightby25, screenHeight-80, screenProportionHeightby25, screenHeight-80);

        root.getChildren().addAll(line11,line2,line3,line);
		
        Label lblSTDConfig = label("STD Config", 175, 15, 60, 30, "windows7", "The Current Menu");

        Label lblProjectID = label("123456789012345678901234567890", 250, 15, proportionalWidth*6, 30, "lion", "Project ID");

        Label lblRevisionNum = label("R1", 75, 15, proportionalWidth*10, 30, "otherBorder", "Revision Number");

        Label lblDateBorder = label("YY-MM-DD", 75, 15, proportionalWidth*12, 30, "otherBorder", "Current Date");

        Label lblPageNum = label("Page 1 of 1", 75, 15, proportionalWidth*14, 30, "otherBorder", "Page Number");
		
        root.getChildren().addAll(lblSTDConfig, lblProjectID, lblRevisionNum, lblDateBorder, lblPageNum);
        
		Scene scene = new Scene(root);
		
    	stage.setX(primaryScreenBounds.getMinX());
    	stage.setY(primaryScreenBounds.getMinY());
    	stage.setWidth(primaryScreenBounds.getWidth());
    	stage.setHeight(primaryScreenBounds.getHeight());
    	
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
    public static Line LineBlackNoFill(double x1, int y1, double x2, int y2) {

        Line line = new Line(x1, y1, x2, y2); 
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1.0); 
        line.getStrokeDashArray().addAll(10.0,0.0,10.0,0.0);

        return line;
    }
    
    public static Label label(String text, int boxWidth, int boxHeight, double x, double y, String style, String tip) {
        
        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(boxWidth);
        label1.setMinHeight(boxHeight);
        label1.setLayoutX(x);
        label1.setLayoutY(y);
        label1.setId(style);
        label1.setTooltip(new Tooltip(tip));
                
        return label1;
    }
}
