package com.cdj;



import com.cdj.tool.MainMenus;

import java.io.IOException;
import java.sql.SQLException;


public class AppApplication {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        /**
         * 循环主控制台
         */
        while (true){
            MainMenus.MainMenus();
        }

    }
}
