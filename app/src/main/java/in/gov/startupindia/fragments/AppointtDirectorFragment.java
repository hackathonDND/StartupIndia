package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;

import in.gov.startupindia.R;

public class AppointtDirectorFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_appointt_director, container,false);
        final Spinner spinner =(Spinner)layout.findViewById(R.id.spin2);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);
            android.widget.ListPopupWindow popupWindow = (android.widget.ListPopupWindow) popup.get(spinner);
            popupWindow.setHeight(600);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            URLassignment.setCheckURL(4);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final TextView impNote=(TextView)layout.findViewById(R.id.note);
        CheckBox checkboxvariable=(CheckBox)layout.findViewById(R.id.checkbox);
        checkboxvariable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    spinner.setEnabled(false);
                    impNote.setText("NOTE:Special Resolution which spells out the justification for appointment such a person should be passed in Extra Ordinary General Meeting");
                }
                else
                {
                    spinner.setEnabled(true);
                    impNote.setText("");
                }
            }
        });
        URLassignment.setCheckURL(4);
        return layout;
    }
}