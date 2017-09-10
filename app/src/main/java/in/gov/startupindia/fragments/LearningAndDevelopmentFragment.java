package in.gov.startupindia.fragments;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import in.gov.startupindia.R;

import static in.gov.startupindia.fragments.DownloadFragment.net;


public class LearningAndDevelopmentFragment extends Fragment {

    public LearningAndDevelopmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_and_development, container, false);
        WebView browser;

        browser = (WebView) view.findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());

        ConnectivityManager cManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && (nInfo.isConnected())) {
            net = true;
            browser.loadUrl("http://www.startupindia.gov.in/learning-development");
        }
        else {
            net=false;
            Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }
        browser.setBackgroundColor(Color.TRANSPARENT);
        Toast.makeText(getActivity(), "Please Wait...", Toast.LENGTH_SHORT);
        return view;
    }

}
