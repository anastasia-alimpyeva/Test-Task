package readProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static enums.PathToProperty.PROPERTIES_FILE_PATH;

public class ReadProperties {
    private Properties currentProps = new Properties();;

    {
        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH.getPath())) {
            currentProps.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDomain() {

        return currentProps.getProperty("domain");
    }

    public String getPath() {

        return currentProps.getProperty("path");
    }
}
