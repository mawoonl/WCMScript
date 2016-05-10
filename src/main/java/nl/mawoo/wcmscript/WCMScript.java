package nl.mawoo.wcmscript;

import nl.mawoo.wcmscript.exceptions.CantFindLibrary;
import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The main class to run WCMScript
 *
 * @author Bob van der Valk
 */
public class WCMScript {

    private static AbstractLogger logger = WCMSLogger.getLogger(WCMScript.class);

    private WCMScript() {

    }

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        logger.info("WCMScript - Version 1.0.1");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                System.out.print(">");
                engine.eval(bf.readLine());
            } catch (IOException e) {
                logger.error("IO exception: ", e);
            } catch (ScriptException e) {
                logger.error("Error in script", e);
            } catch (Exception e) {
                logger.error("Uncaught exception: ", e);
            }
        }
    }



}
