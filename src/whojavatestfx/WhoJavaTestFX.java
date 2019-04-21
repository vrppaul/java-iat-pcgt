/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whojavatestfx;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import guiElements.GUIFactory;

import static whojavatestfx.Array.arrayToString;

/**
 *
 * @author MSI-PC
 */
public class WhoJavaTestFX extends Application {
    int leftMargin = 50;
    int sceneWidth = 600;
    int sceneHeight = 500;
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<String> array = new ArrayList<>();
        Scene scene = firstScene(array.size(), array, primaryStage);
        
        primaryStage.setTitle("Creating the array");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Scene firstScene(int index, ArrayList<String> array,
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
                Scene secondScene = secondScene(array, primaryStage);
                
                primaryStage.setTitle("Your current array");
                primaryStage.setScene(secondScene);
                primaryStage.show();
            }
        });
        
        Group root = new Group(text, btn, textField, arrayTip, arrayText,finishButton);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        
        return scene;
    }
    
    public Scene secondScene(ArrayList<String> array,
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
                Scene finishScene = finishScene(array, primaryStage);
                
                primaryStage.setTitle("Final array");
                primaryStage.setScene(finishScene);
                primaryStage.show();
            }
        });
        
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Scene thirdScene = thirdScene(array, primaryStage);
                
                primaryStage.setTitle("Final array");
                primaryStage.setScene(thirdScene);
                primaryStage.show();
            }
        });
        
        Group newRoot = new Group(arrayTip, arrayText, confirmContinue, yesButton, noButton);
        Scene secondScene = new Scene(newRoot, sceneWidth, sceneHeight);
        
        return secondScene;
    }
    
    public Scene thirdScene(ArrayList<String> array,
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
	                        Scene scene = firstScene(index, array, primaryStage);
	
	                        primaryStage.setTitle("Creating the array");
	                        primaryStage.setScene(scene);
	                        primaryStage.show();
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
        Scene thirdScene = new Scene(newRoot, sceneWidth, sceneHeight);
        
        return thirdScene;
    }
    
    public Scene finishScene(ArrayList<String> array,
            Stage primaryStage) {
    	

    	Text arrayTip = GUIFactory.getElement("text", "Final array:", leftMargin, 50);
    	Text arrayText = GUIFactory.getElement("text", arrayToString(array), leftMargin, 80);
        arrayText.setWrappingWidth(515);
        Button tryAgainButton = GUIFactory.getElement("button", "Try again", leftMargin, 180);
        Button finishButton= GUIFactory.getElement("button", "Close", leftMargin + 100, 180);
        
        tryAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Scene firstScene = firstScene(0, new ArrayList<>(), primaryStage);
                
                primaryStage.setTitle("Creating the array");
                primaryStage.setScene(firstScene);
                primaryStage.show();
            }
        });
        
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();
            }
        });
        
        Group newRoot = new Group(arrayTip, arrayText, tryAgainButton, finishButton);
        Scene finishScene = new Scene(newRoot, sceneWidth, sceneHeight);
        
        return finishScene;
    }
    
    private int getMaxIndex(int arraySize) {
        if  (arraySize >= 1) {
            return arraySize - 1;
        } else {
            return 0;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
