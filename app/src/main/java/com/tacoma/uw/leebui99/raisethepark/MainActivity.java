package com.tacoma.uw.leebui99.raisethepark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tacoma.uw.leebui99.raisethepark.Question.QuestionForm;

public class MainActivity extends AppCompatActivity{

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.eval);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), QuestionForm.class);
                startActivity(mIntent);
            }
        });

    }


}
