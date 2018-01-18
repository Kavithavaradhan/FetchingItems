package com.example.kavi.exno2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RatingBar rb;
    RadioButton b1,b2;
    Button subbtn;
    EditText et1,et2,et3,et4;
    TextView t1;
    String rating;
    String sex;
    int degree;
    Spinner sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.rg);
        b1 = (RadioButton) findViewById(R.id.rad1);
        b2 = (RadioButton) findViewById(R.id.rad2);
        subbtn = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.edit1);
        et3 = (EditText) findViewById(R.id.edit3);
        et4 = (EditText) findViewById(R.id.edit4);
        rb = (RatingBar) findViewById(R.id.rat);
        sp = (Spinner) findViewById(R.id.sp);





        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float arg1, boolean fromUser) {
                rating = String.valueOf(arg1);

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String temp;
                View radiobutton = group.findViewById(checkedId);
                degree = group.indexOfChild(radiobutton);
                if (degree == 0){
                    temp = "B.E CSE";
                }else {
                    temp = "B.E IT";
                }
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               sex = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Nothing Selected",Toast.LENGTH_SHORT).show();

            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String area = et4.getText().toString();
                String a1 = et3.getText().toString();

                String line = System.getProperty("line.separator");

                String str = "Name = " + name + line + "Sex = " + sex + line + "Degree = " + degree + line
                        + "Area = " + area + " ,   " + a1 +  line + "Rating = " + rating;

                Toast.makeText(MainActivity.this, str,Toast.LENGTH_SHORT).show();
            }
        });



    }

    /*public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rad1:
                if (checked){
                    Toast.makeText(MainActivity.this, "CSE Clicked", Toast.LENGTH_SHORT).show();
                }
                    break;
            case R.id.rad2:
                if (checked){
                    Toast.makeText(MainActivity.this, "IT Clicked", Toast.LENGTH_SHORT).show();
                }
                    break;
        }*/



}
