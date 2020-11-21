package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.swing.text.Position;

public class Gui {
	private static Gui instance = null;
	private GridPane stageGrid;

	private Gui() {
		this.stageGrid = new GridPane();
		//Labels
		Label weightLabel = new Label("Weight [kg]: ");
		Label amountOfDirtLabel = new Label("Amount of dirt on dishes [%]: ");
		Label waterHardnessLabel = new Label("Water hardness [dGH]: ");
		Label washingTimeLabel = new Label("Washing Time [min]: ");
		//TextFields
		TextField weightField = new TextField();
		TextField amountOfDirtField = new TextField();
		TextField waterHardnessField = new TextField();
		TextField washingTimeField = new TextField();

		Button calculateButton = new Button("Calculate!");

		weightLabel.setPrefSize(200,30);
		amountOfDirtLabel.setPrefSize(200,30);
		waterHardnessLabel.setPrefSize(200,30);
		washingTimeLabel.setPrefSize(200,30);

		weightLabel.setAlignment(Pos.CENTER_RIGHT);
		amountOfDirtLabel.setAlignment(Pos.CENTER_RIGHT);
		waterHardnessLabel.setAlignment(Pos.CENTER_RIGHT);
		washingTimeLabel.setAlignment(Pos.CENTER_RIGHT);


		washingTimeField.setEditable(false);

		stageGrid.setPadding(new Insets(10));
		stageGrid.setHgap(10);
		stageGrid.setVgap(10);
		stageGrid.addColumn(0,weightLabel,amountOfDirtLabel,waterHardnessLabel);
		stageGrid.addColumn(1,weightField,amountOfDirtField,waterHardnessField);
		stageGrid.addColumn(2,washingTimeLabel);
		stageGrid.addColumn(3,washingTimeField,calculateButton);


	}

	public static Gui getInstance(){
		if(instance == null) instance = new Gui();
		return instance;
	}

	public GridPane getStageGrid() {
		return stageGrid;
	}
}
