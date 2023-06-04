package TestFakeRestApi;

import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import fakeRestApiObjectModel.ActivitiesObjectModel.ActivitiesRequest;
import fakeRestApiObjectModel.ActivitiesObjectModel.ActivitiesResolver;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivities {

    ActivitiesRequest activitiesRequest;
    ActivitiesResolver activitiesResolver;
    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        activitiesRequest = new ActivitiesRequest();
        activitiesResolver = new ActivitiesResolver();
        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/createActivities.json");
    }

    @Test(description = "Get All Activities")
    @Epic("Activities")
    public void getAllActivities() {

        Response getActivities = activitiesRequest.getAllActivities();

        var statusCode = getActivities.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();
    }

    @Test(description = "Create Activity")
    @Epic("Activities")
    public void createActivity() {

        String title = jsonFileManager.getTestData("title");
        String dueDate = jsonFileManager.getTestData("dueDate");

        JSONObject createActivityBody = activitiesResolver.createActivityBody(
                title,
                dueDate,
                true
        );

        Response createActivityResponse = activitiesRequest.createActivity(createActivityBody);

        var statusCode = createActivityResponse.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();

        Validations.verifyThat().response(createActivityResponse).extractedJsonValue("title").
                isEqualTo(title).withCustomReportMessage("Verify the title is equal to my input").perform();

        Validations.verifyThat().response(createActivityResponse).extractedJsonValue("dueDate").
                isEqualTo(dueDate).withCustomReportMessage("Verify the dueDate is equal to my input").perform();

        Validations.verifyThat().response(createActivityResponse).extractedJsonValue("completed").
                isEqualTo("true").withCustomReportMessage("Verify the completed is equal to my input").perform();
    }

    @Test(description = "Get Single Activity By ID")
    @Epic("Activities")
    public void getSingleActivity() {

        String id = "2";

        Response getSingleActivityById = activitiesRequest.getSingleActivityByID(id);

        var statusCode = getSingleActivityById.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();

        Validations.verifyThat().response(getSingleActivityById).extractedJsonValue("id").
                isEqualTo(id).withCustomReportMessage("Verify the id is equal to my input").perform();

        Validations.verifyThat().response(getSingleActivityById).extractedJsonValue("title").
                isEqualTo("Activity 2").withCustomReportMessage("Verify the title is equal to my input").perform();

        Validations.verifyThat().response(getSingleActivityById).extractedJsonValue("completed").
                isEqualTo("true").withCustomReportMessage("Verify the completed is equal to my input").perform();
    }

}
