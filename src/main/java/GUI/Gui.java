package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Gui {
	private static Gui instance = null;
	private GridPane stageGrid;
	private Button calculateButton;
	private Button showChartsButton;
	private Button showOutputDefuzzifierChartButton;
	private TextField weightField;
	private TextField amountOfDirtField;
	private TextField waterHardnessField;
	private TextField washingTimeField;

	private Gui() {
		this.stageGrid = new GridPane();
		//Labels
		Label weightLabel = new Label("Weight [kg]: ");
		Label amountOfDirtLabel = new Label("Amount of dirt on dishes [%]: ");
		Label waterHardnessLabel = new Label("Water hardness [dGH]: ");
		Label washingTimeLabel = new Label("Washing Time [min]: ");
		//TextFields
		weightField = new TextField();
		amountOfDirtField = new TextField();
		waterHardnessField = new TextField();
		washingTimeField = new TextField();
		//Buttons
		calculateButton = new Button("Calculate!");
		showChartsButton = new Button("Show input charts");
		showOutputDefuzzifierChartButton = new Button("Show output's defuzzifier chart");


		weightLabel.setPrefSize(200,30);
		amountOfDirtLabel.setPrefSize(200,30);
		waterHardnessLabel.setPrefSize(200,30);
		washingTimeLabel.setPrefSize(200,30);
		calculateButton.setPrefSize(300,30);
		showChartsButton.setPrefSize(300,30);
		showOutputDefuzzifierChartButton.setPrefSize(300,30);

		weightLabel.setAlignment(Pos.CENTER_RIGHT);
		amountOfDirtLabel.setAlignment(Pos.CENTER_RIGHT);
		waterHardnessLabel.setAlignment(Pos.CENTER_RIGHT);
		washingTimeLabel.setAlignment(Pos.CENTER_RIGHT);


		washingTimeField.setEditable(false);

		stageGrid.setPadding(new Insets(10));
		stageGrid.setHgap(10);
		stageGrid.setVgap(10);
		stageGrid.addColumn(0,weightLabel,amountOfDirtLabel,waterHardnessLabel, showChartsButton);
		stageGrid.addColumn(1,weightField,amountOfDirtField,waterHardnessField );
		stageGrid.addColumn(2,washingTimeLabel,calculateButton);
		stageGrid.addColumn(3,washingTimeField,showOutputDefuzzifierChartButton);


	}

	public Button getCalculateButton() {
		return calculateButton;
	}

	public Button getShowChartsButton() {
		return showChartsButton;
	}

	public Button getShowOutputDefuzzifierChartButton() {
		return showOutputDefuzzifierChartButton;
	}

	public static Gui getInstance(){
		if(instance == null) instance = new Gui();
		return instance;
	}

	public GridPane getStageGrid() {
		return stageGrid;
	}

	public TextField getWeightField() {
		return weightField;
	}

	public TextField getAmountOfDirtField() {
		return amountOfDirtField;
	}

	public TextField getWaterHardnessField() {
		return waterHardnessField;
	}

	public TextField getWashingTimeField() {
		return washingTimeField;
	}
}
