package com.example.Mensageria2.MensageriJavaFx;


import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLauncher {
    public static void main(String[] args) {
        Application.launch(JavaFXApplication.class, args);
    }
}
