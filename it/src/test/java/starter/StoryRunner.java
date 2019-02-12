package starter;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.steps.ParameterConverters;

public class StoryRunner extends SerenityStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useParameterConverters(new ParameterConverters().addConverters(new NullStringConverter()));
    }
}