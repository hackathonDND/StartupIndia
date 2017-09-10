package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import in.gov.startupindia.R;

public class StartUpIndiaServicesParts extends AppCompatActivity {

    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_india_services_parts);

        mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        mytoolbar.setTitleTextColor(0xFFFFFFFF);

        StartupRecognitionFragment srf = new StartupRecognitionFragment();
        IncubatorRecognitionFragment irf = new IncubatorRecognitionFragment();
        AdvertisementFragment af = new AdvertisementFragment();

        final URLassignment urla = new URLassignment();
        int id;
        id = urla.getId();

        if(id == R.id.next1)
        {
            getSupportActionBar().setTitle("Startup Recognition");
            getSupportFragmentManager().beginTransaction().replace(R.id.fr1, srf).commit();
        }
        if(id == R.id.next3)
        {
            getSupportActionBar().setTitle("Incubator Recognition");
            getSupportFragmentManager().beginTransaction().replace(R.id.fr2, irf).commit();
        }
        if(id == R.id.next4)
        {
            getSupportActionBar().setTitle("Advertisement");
            getSupportFragmentManager().beginTransaction().replace(R.id.fr3, af).commit();
        }
    }

}
