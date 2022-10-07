package sky.uk.retromoviesapp.ft.client;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Client {

  RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

  @Value("${service.base.url}")
  String baseURL;

  public void restSpec() {
    requestSpecBuilder = new RequestSpecBuilder();
    requestSpecBuilder.setBaseUri(baseURL);
    log.info("Service base uri : " + baseURL);
  }

  public Response sendGetRequest(String endpoint) {
    RequestSpecification requestSpecification = requestSpecBuilder.build();
    return given(requestSpecification).get(endpoint);
  }

}
