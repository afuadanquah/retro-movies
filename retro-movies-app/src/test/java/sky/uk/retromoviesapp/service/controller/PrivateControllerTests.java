package sky.uk.retromoviesapp.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class PrivateControllerTests {

  PrivateController privateController;

  @BeforeEach
  void setup(){
    privateController = new PrivateController();
  }

  @Test
  void checkThatPrivateStatusEndPoint_ReturnsBodyOfOK(){

    //Expected - OK, Actual - Call the Method
    assertEquals("OK", privateController.getPrivateStatus().getBody());
  }

  @Test
  void checkThePrivateStatusEndPoint_ReturnsStatusOf200(){

    assertEquals(HttpStatus.OK, privateController.getPrivateStatus().getStatusCode());
  }

}
