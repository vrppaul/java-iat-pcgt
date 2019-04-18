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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import whojavatestfx.Array.*;
import static whojavatestfx.Array.arrayToString;

/**
 *
 * @author MSI-PC
 */
public class WhoJavaTestFX extends Application {
    int leftMargin = 50;
    
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
        Text text = new Text("Fill the array:");
        //setting the position of the text 
        text.setX(leftMargin); 
        text.setY(50); 
        
        TextField textField = new TextField();
        
        //Setting the position of the text field 
        textField.setLayoutX(leftMargin); 
        textField.setLayoutY(80);
        
        Text arrayTip = new Text("Current array:");
        //setting the position of the text 
        arrayTip.setX(leftMargin); 
        arrayTip.setY(150); 
        
        Text arrayText = new Text(arrayToString(array));
        //setting the position of the text 
        arrayText.setX(leftMargin); 
        arrayText.setY(190); 
        arrayText.setWrappingWidth(500);
        
        Button btn = new Button();
        btn.setText("Add");
        // setting the position of the button
        btn.setLayoutX(leftMargin + textField.getWidth() + 200);
        btn.setLayoutY(80);
        
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
        
        Button finishButton = new Button();
        finishButton.setText("Finish");
        // setting the position of the button
        finishButton.setLayoutX(400);
        finishButton.setLayoutY(400);
        
        Group root = new Group(text, btn, textField, arrayTip, arrayText,
        finishButton);
        
        Scene scene = new Scene(root, 600, 500);
        
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Scene secondScene = secondScene(array, primaryStage);
                
                primaryStage.setTitle("Your current array");
                primaryStage.setScene(secondScene);
                primaryStage.show();
            }
        });
        
        return scene;
    }
    
    public Scene secondScene(ArrayList<String> array,
            Stage primaryStage) {
        
        Text arrayTip = new Text("Current array:");
        //setting the position of the text 
        arrayTip.setX(leftMargin); 
        arrayTip.setY(50); 
        
        Text arrayText = new Text(arrayToString(array));
        //setting the position of the text 
        arrayText.setX(leftMargin); 
        arrayText.setY(80); 
        
        Text confirmContinue = new Text("Do you want to insert another element?");
        //setting the position of the text 
        confirmContinue.setX(leftMargin); 
        confirmContinue.setY(150);
        
        Button yesButton = new Button();
        yesButton.setText("Yes");
        // setting the position of the button
        yesButton.setLayoutX(leftMargin);
        yesButton.setLayoutY(180);
        
        Button noButton = new Button();
        noButton.setText("No");
        // setting the position of the button
        noButton.setLayoutX(leftMargin + 100);
        noButton.setLayoutY(180);
        
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
        
        Group newRoot = new Group(arrayTip, arrayText, confirmContinue,
        yesButton, noButton);
        Scene secondScene = new Scene(newRoot, 600, 500);
        
        return secondScene;
    }
    
    public Scene finishScene(ArrayList<String> array,
            Stage primaryStage) {
        Text arrayTip = new Text("Final array:");
        //setting the position of the text 
        arrayTip.setX(leftMargin); 
        arrayTip.setY(50); 
        
        Text arrayText = new Text(arrayToString(array));
        //setting the position of the text 
        arrayText.setX(leftMargin); 
        arrayText.setY(80); 
        
        Button tryAgainButton = new Button();
        tryAgainButton.setText("Try again");
        // setting the position of the button
        tryAgainButton.setLayoutX(leftMargin);
        tryAgainButton.setLayoutY(180);
        
        tryAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Scene firstScene = firstScene(0, new ArrayList<>(), primaryStage);
                
                primaryStage.setTitle("Creating the array");
                primaryStage.setScene(firstScene);
                primaryStage.show();
            }
        });
        
        Button finishButton = new Button();
        finishButton.setText("Close");
        // setting the position of the button
        finishButton.setLayoutX(leftMargin + 100);
        finishButton.setLayoutY(180);
        
        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();
            }
        });
        
        Group newRoot = new Group(arrayTip, arrayText, tryAgainButton, finishButton);
        Scene finishScene = new Scene(newRoot, 600, 500);
        
        return finishScene;
    }
    public Scene thirdScene(ArrayList<String> array,
            Stage primaryStage){
        Text arrayTip = new Text("Current array:");
        //setting the position of the text 
        arrayTip.setX(leftMargin); 
        arrayTip.setY(50); 
        
        Text arrayText = new Text(arrayToString(array));
        //setting the position of the text 
        arrayText.setX(leftMargin); 
        arrayText.setY(80); 
        
        int maxIndex;
        if  (array.size()-1 >=0) {
            maxIndex = array.size()-1;
        } else {
            maxIndex = 0;
        }
        String outputMessage = String.format("Choose the index between %d and %d: ", 0, maxIndex);
        Text indexTip = new Text(outputMessage);
        //setting the position of the text 
        indexTip.setX(leftMargin); 
        indexTip.setY(150); 
        
        Text indexText = new Text(arrayToString(array));
        //setting the position of the text 
        indexText.setX(leftMargin); 
        indexText.setY(180); 
        
        Text warningText = new Text("");
        //setting the position of the text 
        warningText.setX(leftMargin); 
        warningText.setY(300);
        warningText.setFill(Color.RED);
        
        TextField textField = new TextField();
        
        //Setting the position of the text field 
        textField.setLayoutX(leftMargin); 
        textField.setLayoutY(180);
        
        Button btn = new Button();
        btn.setText("Input the element");
        // setting the position of the button
        btn.setLayoutX(leftMargin);
        btn.setLayoutY(250);
        
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String item = textField.getText();
                if (!item.isEmpty()) {
                    int index = Integer.parseInt(item);
                    if ((index >= 0) && (index <= maxIndex)) {
                        Scene scene = firstScene(index, array, primaryStage);

                        primaryStage.setTitle("Creating the array");
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } else {
                        warningText.setText("Index is out of bounds");
                    }
                }
            }
        }; 
        
        btn.setOnAction(event);
        textField.setOnAction(event);
        
        Group newRoot = new Group(arrayTip, arrayText, indexTip, textField, btn, warningText);
        Scene thirdScene = new Scene(newRoot, 600, 500);
        
        return thirdScene;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
