package guiElements;

public interface GUIElement<T> {
	
	void setInstance(String text, int leftMargin, int topMargin);
	T getInstance();
	
}
