package com.Connect4.shrooti;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }
    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        GridPane rootNode = loader.load();
        controller = loader.getController();
        controller.createPlaygrnd();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane=(Pane) rootNode.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Count Four Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File"
        );
        MenuItem newMenuItem=new MenuItem("New Game");
        newMenuItem.setOnAction(event -> {controller.resetGame();});
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem resetMenuItem=new MenuItem("Reset Game");
        resetMenuItem.setOnAction(event -> controller.resetGame());

        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> Platform.exit());
        Menu helpMenu=new Menu("Help");
        MenuItem aboutmeMenuItem=new MenuItem("About me");
        aboutmeMenuItem.setOnAction(event -> aboutApp());
        MenuItem aboutgmMenuItem=new MenuItem("About Game");
        aboutgmMenuItem.setOnAction(event -> aboutGame());
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,resetMenuItem,separatorMenuItem,quitMenuItem);
        helpMenu.getItems().addAll(aboutmeMenuItem,separatorMenuItem,aboutgmMenuItem);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutGame() {
        Alert alertgm=new Alert(Alert.AlertType.INFORMATION);
        alertgm.setTitle("Game Rules");
        alertgm.setHeaderText("How to Play");
        alertgm.setContentText("Play till get sequence of 4 ball circles in any direction");
        alertgm.show();
        Button yButton=new Button();
        yButton.setOnAction(event -> Platform.exit());
    }

    private void resetGame() {

    }

    private void aboutApp() {
        Alert alertdialogue=new Alert(Alert.AlertType.INFORMATION);
        alertdialogue.setTitle("My first Desktop App");
        alertdialogue.setHeaderText("Just a trial");
        alertdialogue.setContentText("I am just a beginner but soon will be pro and start developing awesome Java Games," +
                "and applications.This job is interesting,and I'm really enjoying my work\n"+"This is all about learning and learning" +
                "more and more.\nReally a fun task and can't wait for further explorations in the field.\n"+"At the end can conclude" +
                "that yes Java is my love and passion...something I enjoy while doing.\n"+"Thanks for spending your time in reading this\n"
                +"\n"+"                                                                                         Created by Shrooti");
        ButtonType yesButton=new ButtonType("Yay");
        ButtonType noButton=new ButtonType("Nah");
        alertdialogue.getButtonTypes().setAll(yesButton,noButton);
        alertdialogue.showAndWait();
        Optional<ButtonType> clickedButton=alertdialogue.showAndWait();
        if(clickedButton.isPresent() && clickedButton.get()==yesButton)
        {
            System.out.println("Clicked");
        }
        else
        {
            System.out.println("Not Clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
