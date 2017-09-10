package in.gov.startupindia.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.gov.startupindia.R;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ColorOptions extends Activity {
    /** Called when the activity is first created. */
    Spinner spinner1;
    private static final String[] colorsArray = {"Red", "Green", "Blue"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    Utils.hideTitleBar(this);
        setContentView(R.layout.activity_color_options);

        InitialSetUpUI();
    }

    // Method to initialize UI
    public void InitialSetUpUI()
    {
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,colorsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new mySpinnerListener());
    }

    class mySpinnerListener implements Spinner.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView parent, View v, int position,
                                   long id) {

            if(position==0) {
                MainActivity.navigationView.setBackgroundColor(Color.RED);
                MainActivity.tabLayout.setBackgroundColor(Color.RED);
                MainActivity.toolbar.setBackgroundColor(Color.RED);
            }
            if(position==1) {
                MainActivity.navigationView.setBackgroundColor(Color.GREEN);
                MainActivity.tabLayout.setBackgroundColor(Color.GREEN);
                MainActivity.toolbar.setBackgroundColor(Color.GREEN);
            }
            if(position==2) {
                MainActivity.navigationView.setBackgroundColor(Color.BLUE);
                MainActivity.tabLayout.setBackgroundColor(Color.BLUE);
                MainActivity.toolbar.setBackgroundColor(Color.BLUE);
            }

        }

        @Override
        public void onNothingSelected(AdapterView parent) {
            // TODO Auto-generated method stub
            // Do nothing.
        }

    }
}