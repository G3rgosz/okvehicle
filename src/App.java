/*
 * File: App.java
 * Created Date: 2021-09-24 22:13:27
 * Author: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * Group: Szoft II N
 * Original: revehicle, Sallai Andras
 * Github: https://github.com/Gergosz-2000
 * -----
 * Last Modified: 2021-10-08
 * Modified By: Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * -----
 * Copyright (c) 2021 Szivak Gergo, Ban Cinti, Hermanyi Gergely
 * 
 * GNU GPL v2
 */

import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
