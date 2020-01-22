package ru.iskra.H03.server.src.main.java.server;

import java.util.logging.FileHandler;
import java.util.logging.*;

public class Start {
    static FileHandler fh;
    private static Logger logger = Logger.getLogger("LogApp");

    public static void main(String[] args) {
       try {
           logger.addHandler(new FileHandler("LogToFile.xml"));
           logger.info("A message logged to the file");

           try {
               logger.info("Start - Server");
               new Server();
           }catch (Exception ee) {
               logger.exiting(ee.getClass().getName(), ee.getMessage());
           }

       }catch (Exception eee) {
       }
    }
}
