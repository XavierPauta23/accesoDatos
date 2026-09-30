package org.example;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.example.ui.MainMenu;


public class Application {
    static void main() {
        //TODO: Lanzar la aplicacion
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            MainMenu mainMenu = container.select(MainMenu.class).get();
            mainMenu.run();
        }
    }
}
