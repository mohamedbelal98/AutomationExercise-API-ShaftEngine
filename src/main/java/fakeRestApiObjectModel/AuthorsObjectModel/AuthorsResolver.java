package fakeRestApiObjectModel.AuthorsObjectModel;

import org.json.simple.JSONObject;

public class AuthorsResolver {

    /**
     * @param idBook    put idBook for author.
     * @param firstName put first name for author.
     * @param lastName  put last name for author.
     * @return Author
     */
    public JSONObject createAuthor(int idBook, String firstName, String lastName) {

        JSONObject author = new JSONObject();
        author.put("idBook", idBook);
        author.put("firstName", firstName);
        author.put("lastName", lastName);

        return author;
    }

}
