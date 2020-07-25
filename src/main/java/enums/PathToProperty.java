package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum PathToProperty {
    PROPERTIES_FILE_PATH("src/test/resources/properties/test.properties");
    private final String path;

}
