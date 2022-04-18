/**
 * 
 */
package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * This is a utility class where all the generic methods will be kept so that they can be used in any testcase classes again and again.
 */
public class Utils {

    RequestSpecification reqSpec;

    public RequestSpecification requestSpecification() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // at the last used is build(); so return type changes as per last method used
        // build(): Build RequestSpecBuilder ,@return The assembled request specification
        reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(stream)) // this method will log request which is generated, before hiting the response.  
                .setContentType(ContentType.JSON).build();

        return reqSpec;
    }
}
