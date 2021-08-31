package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItems;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItems = findViewById(R.id.etItems);
        btnSave = findViewById(R.id.btnSave);
        getSupportActionBar().setTitle("Edit item");

        etItems.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //When user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an intent which will contain the results
                Intent intent = new Intent();
                //pass data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItems.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set result of the intent
                setResult(RESULT_OK, intent);
                //finish activity, close screen and go back
                finish();

            }
        });

    }
}