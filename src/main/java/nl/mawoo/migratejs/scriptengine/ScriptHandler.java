package nl.mawoo.migratejs.scriptengine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * This class is repsonible for running the nashorn script engine
 *
 * @author Bob van der Valk
 */
public class ScriptHandler
{
    ScriptEngine engine;
    ClassLoader classLoader;

    public ScriptHandler() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("nashorn");

        classLoader = getClass().getClassLoader();

        try {
            engine.eval(new FileReader(classLoader.getResource("migratejs.js").getFile()));
        } catch (ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a file into the script engine
     * @param path path to the file you want to use
     * @throws FileNotFoundException
     * @throws ScriptException
     */
    public void fileReader(String path) throws FileNotFoundException, ScriptException {
        engine.eval(new FileReader(path));
    }

    /**
     * Read a string into the script engine
     * @param input user input
     * @throws ScriptException
     */
    public void stringReader(String input) throws ScriptException {
        engine.eval(input);
    }

}