package fakeRestApiObjectModel.AuthorsObjectModel;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class AuthorsRequest {

    private static final String baseUrl = System.getProperty("baseUrl");
    private static final String authorsEndPoint = System.getProperty("authorsEndPoint");
    SHAFT.API apiObject = new SHAFT.API(baseUrl);

    /**
     * @return Authors
     */
    public Response getAllAuthors() {

        return apiObject.get(authorsEndPoint).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
    }

    public Response createAuthor(JSONObject requestBody) {

        return apiObject.post(authorsEndPoint).setContentType(ContentType.JSON).setRequestBody(requestBody).setTargetStatusCode(200).perform();
    }

}
