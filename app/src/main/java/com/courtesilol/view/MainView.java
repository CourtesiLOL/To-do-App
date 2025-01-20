/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.courtesilol.view;

import com.courtesilol.model.FxmlUtils;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Javier
 */
public class MainView extends Application {

    private static String[] arguments;
    private static final FxmlUtils fxmlUtils = FxmlUtils.getInstance();

    @Override
    public void start(Stage primaryStage) {

        Optional<Scene> scene = fxmlUtils.getView("/View/mainBase.fxml");

        if(scene.isEmpty()) {

            fxmlUtils.errorPopup(null,"No se a cargado correctamente");
            
        } else {
            primaryStage.setScene(scene.get());
            primaryStage.setTitle("To-Do"); // Elimina el ícono de la ventana
            primaryStage.show();
        }

    }

    public static final void launchApp(String[] args) {
        arguments = args;
        Application.launch(MainView.class, args);
    }

}
