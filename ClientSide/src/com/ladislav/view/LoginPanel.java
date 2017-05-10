package com.ladislav.view;

/**
 * Created by Ladislav on 5/9/2017.
 */

import com.ladislav.controllers.LoginController;
import com.ladislav.model.ChatClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPanel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../resources/login_window.fxml"));
        Parent root = loginLoader.load();
        LoginController loginController = loginLoader.getController();

        ChatClient model = new ChatClient();
        model.addMessageObserver(loginController);
        loginController.initModel(model);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
