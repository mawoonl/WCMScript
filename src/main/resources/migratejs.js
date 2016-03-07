/**
 * Return a test message (Hello World);
 * @returns {string}
 */
function TestMessage() {
    var testClass = Java.type("nl.mawoo.migratejs.extend.Test");
    var test = new testClass();
    print(test.Message())
}

function test() {
    var testClass = Java.type("nl.mawoo.migratejs.extend.filemanager.FilemanagerHandler");
    var test = new testClass();
    test.listFiles("F:/Feed The Beast/");
}

/**
 * Load a js file into the program.
 * @param path path to the file to import.
 */
function include(path) {
    load(path);
}