package scenes;

import static whojavatestfx.Array.arrayToString;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import guiElements.GUIFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class allScenes {
	
    static int leftMargin = 50;
    static int sceneWidth = 600;
    static int sceneHeight = 500;
    
	public static void showFirstScene(int index, ArrayList<String> array,
            Stage primaryStage) {
        AtomicInteger innerIndex = new AtomicInteger(index);
        
        // Adding GUI elements to the scene
        Text text = GUIFactory.getElement("text", "Fill the array:", leftMargin, 50); 
        TextField textField = GUIFactory.getElement("textfield", "", leftMargin, 80);
        Text arrayTip = GUIFactory.getElement("text", "Current array:", leftMargin, 150);
        Text arrayText = GUIFactory.getElement("text", arrayToString(array), leftMargin, 190);
        arrayText.setWrappingWidth(515);
        Button btn = GUIFactory.getElement("button", "Add", leftMargin + 200, 80);
        Button finishButton = GUIFactory.getElement("button", "Finish", 400, 400);
        
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String item = textField.getText();
                if (!item.isEmpty()) {
                    array.add(innerIndex.get(), item);
                    arrayText.setText(arrayToString(array));
                    textField.clear();
                    innerIndex.incrementAndGet();
                }
            }
        }; 
        
        btn.setOnAction(event);
        textField.setOnAction(event);
        
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showSecondScene(array, primaryStage);
            }
        });
        
        Group newRoot = new Group(text, btn, textField, arrayTip, arrayText,finishButton);
        createScene(newRoot, primaryStage, "Creating the array");
    }
    
    public static void showSecondScene(ArrayList<String> array,
            Stage primaryStage) {
        
    	Text arrayTip = GUIFactory.getElement("text", "Current array:", leftMargin, 50);
    	Text arrayText = GUIFactory.getElement("text", arrayToString(array), leftMargin, 80);
        arrayText.setWrappingWidth(515);
    	Text confirmContinue = GUIFactory.getElement("text", "Do you want to insert another element?", 
    			leftMargin, 150);
        Button yesButton = GUIFactory.getElement("button", "Yes", leftMargin, 180);
        Button noButton = GUIFactory.getElement("button", "No", leftMargin + 100, 180);
        
        noButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showFinishScene(array, primaryStage);
            }
        });
        
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showThirdScene(array, primaryStage);
            }
        });
        
        Group newRoot = new Group(arrayTip, arrayText, confirmContinue, yesButton, noButton);
        createScene(newRoot, primaryStage, "Your current array:");
    }
    
    public static void showThirdScene(ArrayList<String> array,
            Stage primaryStage){

    	Text arrayTip = GUIFactory.getElement("text", "Current array:", leftMargin, 50);
    	Text arrayText = GUIFactory.getElement("text", arrayToString(array), leftMargin, 80);
    	
    	int maxIndex = getMaxIndex(array.size());
        
        String outputMessage = String.format("Choose the index between %d and %d: ", 0, maxIndex);

    	Text indexTip = GUIFactory.getElement("text", outputMessage, leftMargin, 150);
        
        TextField textField = GUIFactory.getElement("textfield", "", leftMargin, 180);
        
        Button btn = GUIFactory.getElement("button", "Input the element", leftMargin, 250);
    	Text warningText = GUIFactory.getElement("text", "", leftMargin, 300);
        warningText.setFill(Color.RED);
        
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String item = textField.getText();
                if (!item.isEmpty()) {
                	try {
	                    int index = Integer.parseInt(item);
	                    if ((index >= 0) && (index <= maxIndex)) {
	                        showFirstScene(index, array, primaryStage);
	                    } else {
	                        warningText.setText("Index is out of bounds");
	                    }
                	} catch (Exception e) {
                        warningText.setText("Index must be integer");
                	}
                }
            }
        }; 
        
        btn.setOnAction(event);
        textField.setOnAction(event);
        
        Group newRoot = new Group(arrayTip, arrayText, indexTip, textField, btn, warningText);
        createScene(newRoot, primaryStage, "Final array:");
    }
    
    public static void showFinishScene(ArrayList<String> array,
            Stage primaryStage) {
    	

    	Text arrayTip = GUIFactory.getElement("text", "Final array:", leftMargin, 50);
    	Text arrayText = GUIFactory.getElement("text", arrayToString(array), leftMargin, 80);
        arrayText.setWrappingWidth(515);
        Button tryAgainButton = GUIFactory.getElement("button", "Try again", leftMargin, 180);
        Button finishButton= GUIFactory.getElement("button", "Close", leftMargin + 100, 180);
        
        tryAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showFirstScene(0, new ArrayList<>(), primaryStage);
            }
        });
        
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();
            }
        });
        
        Group newRoot = new Group(arrayTip, arrayText, tryAgainButton, finishButton);
        createScene(newRoot, primaryStage, "Final array:");
    }
    
    private static int getMaxIndex(int arraySize) {
        if  (arraySize >= 1) {
            return arraySize - 1;
        } else {
            return 0;
        }
    }
    
    private static void createScene(Group group, Stage primaryStage, String title) {
    	
        Scene scene = new Scene(group, sceneWidth, sceneHeight);

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    	
    }
        
}
