package in.gov.startupindia.activity;


import android.graphics.Color;

public class ColorSwitcher {

    public ColorSwitcher(int color)
    {
        MainActivity.navigationView.setBackgroundColor(color);
        MainActivity.tabLayout.setBackgroundColor(color);
        MainActivity.toolbar.setBackgroundColor(color);
    }
}
