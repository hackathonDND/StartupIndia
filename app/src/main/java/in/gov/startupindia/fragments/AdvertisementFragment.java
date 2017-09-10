package in.gov.startupindia.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import in.gov.startupindia.R;

public class AdvertisementFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View layout=inflater.inflate(R.layout.fragment_advertisement, container, false);
        Button bt=(Button)layout.findViewById(R.id.advertisementButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Web_View displaying Webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Advertise with us");

                WebView wv = new WebView(getActivity());
                wv.loadUrl("http://www.startupindia.gov.in/index.php");
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
        ImageView im=(ImageView)layout.findViewById(R.id.Fuse);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Web_View displaying Webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Fusion Charts");

                WebView wv = new WebView(getActivity());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.loadUrl("https://www.youtube.com/watch?v=XOogikleA78");
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
        ImageView im1=(ImageView)layout.findViewById(R.id.Adstring);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Web_View displaying Webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("AdstringO Private Limited");

                WebView wv = new WebView(getActivity());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.loadUrl("https://youtu.be/LCYtCLD76Ww");
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
        ImageView im2=(ImageView)layout.findViewById(R.id.Unac);
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Web_View displaying Webpages", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Unacademy");

                WebView wv = new WebView(getActivity());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.loadUrl("https://youtu.be/7_wu4H9aidY");
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
        ImageView im3=(ImageView)layout.findViewById(R.id.Pfiz);
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Link Expired", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }
}