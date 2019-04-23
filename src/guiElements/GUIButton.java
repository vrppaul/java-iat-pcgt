package guiElements;
import javafx.scene.control.Button;

public class GUIButton implements GUIElement<Button> {

	private String text;
	private int leftMargin;
	private int topMargin;
	private Button buttonInstance;
	
	GUIButton(String text, int leftMargin, int topMargin) {

		this.text = text;
		this.leftMargin = leftMargin;
		this.topMargin = topMargin;
		this.buttonInstance = new Button();
		
		this.setInstance(this.text, this.leftMargin, this.topMargin);
		
	}

	@Override
	public void setInstance(String text, int leftMargin, int topMargin) {

		this.buttonInstance.setText(text);
		this.buttonInstance.setLayoutX(leftMargin);
		this.buttonInstance.setLayoutY(topMargin);
		
	}

	@Override
	public Button getInstance() {
		
		return this.buttonInstance;
		
	}

}
