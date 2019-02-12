package starter.steps;

import static org.assertj.core.api.Assertions.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import starter.util.RestClient;

public class GetGreetScenarioSteps {

    private String service;
    private String result;

    @Given("a service <service>")
    public void givenAServiceService(@Named("service") String service){
        this.service = service;
    }

    @When("I submit the call")
    public void whenISubmitTheCall(){
        try {
            RestClient client = new RestClient();
            this.result = client.get(this.service);
        } catch (Exception e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("I get the <result> greeting")
    public void thenIGetTheResultGreeting(@Named("result") String result){

        assertThat(this.result).isEqualTo(result);
    }
}
