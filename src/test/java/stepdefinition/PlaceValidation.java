package stepdefinition;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceValidation extends Utils {

    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("add place payload")
    public void add_place_payload() {

        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        // GIVEN parameters (Base uri, headers so on..) we need to keep in req. spec.
        // keeping request separately , generalising request
        res = given().spec(requestSpecification()).body(data.addPlacePayload());// provided body now using java object
    }

    @When("user calls the {string} with post http request")
    public void user_calls_the_with_post_http_request(String arg) {

        // after giving the request to server for( post/get/put/del) we get the response back from server. once response is received then only we do the
        // assertion i.e. then().assertThat()
        // also keeping response separately , generalising response
        response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
    }

    @Then("the API call gets success with status code {int}")
    public void the_API_call_gets_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
        String strResponse = response.asString();
        JsonPath js = new JsonPath(strResponse);
        Assert.assertEquals(js.get(keyValue).toString(), expectedValue);

    }

}
