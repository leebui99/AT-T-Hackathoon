package com.tacoma.uw.leebui99.raisethepark.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tacoma.uw.leebui99.raisethepark.InforActivity;
import com.tacoma.uw.leebui99.raisethepark.R;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mFirstComment;
    private EditText mSecondComment;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        mFirstComment = (EditText) findViewById(R.id.comment);
        mSecondComment = (EditText) findViewById(R.id.anotherComment);
        mButton = (Button) findViewById(R.id.buttonSubmit);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent mInten = new Intent(getApplicationContext(), InforActivity.class);
        startActivity(mInten);
    }
}
