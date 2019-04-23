/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whojavatestfx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import scenes.allScenes;

/**
 *
 * @author MSI-PC
 */
public class WhoJavaTestFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<String> array = new ArrayList<>();
        allScenes.showFirstScene(array.size(), array, primaryStage);
    	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
