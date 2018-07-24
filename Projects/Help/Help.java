package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Help extends Application {

	static Scene scene;

	/**
	 * Creates the help window
	 */
	public static void help(Stage window) {

		ScrollPane pane = new ScrollPane();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Help");
		window.setHeight(500);
		window.setWidth(550);
		window.setMinWidth(250);

		Label lblHelpDef = label("Scroll Over Word For Its Definition", "helpTitle");



		// Uses the label method from LabelClass to create a label which starts out invisible
		Label lblRevisionDef = label("Revision number of test.", 40, 25, "");
		lblRevisionDef.setVisible(false);
		// Uses the label method from LabelClass to create a label. Has an action where you mouse over the label, it'll set the definition label visible
		Label lblRevision = label("Revision", 110, 25, "label", lblRevisionDef);

		Label lblDateDef = label("The date the test took place.", 40, 25, "");
		lblDateDef.setVisible(false);
		Label lblDate = label("Date", 110, 25, "label",lblDateDef);

		Label lblDescriptionDef = label("A brief description of the associated revision.", 40, 25, "");
		lblDescriptionDef.setVisible(false);
		Label lblDescription = label("Description", 110, 25, "label",lblDescriptionDef);



		Label lblScopeDef = label("Redirects to scope page.", 40, 25, "");
		lblScopeDef.setVisible(false);
		Label lblScope = label("Scope", 110, 25, "label",lblScopeDef);

		Label lblTermsNormsDef = label("Redirects to Terms/Norms page.", 40, 25, "");
		lblTermsNormsDef.setVisible(false);
		Label lblTermsNorms = label("Terms/Norms", 110, 25, "label",lblTermsNormsDef);

		Label lblControlVolumeDef = label("Redirects to Control Volume page.", 40, 25, "");
		lblControlVolumeDef.setVisible(false);
		Label lblControlVolume = label("Control Volume", 110, 25, "label",lblControlVolumeDef);
		Label lblSystemModelsDef = label("Redirects to System Models page.", 40, 25, "");
		lblSystemModelsDef.setVisible(false);
		Label lblSystemModels = label("System Models", 110, 25, "label",lblSystemModelsDef);

		Label lblInterfaceDef = label("Redirects to Interface page.", 40, 25, "");
		lblInterfaceDef.setVisible(false);
		Label lblInterface = label("Interface", 110, 25, "label",lblInterfaceDef);                

		Label lblDIPDef = label("Redirects to DIP page.", 40, 25, "");
		lblDIPDef.setVisible(false);
		Label lblDIP = label("DIP", 110, 25, "label",lblDIPDef);  
		Label lblDIFDef = label("Redirects to DIF page.", 40, 25, "");
		lblDIFDef.setVisible(false);
		Label lblDIF = label("DIF", 110, 25, "label",lblDIFDef);   

		Label lblDILDef = label("Redirects to DIL page.", 40, 25, "");
		lblDILDef.setVisible(false);
		Label lblDIL = label("DIL", 110, 25, "label",lblDILDef);                
		Label lblKPFsDef = label("Redirects to KPFs page.", 40, 25, "");
		lblKPFsDef.setVisible(false);
		Label lblKPFs = label("KPFs", 110, 25, "label",lblKPFsDef);                

		Label lblDIPVerificationDef = label("Redirects to DIP Verification page.", 40, 25, "");
		lblDIPVerificationDef.setVisible(false);
		Label lblDIPVerification = label("DIP Verification", 110, 25, "label",lblDIPVerificationDef);                

		Label lblDNAGeneratorDef = label("Redirects to DNA Generator page.", 40, 25, "");
		lblDNAGeneratorDef.setVisible(false);
		Label lblDNAGenerator = label("DNA Generator", 110, 25, "label",lblDNAGeneratorDef);                

		Label lblDNALibraryDef = label("Redirects to DNA Library page.", 40, 25, "");
		lblDNALibraryDef.setVisible(false);
		Label lblDNALibrary = label("DNA Library", 110, 25, "label",lblDNALibraryDef);                

		Label lblAddAFieldDef = label("Adds a new revision line.", 40, 25, "");
		lblAddAFieldDef.setVisible(false);
		Label lblAddAField = label("Add A New Revision and Unlock the Dashboard", 110, 25, "functionalButton",lblAddAFieldDef);                  


		Label lblCodeDef = label("The code to release the revision.", 40, 25, "");
		lblCodeDef.setVisible(false);
		Label lblCode = label("Code", 110, 25, "label",lblCodeDef);





		Label lblSavePDFDef = label("Save as PDF.", 40, 25, "");
		lblSavePDFDef.setVisible(false);
		Label lblSavePDF = label("Save as PDF", 110, 25, "functionalButton",lblSavePDFDef);


		Label lblReleaseDef = label("Releases the revision.", 40, 25, "");
		lblReleaseDef.setVisible(false);

		Label lblRelease = label("Release", 110, 25, "functionalButton",lblReleaseDef);


		/**
		 * Print directs to separate print class
		 */

		Label lblPrintDef = label("Print the current page", 40, 25, "");
		lblPrintDef.setVisible(false);

		Label lblPrint = label("Print", 110, 25, "functionalButton",lblPrintDef);

		/**
		 * Directs to DNA Plot page
		 */

		Label lblDashboardDef = label("Redirects to the dashboard page.", 40, 25, "");
		lblDashboardDef.setVisible(false);
		Label lblDashboard = label("Dashboard", 110, 25, "functionalButton",lblDashboardDef);


		BorderPane layout = new BorderPane();

		HBox title = new HBox();
		title.setPadding(new Insets(15, 12, 15, 12));
		title.getChildren().add(lblHelpDef);
		layout.setTop(title);

		VBox words = new VBox();
		words.setPadding(new Insets(10));
		words.setSpacing(10);
		words.getChildren().addAll(lblRevision, lblDate, lblScope, lblTermsNorms, lblControlVolume, lblSystemModels,lblInterface, lblDIP, lblDIF, lblDIL, lblKPFs, lblDIPVerification, lblDNAGenerator, lblDNALibrary,lblDescription, lblCode, lblAddAField, lblSavePDF, lblRelease, lblPrint, lblDashboard);
		layout.setLeft(words);

		VBox definitions = new VBox();
		definitions.setPadding(new Insets(10.5));
		definitions.setSpacing(10);
		definitions.getChildren().addAll(lblRevisionDef, lblDateDef, lblScopeDef,lblTermsNormsDef, lblControlVolumeDef, lblSystemModelsDef, lblInterfaceDef, lblDIPDef, lblDIFDef, lblDILDef, lblKPFsDef, lblDIPVerificationDef, lblDNAGeneratorDef, lblDNALibraryDef,lblDescriptionDef, lblCodeDef, lblAddAFieldDef, lblSavePDFDef, lblReleaseDef, lblPrintDef, lblDashboardDef);
		layout.setCenter(definitions);


		pane.setContent(layout);


		Scene scene = new Scene(pane);
		//scene.getStylesheets().add(DSP.css);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();

	} //end help


	/**
	 * 
	 * @param text The text on the label.
	 * @param boxWidth The width of the label
	 * @param boxHeight The height of the label
	 * @param style The style used for this certain label
	 * @param def The definition of the label
	 * @return Returns a label
	 */
	public static Label label(String text, int boxWidth, int boxHeight, String style, Label def) {
		DropShadow shadowDrop = new DropShadow();
		Label label1 = new Label();
		label1.setText(text);
		label1.setAlignment(Pos.CENTER);
		label1.setMinWidth(boxWidth);
		label1.setMinHeight(boxHeight);
		label1.setId(style);
		/**
		 * On and off mouse definition functionality
		 */
		label1.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			def.setVisible(true);
			label1.setEffect(shadowDrop);
		});
		label1.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			def.setVisible(false);
			label1.setEffect(null);
		});        
		return label1;
	}

	/**
	 * 
	 * @param text The text on the label.
	 * @param boxWidth The width of the label
	 * @param boxHeight The height of the label
	 * @param style The style used for this certain label
	 * @return Returns a label
	 */
	public static Label label(String text, int boxWidth, int boxHeight, String style) {

		Label label1 = new Label();
		label1.setText(text);
		label1.setAlignment(Pos.CENTER);
		label1.setMinWidth(boxWidth);
		label1.setMinHeight(boxHeight);
		label1.setId(style);

		return label1;
	}
	/**
	 * 
	 * @param text The text on the label.
	 * @param style The style used for this certain label
	 * @return Returns a label
	 */
	public static Label label(String text, String style) {

		Label label1 = new Label();
		label1.setText(text);
		label1.setAlignment(Pos.CENTER);
		label1.setId(style);

		return label1;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		help(primaryStage);
	}

}
