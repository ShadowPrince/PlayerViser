package org.sp.playerviser;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:50
 * at IntelliJ IDEA.
 */
public class Log{
    private static String pluginPrefix = "[PV]";
    private static String warningPrefix = "[WARRNING]";
    private static String debugPrefix = "[DEBUG]";
    private static String logPrefix = "[LOG]";

    public static void info(String str){
        System.out.println(pluginPrefix.concat(" "+str));
    }
    public static void warning(String str){
        System.out.println(pluginPrefix.concat(warningPrefix.concat(" "+str)));
    }
    public static void log(String str) {
        info(logPrefix.concat(" "+str));
    }
    public static void debug(String str){
        if (PlayerViser.debug) {
            info(debugPrefix+" "+str);
        }
    }
}
