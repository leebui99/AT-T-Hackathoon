package com.tacoma.uw.leebui99.raisethepark.Question;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tacoma.uw.leebui99.raisethepark.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class QuestionForm extends AppCompatActivity implements View.OnClickListener {

    private TextView mAlgQuestion;
    private Button mNext;
    private RadioGroup mRadioGroup;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;
    private RadioButton mAnswer4;
    private RadioButton mAnswer5;

    private int mQuestionId = 0;

    private ArrayList<TheQuestion> mList;
    private String mEvalQuestion;
    private TheQuestion mQuestion;
    private static final String
            url = "http://cssgate.insttech.washington.edu/~leebui99/Park.php";
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_form);

        //Lookup view for data into the template view using the data object
        mAlgQuestion = (TextView) findViewById(R.id.QuestionView);
        mAnswer1 = (RadioButton)findViewById(R.id.radioAnswer1);
        mAnswer2 = (RadioButton) findViewById(R.id.radioAnswer2);
        mAnswer3 = (RadioButton) findViewById(R.id.radioAnswer3);
        mAnswer4 = (RadioButton) findViewById(R.id.radioAnswer4);
        mAnswer5 = (RadioButton) findViewById(R.id.radioAnswer5);

        mNext = (Button) findViewById(R.id.buttonSubmit);

        mNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (mQuestionId < mList.size()){
            mQuestion = mList.get(mQuestionId);
            setNextQuestion();
        }else {//go to the question activity
            Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
            startActivity(intent);
        }
    }

    private void setNextQuestion() {//Insert question and answer for the app
        mAlgQuestion.setText(mQuestion.toString());
        mAnswer1.setText(mQuestion.getAnswer1());
        mAnswer2.setText(mQuestion.getAnswer2());
        mAnswer3.setText(mQuestion.getAnswer3());
        mAnswer4.setText(mQuestion.getAnswer4());
        mAnswer5.setText(mQuestion.getAnswer5());
        mQuestionId++;

    }


    @Override
    protected void onStart() {
        super.onStart();
        mList = new ArrayList<TheQuestion>();
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[]{url});
    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(QuestionForm.this, "Wait", "Downloading...");;
        }

        @Override
        protected String doInBackground(String... urls) {
            String response = "";
            HttpURLConnection urlConnection = null;
            for (String url : urls) {
                try {
                    URL urlObject = new URL(url);
                    urlConnection = (HttpURLConnection) urlObject.openConnection();

                    InputStream content = urlConnection.getInputStream();

                    BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                    String s = "";
                    while ((s = buffer.readLine()) != null) {
                        response += s;
                    }

                } catch (Exception e) {
                    response = "Unable to download the list of question, Reason: "
                            + e.getMessage();
                }
                finally {
                    if (urlConnection != null)
                        urlConnection.disconnect();
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            // Something wrong with the network or the URL.
            mProgressDialog.dismiss();
            //Success to retrieve data from the service
            mEvalQuestion = result;
            result = QuestionList.parseAlgQuestionJSON(mEvalQuestion, mList);
            mQuestion = mList.get(mQuestionId);
            setNextQuestion();
        }
    }

}
