package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {
    Button btn_done,btn_cancel;
    EditText editName,editNumber;
    int check = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Intent intent = this.getIntent();
        editName = (EditText) findViewById(R.id.text_name);
        editNumber = (EditText) findViewById(R.id.text_number);
        editName.setText(intent.getStringExtra("Name"));
        editNumber.setText(intent.getStringExtra("Number"));
        btn_done = (Button) findViewById(R.id.btn_done);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = Activity.RESULT_OK;
                backClicked(view);
            }
        });
    }
    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("Name",editName.getText().toString());
        data.putExtra("Number",editNumber.getText().toString());
        this.setResult(check,data);
        super.finish();
    }
    public void backClicked(View view) {
        this.onBackPressed();
    }
}
