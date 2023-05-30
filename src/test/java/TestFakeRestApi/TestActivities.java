package TestFakeRestApi;

import com.shaft.validation.Validations;
import fakeRestApiObjectModel.Activities;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivities {

    Activities activities;

    @BeforeClass
    public void beforeClass() {

        activities = new Activities();
    }

    @Test(description = "Get All Activities")
    @Epic("Activities")
    public void getAllActivities() {

        Response getActivities = activities.getAllActivity();

        var statusCode = getActivities.getStatusCode();

        Validations.assertThat().object(statusCode).isEqualTo(200).
                withCustomReportMessage("Verify the status code is equal 200").perform();
    }

}
