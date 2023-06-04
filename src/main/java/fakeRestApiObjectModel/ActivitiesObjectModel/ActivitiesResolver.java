package fakeRestApiObjectModel.ActivitiesObjectModel;

import org.json.simple.JSONObject;

public class ActivitiesResolver {

    /**
     * @param title     put title for activity.
     * @param dueDate   put dueDate for activity.
     * @param completed put complete for activity.
     * @return new activity
     */
    public JSONObject createActivityBody(String title, String dueDate, boolean completed) {

        JSONObject activities = new JSONObject();
        activities.put("title", title);
        activities.put("dueDate", dueDate);
        activities.put("completed", completed);

        return activities;
    }

}
