package guiElements;
import javafx.scene.text.Text;

public class GUIText implements GUIElement<Text> {
	
	private String text;
	private int leftMargin;
	private int topMargin;
	private Text textInstance;

	GUIText(String text, int leftMargin, int topMargin) {
		
		this.text = text;
		this.leftMargin = leftMargin;
		this.topMargin = topMargin;
		this.textInstance = new Text();
		
		this.setInstance(this.text, this.leftMargin, this.topMargin);
		
	}

	@Override
	public void setInstance(String text, int leftMargin, int topMargin) {
		
		this.textInstance.setText(text);
		this.textInstance.setX(leftMargin);
		this.textInstance.setY(topMargin);
		
	}

	@Override
	public Text getInstance() {
		
		return this.textInstance;
		
	}

}
