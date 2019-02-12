package starter;

import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.steps.ParameterConverters;

import java.lang.reflect.Type;

public class NullStringConverter extends ParameterConverters.AbstractParameterConverter<String> {

    @Override
    public String convertValue(String value, Type type) {
        if (StringUtils.EMPTY.equals(value)) {
            return null;
        }
        return value;
    }

}