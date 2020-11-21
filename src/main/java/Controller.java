import GUI.Gui;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.text.ParseException;
import java.util.regex.Pattern;

class Controller {
	private static Gui gui;
	private GridPane stageGrid;
	private FunctionBlock functionBlock;
	private Variable washingTime;

	Controller() {
		gui = Gui.getInstance();
		this.stageGrid = gui.getStageGrid();
		this.functionBlock = loadFis();
		gui.getCalculateButton().setOnAction(event -> calculateWashingTime());
		gui.getShowChartsButton().setOnAction(event -> JFuzzyChart.get().chart(functionBlock));
		gui.getShowOutputDefuzzifierChartButton().setOnAction(event -> showWashingTimeChart());
	}

	private FunctionBlock loadFis(){
		String filename = "dishwasher.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}
		return fis.getFunctionBlock(null);

	}

	private void showWashingTimeChart() {
		calculateWashingTime();
		JFuzzyChart.get().chart(washingTime, washingTime.getDefuzzifier(), true);
	}

	private void calculateWashingTime() {
		getInput();
		functionBlock.evaluate();
		washingTime = functionBlock.getVariable("washingTime");
		gui.getWashingTimeField().setText(String.valueOf(washingTime.getValue()));
	}

	private void getInput() {
		String weightStr = gui.getWeightField().getText();
		String amountOfDirtStr = gui.getAmountOfDirtField().getText();
		String waterHardnessStr = gui.getWaterHardnessField().getText();
		double weight, amountOfDirt, waterHardness;
		try{
			weight =Double.parseDouble(weightStr);
			amountOfDirt =Double.parseDouble(amountOfDirtStr);
			waterHardness =Double.parseDouble(waterHardnessStr);
			functionBlock.setVariable("weight", weight);
			functionBlock.setVariable("amountOfDirt", amountOfDirt);
			functionBlock.setVariable("waterHardness", waterHardness);
		}
		catch (NumberFormatException e){
			Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
			alert.showAndWait();
		}


	}

	GridPane getStageGrid() {
		return stageGrid;
	}
}
