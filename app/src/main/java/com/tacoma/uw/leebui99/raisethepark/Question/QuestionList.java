package com.tacoma.uw.leebui99.raisethepark.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lebui on 3/19/2016.
 */
public class QuestionList {
    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param algQuestionJSON
     * @return
     */
    public static String parseAlgQuestionJSON(String algQuestionJSON, List<TheQuestion> questionList) {
        String reason = null;
        reason = algQuestionJSON;
        if (reason != null) {
            try {
                JSONArray arr = new JSONArray(algQuestionJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    TheQuestion question = new TheQuestion(obj.getString(TheQuestion.QUESTION), obj.getString(TheQuestion.ANSWER1)
                            , obj.getString(TheQuestion.ANSWER2), obj.getString(TheQuestion.ANSWER3),
                            obj.getString(TheQuestion.ANSWER4), obj.getString(TheQuestion.ANSWER5));
                    questionList.add(question);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }
}
