package com.example.formapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private ImageView show_im;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
  //  private Button btnDisplay;

    public  static final int RequestPermissionCode  = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Marosvásárhely");
        categories.add("Szászrégen");
        categories.add("Szováta");
        categories.add("Segesvár");
        categories.add("Nyárádszereda");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        show_im = (ImageView) findViewById(R.id.iv_image);
        Button bt_photo = (Button) findViewById(R.id.bt_photo);

        EnableRuntimePermission();

        bt_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 7);

            }
        });

        Button bt_date = (Button)findViewById(R.id.bt_date);
        TextView tv_date = (TextView)findViewById(R.id.tv_date);

        bt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        TextView birthDate = (TextView)findViewById(R.id.tv_date);
                        birthDate.setText(day + "/" + month + "/" + year);
                        Toast.makeText(MainActivity.this,"You set the date!", Toast.LENGTH_LONG).show();

                    }
                }, year, month, dayOfMonth);

                datePickerDialog.show();

            }
        });

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String text = "You selected: ";
                    text += (R.id.radioMale == checkedId) ? "male" : "female";
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                }
            });
        }

        final CheckBox checkBox = findViewById(R.id.chB_hobby);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "I have hobbies", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Spinner spinner_dep = findViewById(R.id.spinner_department);
        spinner_dep.setOnItemSelectedListener(this);

        List<String> departments = new ArrayList<>();
        departments.add("Informatika");
        departments.add("Számitástechnika");
        departments.add("Gépészmérnöki");
        departments.add("Mechatronika");

        ArrayAdapter<String> dataAdapterDepartment = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, departments);
        dataAdapterDepartment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_dep.setAdapter(dataAdapterDepartment);

        final RadioGroup radioGroupYear = findViewById(R.id.radioGroupYear);
        final RadioButton radio1 = findViewById(R.id.radio1);

        if (radioGroupYear != null) {
            radioGroupYear.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String text = "You selected: ";
                    if(radio1.isChecked())
                    {
                        text+="1";
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }
                    if(R.id.radio2 == checkedId)
                    {
                        text+="2";
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }
                    if(R.id.radio3 == checkedId)
                    {
                        text+="3";
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            show_im.setImageBitmap(bitmap);
        }
    }
   public void EnableRuntimePermission(){

       if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
               Manifest.permission.CAMERA))
       {

           Toast.makeText(MainActivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

       } else {

           ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                   Manifest.permission.CAMERA}, RequestPermissionCode);

       }
   }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(MainActivity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(MainActivity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

}
