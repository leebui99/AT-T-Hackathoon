package com.tacoma.uw.leebui99.raisethepark.Question;

/**
 * Created by lebui on 3/19/2016.
 */
public class TheQuestion {
    public String mQuestion;
    public String mAnswer1;
    public String mAnswer2;
    public String mAnswer3;
    public String mAnswer4;
    public String mAnswer5;
    public static final String QUESTION = "question", ANSWER1 = "answer1",
            ANSWER2 = "answer2", ANSWER3 = "answer3", ANSWER4 = "answer4", ANSWER5 = "answer5";


    public TheQuestion(String theQuestion, String theAnswer1, String theAnswer2,
                           String theAnswer3, String theAnswer4, String theAnswer5){
        setQuestion(theQuestion);
        setAnswer1(theAnswer1);
        setAnswer2(theAnswer2);
        setAnswer3(theAnswer3);
        setAnswer4(theAnswer4);
        setAnswer5(theAnswer5);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getAnswer1() {
        return mAnswer1;
    }

    public String getAnswer2() {
        return mAnswer2;
    }

    public String getAnswer3() {
        return mAnswer3;
    }

    public String getAnswer4() {
        return mAnswer4;
    }

    public String getAnswer5() {
        return mAnswer5;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public void setAnswer1(String answer1) {
        mAnswer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        mAnswer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        mAnswer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        mAnswer4 = answer4;
    }

    public void setAnswer5(String answer5) {
        mAnswer5 = answer5;
    }

    @Override
    public String toString() {
        return mQuestion;
    }
}
