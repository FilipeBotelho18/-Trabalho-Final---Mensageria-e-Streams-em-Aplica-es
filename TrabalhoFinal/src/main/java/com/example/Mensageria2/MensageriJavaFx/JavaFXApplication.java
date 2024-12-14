package com.example.Mensageria2.MensageriJavaFx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaFXApplication extends Application {

    private ApplicationContext springContext;

    @Override
    public void init() throws Exception {
        springContext = new AnnotationConfigApplicationContext(AppLauncher.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MensagemView.fxml"));
        loader.setControllerFactory(springContext::getBean);

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Mensageria - Enviar Alerta");
        stage.show();
    }
}
