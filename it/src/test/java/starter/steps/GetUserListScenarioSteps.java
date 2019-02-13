package starter.steps;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.util.ResourceUtils;
import starter.dto.RestResponse;
import starter.dto.UserEntity;
import starter.util.RestClient;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class GetUserListScenarioSteps {
    private String service;
    private RestResponse response;

    @Given("a user service <service>")
    public void givenAUserServiceService(@Named("service") String service){
        this.service = service;
    }

    @When("I submit the user list call")
    public void whenISubmitTheUserListCall(){
        try {
            RestClient client = new RestClient();
            this.response = new Gson().fromJson(client.get(this.service), RestResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Then("I get the <result> list")
    public void thenIGetTheResultList(@Named("result") String result) throws FileNotFoundException {
        RestResponse expectedResponse = getRestResponseFromJsonFile(result);
        assertThat(expectedResponse).hasFieldOrPropertyWithValue("status", this.response.getStatus())
                .hasFieldOrPropertyWithValue("reason", this.response.getReason());
        assertThat(this.response.getData().containsKey("userList"));
        List<UserEntity> userEntityList = new Gson().fromJson(this.response.getData().get("userList").toString(), new TypeToken<List<UserEntity>>(){}.getType());
        List<UserEntity> expectedUserEntityList = new Gson().fromJson(expectedResponse.getData().get("userList").toString(), new TypeToken<List<UserEntity>>(){}.getType());
        assertThat(userEntityList).hasSize(expectedUserEntityList.size());
    }

    private RestResponse getRestResponseFromJsonFile(String filePath) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(getClass().getClassLoader().getResource(filePath).getPath()));
        return new Gson().fromJson(reader, RestResponse.class);
    }
}
