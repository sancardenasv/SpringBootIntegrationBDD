package starter.steps;

import static org.assertj.core.api.Assertions.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddTwoNumbersScenarioSteps {
    private int number1;
    private int number2;
    private int result;

    @Given("a number <number1> and other number <number2>")
    public void givenANumberAndOtherNumber(@Named("number1") int number1, @Named("number2") int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @When("I submit the numbers")
    public void whenISubmitTheNumbers() {
        this.result = number1 + number2;
    }

    @Then("I get the <result> expected")
    public void thenIGetTheExpected(@Named("result") int result) {
        assertThat(this.result).isEqualTo(result);
    }

}
