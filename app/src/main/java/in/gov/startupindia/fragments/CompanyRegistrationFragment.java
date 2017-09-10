package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.gov.startupindia.R;

public class CompanyRegistrationFragment extends Fragment {
    private static final String TAG="MainActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_company_registration, container, false);
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ChildCompanyRegistrationFragment ccrf = new ChildCompanyRegistrationFragment();
        ft.replace(R.id.contain, ccrf);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        
	return layout;
    }
}