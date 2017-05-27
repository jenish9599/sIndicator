package com.example.cbz.mapss;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * reated by Cjenishpatel on 18/03/17.
 */

 public class DisplayMessageActivity extends AppCompatActivity  {

    public String origin;
    Database mydb;
    EditText editDestination, editText1, editText2,editText3,editText4,editCost,editSource;
    Button btnadddata, btnviewdata;
    //String origin;
    String destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        Intent intent = getIntent();
        mydb = new Database(this);
        editSource = (EditText) findViewById(R.id.editSource);
        editDestination = (EditText) findViewById(R.id.editDestination);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editCost = (EditText) findViewById(R.id.editCost);
        btnadddata = (Button) findViewById(R.id.button);
       // btnviewdata = (Button) findViewById(R.id.btnView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            origin = extras.getString("O");
            destination = extras.getString("D");
        }




       // Toast.makeText(DisplayMessageActivity.this,origin,Toast.LENGTH_LONG).show();
      //  Toast.makeText(DisplayMessageActivity.this,destination,Toast.LENGTH_LONG).show();




        onclick();

        Cursor res = mydb.getalldata(origin,destination);
        if (res.getCount() == 0) {
            showmessage("ERROR ","This Route Is Not Available \n ADD YOUR ROUTE");
            return;
        } else {
            StringBuffer buffer = new StringBuffer();

            while (res.moveToNext()) {
               // buffer.append("Id : " + res.getString(0) + "\n");

                buffer.append("Destination : " + res.getString(1) + "\n");

                buffer.append("1 : " + res.getString(2) + "\n");

                buffer.append("2 : " + res.getString(3) + "\n");

                buffer.append("3 : " + res.getString(4) + "\n");

                buffer.append("4 : " + res.getString(5) + "\n");

                buffer.append("COST : " + res.getString(6) + "\n\n");

            }
            buffer.append("Thanks For using The App . \nHelp us Improve the app by adding alternate way or Path to different place \n\n");
            showmessage(origin, buffer.toString());
        }

    }

  public void onclick() {
        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted = mydb.insertData3(editSource.getText().toString(),editDestination.getText().toString(), editText1.getText().toString(), editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(),editCost.getText().toString());
                if (isinserted == true) {
                    Toast.makeText(DisplayMessageActivity.this, "DATA INSERTED", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DisplayMessageActivity.this, "DATA NOT INSERTED", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public void showmessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}