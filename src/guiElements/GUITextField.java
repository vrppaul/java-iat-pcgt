package guiElements;
import javafx.scene.control.TextField;

public class GUITextField implements GUIElement<TextField> {

	private String text;
	private int leftMargin;
	private int topMargin;
	private TextField textFieldInstance;

	GUITextField(String text, int leftMargin, int topMargin) {
		
		this.text = text;
		this.leftMargin = leftMargin;
		this.topMargin = topMargin;
		this.textFieldInstance = new TextField();
		
		this.setInstance(this.text, this.leftMargin, this.topMargin);
		
	}
	
	@Override
	public void setInstance(String text, int leftMargin, int topMargin) {
		
		this.textFieldInstance.setText(text);
		this.textFieldInstance.setLayoutX(leftMargin);
		this.textFieldInstance.setLayoutY(topMargin);
		
	}

	@Override
	public TextField getInstance() {
		
		return this.textFieldInstance;
		
	}

}
