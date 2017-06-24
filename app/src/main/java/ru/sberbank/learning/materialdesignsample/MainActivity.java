package ru.sberbank.learning.materialdesignsample;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.text_input2);
        textInputLayout.setError("Error");

//        AlertDialog dialog = new AlertDialog.Builder(this)
//                .setTitle("Title")
//                .setMessage("Message")
//                .setPositiveButton("OK", null)
//                .setNeutralButton("Maybe", null)
//                .setNegativeButton("No", null)
//                .create();
//        dialog.show();
    }
}
