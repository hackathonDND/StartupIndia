package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import in.gov.startupindia.R;

public class EventsAndNewsParts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_and_news_parts);

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        mytoolbar.setTitleTextColor(0xFFFFFFFF);

        StatesConferenceFragment statesConferenceFragment = new StatesConferenceFragment();
        MeetingWithStartupFoundersFragment mwsff = new MeetingWithStartupFoundersFragment();

        int id;
        id = URLassignment.getId();

        if(id == R.id.ennext1)
        {
            getSupportActionBar().setTitle("State's Conference");
            getSupportFragmentManager().beginTransaction().replace(R.id.fr1, statesConferenceFragment).commit();
        }
        if(id == R.id.ennext2)
        {
            getSupportActionBar().setTitle("Meeting with Startup Founders");
            getSupportFragmentManager().beginTransaction().replace(R.id.fr2, mwsff).commit();
        }
    }
}
