package utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigUtils {

    private static final Dotenv DOTENV = Dotenv.load();
    private static final String BACKEND_URL = DOTENV.get("Backend_URL");
    private static final String MAX_TRIALS = DOTENV.get("MAX_TRIALS");

    public static String getBackendUrl() {
        return BACKEND_URL;
    }

    public static String getMaxTrials() {
        return MAX_TRIALS;
    }
}
