package fakeRestApiObjectModel;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activities {

    private static final String baseUrl = System.getProperty("baseUrl");
    private static final String activitiesEndPoint = System.getProperty("activitiesEndPoint");
    SHAFT.API apiObject = new SHAFT.API(baseUrl);


    public Response getAllActivity() {

        return apiObject.get(activitiesEndPoint).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
    }

}
