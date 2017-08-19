package com.java2blog.spinnerdropdownexampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    String countryCode;
    Locale country;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get Spinner reference
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        // Countries from locale

        String[] locales = Locale.getISOCountries();
        ArrayList<String> countries = new ArrayList<String>();
        for (String locale : locales) {
            //String country = locale.g();
            country = new Locale("",locale);
            //String countryCode = country.toString().replace("_","").toLowerCase();

            countryCode = country.toString().replace("_","").toLowerCase();
            String countryt = country.getDisplayCountry();
            //countries.add( countryCode );
            Log.e("Country",""+country);
            if( countryt.length() > 0 && !countries.contains(countryt) ){

                countries.add(countryt);

            }


        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

        Log.e("Countries",""+countries);
        // Creating array adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.item_country_list_spinner, countries);

        // Drop down style will be listview with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        //spinner.setSelection(dataAdapter.getPosition(""));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // getting selected item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item in toast
        Toast.makeText(parent.getContext(), "Selected Country: " + item, Toast.LENGTH_LONG).show();

        //Toast.makeText(parent.getContext(), "Selected Country: " + item /*+ "("+countryCode+")"*/, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }
}