package guiElements;

public class GUIFactory {
	//use getElement method to get object of type GUIElement
	@SuppressWarnings("unchecked")
	public static <T> T getElement(String type, String text, int leftMargin, int topMargin) {
		if (type.equalsIgnoreCase("text")) {
			return (T) new GUIText(text, leftMargin, topMargin).getInstance();
		} else if (type.equalsIgnoreCase("textfield")) {
			return (T) new GUITextField(text, leftMargin, topMargin).getInstance();
		} else if (type.equalsIgnoreCase("button")) {
			return (T) new GUIButton(text, leftMargin, topMargin).getInstance();
		} else {
			return null;
		}
	}
}
