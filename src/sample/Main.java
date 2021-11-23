package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ventana_splash.fxml"));
        primaryStage.setTitle("Cargando datos");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        Task tareaSecundaria = new Task() {
            @Override
            protected Object call() throws Exception {
                return null;
            }
        };
        tareaSecundaria.run();
        tareaSecundaria.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                System.out.println("tarea terminada");

                try {
                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Parent root2 = FXMLLoader.load(getClass().getResource("ventana_principal.fxml"));
                    Stage secondStage = new Stage();
                    secondStage.setTitle("Cargando datos");
                    secondStage.setScene(new Scene(root2, 300, 275));
                    secondStage.show();
                    primaryStage.hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
