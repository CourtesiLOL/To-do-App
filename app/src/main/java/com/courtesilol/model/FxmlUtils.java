/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.courtesilol.model;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class FxmlUtils {
    
    private FxmlUtils() {
    }
    
    public static FxmlUtils getInstance() {
        return FxmlUtilsHolder.INSTANCE;
    }
    
    private static class FxmlUtilsHolder {
        
        private static final FxmlUtils INSTANCE = new FxmlUtils();
    }
    
    public Optional<Scene> getView(String fileUrl) {
        
        Optional<Scene> scene = Optional.empty();
        
        try {
            //Obtien la URL de la carpeta Resource y obtiene el fxml mainBase para cargarlo como un nuevo Parent
            Parent root = FXMLLoader.load(getClass().getResource(fileUrl));
            scene = Optional.of(new Scene(root));
            
        } catch (IOException | NullPointerException ex) {
            scene = Optional.empty();
        }
        
        return scene;
    }
    
    public void errorPopup(String title, String message) {
        
        Alert alert = new Alert(AlertType.ERROR);
        
        if (title != null) {
            alert.setTitle(title);
        } else {
            alert.setTitle("Error");
        }
        
        alert.setHeaderText(message);
        alert.showAndWait();
        
    }
}
