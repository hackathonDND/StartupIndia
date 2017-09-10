package in.gov.startupindia.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import in.gov.startupindia.R;

import static in.gov.startupindia.fragments.DownloadFragment.net;


public class StartupIndiaServicesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_startup_india_services, container, false);

        final URLassignment urla = new URLassignment();

        CardView cv1 = (CardView)view.findViewById(R.id.card1);
        CardView cv2 = (CardView)view.findViewById(R.id.card2);
        CardView cv3 = (CardView)view.findViewById(R.id.card3);
        final CardView cv4 = (CardView)view.findViewById(R.id.card4);

        ImageView next1 = (ImageView)view.findViewById(R.id.next1);
        ImageView next2 = (ImageView)view.findViewById(R.id.next2);
        ImageView next3 = (ImageView)view.findViewById(R.id.next3);
        ImageView next4 = (ImageView)view.findViewById(R.id.next4);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartUpIndiaServicesParts.class);
                urla.setId(v.getId());
                startActivity(intent);
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Web_View displaying webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Startup Benefits");


                WebView wv = new WebView(getActivity());
                wv.loadUrl("http://www.startupindia.gov.in/startup-registration.php");
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

            }
        });
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartUpIndiaServicesParts.class);
                urla.setId(v.getId());
                startActivity(intent);
            }
        });
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartUpIndiaServicesParts.class);
                urla.setId(v.getId());
                startActivity(intent);
            }
        });


        return view;
    }

}
