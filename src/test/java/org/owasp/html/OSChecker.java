package org.owasp.html;


class OSChecker {

    private static String OS = System.getProperty("os.name").toLowerCase();

    static boolean isWindows() {
        return OS.contains("win");
    }
    
    static boolean isMacOsX() {
        return OS.contains("mac os x");
    }

}
