package TestFakeRestApi;

import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import fakeRestApiObjectModel.AuthorsObjectModel.AuthorsRequest;
import fakeRestApiObjectModel.AuthorsObjectModel.AuthorsResolver;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAuthors {

    AuthorsRequest authorsRequest;
    AuthorsResolver authorsResolver;
    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        authorsRequest = new AuthorsRequest();
        authorsResolver = new AuthorsResolver();
        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/createAuthors.json");
    }

    @Test
    public void testGetAllAuthors() {

        Response getAllAuthors = authorsRequest.getAllAuthors();

        var statusCode = getAllAuthors.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();
    }

    @Test
    public void testCreateAuthor() {

        String idBook = jsonFileManager.getTestData("idBook");
        String firstName = jsonFileManager.getTestData("firstName");
        String lastName = jsonFileManager.getTestData("lastName");


        JSONObject createAuthorBody = authorsResolver.createAuthor(
                Integer.parseInt(idBook),
                firstName,
                lastName
        );

        Response createActivity = authorsRequest.createAuthor(createAuthorBody);

        var statusCode = createActivity.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();

        Validations.verifyThat().response(createActivity).extractedJsonValue("idBook").
                isEqualTo(idBook).withCustomReportMessage("Verify the idBook is equal to my input").perform();

        Validations.verifyThat().response(createActivity).extractedJsonValue("firstName").
                isEqualTo(firstName).withCustomReportMessage("Verify the first name is equal to my input").perform();

        Validations.verifyThat().response(createActivity).extractedJsonValue("lastName").
                isEqualTo(lastName).withCustomReportMessage("Verify the last name is equal to my input").perform();

    }
}
