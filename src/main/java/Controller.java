import GUI.Gui;
import javafx.scene.layout.GridPane;

class Controller {
	private static Gui gui;
	private GridPane stageGrid;

	Controller() {
		gui = Gui.getInstance();
		this.stageGrid = gui.getStageGrid();

	}

	GridPane getStageGrid() {
		return stageGrid;
	}
}
