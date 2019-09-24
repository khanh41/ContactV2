package com.example.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.BitSet;

public class MainActivity extends Activity implements View.OnClickListener {
    int i=0;
    FloatingActionButton fab;
    TextView text_number1,text_number2,text_name1,text_name2;
    public static final int MY_REQUEST_CODE = 100;
    SearchView text_search;
    ImageView btn_edti1,btn_edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Widget();

    }
    public void Widget(){
        text_name1 = findViewById(R.id.text_name1);
        text_name2 = findViewById(R.id.text_name2);
        text_number1 = findViewById(R.id.text_number1);
        text_number2 = findViewById(R.id.text_number2);
     //   text_search = findViewById(R.id.text_search);
        btn_edti1 = findViewById(R.id.btn_edit1);
        btn_edit2 = findViewById(R.id.btn_edit2);
        btn_edti1.setOnClickListener(this);
        btn_edit2.setOnClickListener(this);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        if(requestCode== MY_REQUEST_CODE && resultCode==Activity.RESULT_OK){
            if(i==1) {
                this.text_name1.setText(data.getStringExtra("Name"));
                this.text_number1.setText(data.getStringExtra("Number"));
            }
            else {
                this.text_name2.setText(data.getStringExtra("Name"));
                this.text_number2.setText(data.getStringExtra("Number"));
            }
        }
    }
    @Override
    public void onClick(View view) {
        Intent intentEdit = new Intent(this,EditContactActivity.class);
        Intent intentAdd = new Intent(this,AddContactActivity.class);
        switch (view.getId()) {
            case R.id.btn_edit1:
                i = 1;
                intentEdit.putExtra("Name", text_name1.getText().toString());
                intentEdit.putExtra("Number", text_number1.getText().toString());
                this.startActivityForResult(intentEdit, MY_REQUEST_CODE);
                break;
            case R.id.btn_edit2:
                i = 2;
                intentEdit.putExtra("Name", text_name2.getText().toString());
                intentEdit.putExtra("Number", text_number2.getText().toString());
                this.startActivityForResult(intentEdit, MY_REQUEST_CODE);
                break;
            case R.id.fab:
                intentEdit.putExtra("Name", text_name2.getText().toString());
                intentEdit.putExtra("Number", text_number2.getText().toString());
                this.startActivity(intentAdd);
                break;

        }
       }
}