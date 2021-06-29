package com.example.test2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //initialising different views
    Button b1, b2, b3;
    AlertDialog ad;
    Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assigning buttons
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        //setting listener for button 1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating toast
                Toast.makeText(MainActivity.this, "This is a toast.", Toast.LENGTH_SHORT).show();
            }
        });
        //setting listener for button 2
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //building a alert dialog
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                //setting title for alert dialog
                b.setTitle("Alert Message");
                //setting message for alert dialog
                b.setMessage("This is a test alert message. Press Yes to close the application and no to close this window.");
                //setting positive response
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //closing the application
                        MainActivity.this.finish();
                    }
                });
                //setting negative response
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //closing dialog box
                        ad.cancel();
                    }
                });
                //creating alert dialog
                ad = b.create();
                //showing dialog
                ad.show();
            }
        });
        //setting listener for button 3
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating a new dialog box
                d = new Dialog(MainActivity.this);
                //setting a view for dialog box
                d.setContentView(R.layout.customise_dialog);
                //assigning button
                Button b = d.findViewById(R.id.c1);
                //setting listener to button
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //exiting the dialog box
                        d.cancel();
                    }
                });
                //showing the dialog box
                d.show();
            }
        });
    }
}