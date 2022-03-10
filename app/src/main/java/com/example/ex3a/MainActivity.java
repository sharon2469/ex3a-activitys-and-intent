package com.example.ex3a;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PERSON_DETAILS = 1;

    Button btRegisterAndAgain;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegisterAndAgain = (Button) findViewById(R.id.btRegisterAndAgain);
        title = (TextView) findViewById(R.id.txtTitle);
    }

    public void openRegisterActivity(View view)
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_PERSON_DETAILS);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PERSON_DETAILS && resultCode == RESULT_OK && data != null) {
            String firstName = data.getStringExtra(RegisterActivity.FIRST_NAME_TAG);
            String lastName = data.getStringExtra(RegisterActivity.LAST_NAME_TAG);
            String genderType = data.getStringExtra(RegisterActivity.GENDER_TAG);
            String gender = (genderType.equals("male")) ? "Mr." : "Ms.";
            title.setText(getString(R.string.activity_main_textview_title2) +" " + gender + " " + firstName + " " + lastName);
            btRegisterAndAgain.setText(getString(R.string.activity_main_button_again));
        }
    }
}