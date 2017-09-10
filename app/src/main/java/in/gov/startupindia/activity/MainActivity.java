package in.gov.startupindia.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.gov.startupindia.R;
import in.gov.startupindia.fragments.ActionPlanFragment;
import in.gov.startupindia.fragments.CompanyRegistrationFragment;
import in.gov.startupindia.fragments.ConnectFragment;
import in.gov.startupindia.fragments.EventsAndNewsFragment;
import in.gov.startupindia.fragments.HomeFragment;
import in.gov.startupindia.fragments.InformationFragment;
import in.gov.startupindia.fragments.LearningAndDevelopmentFragment;
import in.gov.startupindia.fragments.LearningProgramMobileFragment;
import in.gov.startupindia.fragments.OtherInitiativesFragment;
import in.gov.startupindia.fragments.StartupIndiaServicesFragment;

public class MainActivity extends AppCompatActivity {

    static Toolbar toolbar;
    static TabLayout tabLayout;
    private ViewPager viewPager;
    static NavigationView navigationView;
    static DrawerLayout drawerLayout;

    int[] tabIconsOrange = {
            R.drawable.ic_home_orange,
            R.drawable.ic_services_orange,
            R.drawable.ic_companyregistration_orange,
            R.drawable.ic_actionplan_orange,
            R.drawable.ic_information_orange,
            R.drawable.ic_initiatives_orange,
            R.drawable.ic_news_orange,
            R.drawable.ic_learning_orange,
            R.drawable.ic_learningprogram_orange,
            R.drawable.ic_connect_orange
    };

    int[] tabIconsWhite = {
            R.drawable.ic_home_white,
            R.drawable.ic_services_white,
            R.drawable.ic_companyregistration_white,
            R.drawable.ic_actionplan_white,
            R.drawable.ic_information_white,
            R.drawable.ic_initiatives_white,
            R.drawable.ic_news_white,
            R.drawable.ic_learning_white,
            R.drawable.ic_learningprogram_white,
            R.drawable.ic_connect_white
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int chk=0;
        int colorVal;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkInternet();
        getStarted();
        firebase();
        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(this);
        String color = sharedPrefs.getString(getString(R.string.color_key), getString(R.string.color_default));
        char b=color.charAt(0);
        for (int i = 1; i < 7; ++i)
        {
            char c = color.charAt(i);
            int a = c;
            if(!((a>=48 && a<=57) || (a>=65 && a<=70)||(a>=97 && a<=102)))
                chk=1;
        }
        if (chk == 1 || color.length() != 7 || b!='#')
        {
            colorVal = Color.parseColor("#000000");
        }
        else
            colorVal = Color.parseColor(color);
        new ColorSwitcher(colorVal);
    }
    public void getStarted () {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        navigationView = (NavigationView) findViewById(R.id.nvView);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.sis:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.cr:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.ap:
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.info:
                        viewPager.setCurrentItem(4);
                        return true;
                    case R.id.oi:
                        viewPager.setCurrentItem(5);
                        return true;
                    case R.id.ean:
                        viewPager.setCurrentItem(6);
                        return true;
                    case R.id.lad:
                        viewPager.setCurrentItem(7);
                        return true;
                    case R.id.lpma:
                        viewPager.setCurrentItem(8);
                        return true;
                    case R.id.connect:
                        viewPager.setCurrentItem(9);
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        //Change title in toolbar while sliding the tabs
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        viewPager.setCurrentItem(0);
                        toolbar.setTitle("Home");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        toolbar.setTitle("StartUp India Services");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        toolbar.setTitle("Company Registration");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
                        toolbar.setTitle("Action Plan");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 4:
                        viewPager.setCurrentItem(4);
                        toolbar.setTitle("Information");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 5:
                        viewPager.setCurrentItem(5);
                        toolbar.setTitle("Other Initiatives");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 6:
                        viewPager.setCurrentItem(6);
                        toolbar.setTitle("Events and News");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 7:
                        viewPager.setCurrentItem(7);
                        toolbar.setTitle("Learning & Development");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 8:
                        viewPager.setCurrentItem(8);
                        toolbar.setTitle("Learning Program App");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);

