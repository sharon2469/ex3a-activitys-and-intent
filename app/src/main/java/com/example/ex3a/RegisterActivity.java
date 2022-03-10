package com.example.ex3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static final String FIRST_NAME_TAG = "first_name";
    public static final String LAST_NAME_TAG = "last_name";
    public static final String GENDER_TAG = "gender";

    private EditText firstName;
    private EditText lastName;
    private RadioGroup genderRadioGroup;
    private Toast detailsMissingToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = (EditText) findViewById(R.id.edFirstName);
        lastName = (EditText) findViewById(R.id.edLastName);
        genderRadioGroup = (RadioGroup) findViewById(R.id.rgGender);
        detailsMissingToast = Toast.makeText(getApplicationContext(), "fill missing details", Toast.LENGTH_SHORT);
    }


    public void sendBackBtnClicked(View view) {
        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();
        RadioButton checkedGenderRadioBtn = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());

        if (firstNameStr.isEmpty() || lastNameStr.isEmpty() || checkedGenderRadioBtn == null) {
            detailsMissingToast.show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(FIRST_NAME_TAG, firstNameStr);
            intent.putExtra(LAST_NAME_TAG, lastNameStr);
            intent.putExtra(GENDER_TAG, checkedGenderRadioBtn.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}