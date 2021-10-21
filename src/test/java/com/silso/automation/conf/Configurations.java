package com.silso.automation.conf;

import java.io.File;

public class Configurations {

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            + "src"
            + File.separator
            + "test"
            + File.separator
            + "resources"
            + File.separator
            + "drivers"
            + File.separator;

    public static String CHROME_DRIVER_PATH = DRIVER_DIR + "chromedriver";
    public static String EDGE_DRIVER_PATH = DRIVER_DIR + "edgedriver";
    public static String SAFARI_DRIVER_PATH = DRIVER_DIR + "safaridriver";
    public static String FIREFOX_DRIVER_PATH = DRIVER_DIR + "geckodriver";

    public static String modifyIfWindows(String inPath) {
        if (System.getProperty("os.name").toLowerCase().contains("windows")){
            return inPath + ".exe";
        } else {
            return inPath;
        }
    }

}
