package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import in.gov.startupindia.R;


public class CompanyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_company, container,false);
        final Spinner spinner =(Spinner)layout.findViewById(R.id.spin1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String check = spinner.getSelectedItem().toString();
                URLassignment url=new URLassignment();
                if(check.equals("One Person Company(OPC)"))
                {
                    url.setCheckURL(2);
                }
                if(check.equals("Company(other than OPC)"))
                {
                    url.setCheckURL(3);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return layout;
    }
}