                        break;
                    case 9:
                        viewPager.setCurrentItem(9);
                        toolbar.setTitle("Connect");
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsOrange[tab.getPosition()]);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 1:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 2:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 3:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 4:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 5:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 6:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 7:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 8:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                    case 9:
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsWhite[tab.getPosition()]);
                        break;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }
    @Override
    public void onBackPressed()
    {
        DrawerLayout layout=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(layout.isDrawerOpen(GravityCompat.START)){
            layout.closeDrawer(GravityCompat.START);
        }
        else
            if(viewPager.getCurrentItem()>0)
            {
                viewPager.setCurrentItem(0,true);
            }
            else
                if(viewPager.getCurrentItem()==0)
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.app_name);
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setMessage("Do you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                                public  void onClick(DialogInterface dialog, int id){
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert=builder.create();
                    alert.show();

                }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.share:
                Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"StartupIndia Application");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id=com.startupindia");
                startActivity(Intent.createChooser(sharingIntent,"Share via"));
                break;
            case R.id.web:Toast.makeText(this, "Web_View displaying Webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Website Policy");

                WebView wv = new WebView(this);
                wv.loadUrl("http://www.startupindia.gov.in/website-policy.php");
                wv.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                alert.setView(wv);
                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                break;
            case R.id.dis:
                AlertDialog.Builder alert1 = new AlertDialog.Builder(this);
                alert1.setTitle("Disclaimer");


                WebView wv1 = new WebView(this);
                wv1.loadUrl("http://www.startupindia.gov.in/disclaimer.php");
                wv1.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                alert1.setView(wv1);
                alert1.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert1.show();
                break;
            case R.id.terms:
                AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
                alert2.setTitle("Terms of Use");

                WebView wv2 = new WebView(this);
                wv2.loadUrl("http://www.startupindia.gov.in/terms-of-use.php");
                wv2.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                alert2.setView(wv2);
                alert2.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert2.show();
                break;
            case R.id.help:
                AlertDialog.Builder alert3 = new AlertDialog.Builder(this);
                alert3.setTitle("Help");

                WebView wv3 = new WebView(this);
                wv3.loadUrl("http://www.startupindia.gov.in/help.php");
                wv3.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                alert3.setView(wv3);
                alert3.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                alert3.show();
                break;





        }

        return super.onOptionsItemSelected(item);
    }


    private void setupTabIcons() {

        tabLayout.getTabAt(0).setIcon(tabIconsOrange[0]);
        tabLayout.getTabAt(1).setIcon(tabIconsWhite[1]);
        tabLayout.getTabAt(2).setIcon(tabIconsWhite[2]);
        tabLayout.getTabAt(3).setIcon(tabIconsWhite[3]);
        tabLayout.getTabAt(4).setIcon(tabIconsWhite[4]);
        tabLayout.getTabAt(5).setIcon(tabIconsWhite[5]);
        tabLayout.getTabAt(6).setIcon(tabIconsWhite[6]);
        tabLayout.getTabAt(7).setIcon(tabIconsWhite[7]);
        tabLayout.getTabAt(8).setIcon(tabIconsWhite[8]);
        tabLayout.getTabAt(9).setIcon(tabIconsWhite[9]);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "");
        adapter.addFrag(new StartupIndiaServicesFragment(), "");
        adapter.addFrag(new CompanyRegistrationFragment(), "");
        adapter.addFrag(new ActionPlanFragment(), "");
        adapter.addFrag(new InformationFragment(), "");
        adapter.addFrag(new OtherInitiativesFragment(), "");
        adapter.addFrag(new EventsAndNewsFragment(), "");
        adapter.addFrag(new LearningAndDevelopmentFragment(), "");
        adapter.addFrag(new LearningProgramMobileFragment(), "");
        adapter.addFrag(new ConnectFragment(), "");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }

    // function to check internet connectivity
    public void checkInternet()
    {
        ConnectivityManager cManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo=cManager.getActiveNetworkInfo();
        if(nInfo!=null && (nInfo.isConnected()))
        {
        }
        else
        {
            Toast.makeText(this, "Check your Internet Connection", Toast.LENGTH_LONG).show();
        }
    }
    public void firebase()
    {
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d("MainActivity", "Key: " + key + " Value: " + value);
            }
        }
    }
}
