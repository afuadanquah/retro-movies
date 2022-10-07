package sky.uk.retromoviesapp.ft.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import sky.uk.retromoviesapp.ft.client.Client;
import sky.uk.retromoviesapp.ft.model.HTTPRequest;

@Slf4j
public class HTTPRequestSteps {

  private static final Map<String, String> ENDPOINTS = new HashMap<>() {
    {
      put("private-status", "/private/status");
    }
  };

  private final HTTPRequest httpRequest;
  private final Client client;

  public HTTPRequestSteps(final HTTPRequest httpRequest, final Client client){
      this.httpRequest = httpRequest;
      this.client = client;

  }

  @Before
  public void setup() {
    client.restSpec();
  }

  @When("the client makes a request to {string} endpoint")
  public void clientMakesARequestTo(String endpoint) {
    log.info("Endpoint is {}", ENDPOINTS.get(endpoint));
    httpRequest.setResponse(client.sendGetRequest(ENDPOINTS.get(endpoint)));
  }

  @Then("the client receives a body of {string}")
  public void clientReceivesABodyOf(String body) {
    Assertions.assertEquals(body, httpRequest.getResponseBody());
  }

  @And("the client receives a status code of {int}")
  public void clientReceivesAStatusCodeOf(int code) {
    Assertions.assertEquals(code, httpRequest.getResponseStatusCode());
  }

}
