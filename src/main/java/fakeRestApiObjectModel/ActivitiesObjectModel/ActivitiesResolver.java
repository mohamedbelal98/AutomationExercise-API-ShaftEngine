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

        JSONObject activity = new JSONObject();
        activity.put("title", title);
        activity.put("dueDate", dueDate);
        activity.put("completed", completed);

        return activity;
    }

}
