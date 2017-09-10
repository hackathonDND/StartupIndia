package in.gov.startupindia.fragments;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;

import java.io.File;

import in.gov.startupindia.R;

import static in.gov.startupindia.fragments.DownloadFragment.net;

public class OtherInitiativesFragment extends Fragment {

    String myurl, nameOfFile;
    int chk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other_initiatives, container, false);

        CardView cardView1 = (CardView) view.findViewById(R.id.card1);
        CardView cardView2 = (CardView) view.findViewById(R.id.card2);
        CardView cardView3 = (CardView) view.findViewById(R.id.card3);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl = "http://www.startupindia.gov.in/uploads/pdf/SIDBI_in_the_States_Conference.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    chk=1;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                }
                else {
                    chk=0;
                    checkInternet();
                    if (net == true ) {
                        isStoragePermissionGranted();
                        if (URLassignment.isStoragePermission() == true) {
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myurl));
                            request.setDescription("File is being Downloaded..");
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
                            DownloadManager dm = (DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InitiativeByBanks.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (getActivity().checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                URLassignment.setIsStoragePermission(true);
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        } else {
            URLassignment.setIsStoragePermission(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            URLassignment.setIsStoragePermission(true);
        } else {
            URLassignment.setIsStoragePermission(false);
        }
    }

    public void checkInternet() {
        ConnectivityManager cManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && (nInfo.isConnected())) {
            net = true;
        } else {
            Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            net = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (URLassignment.isStoragePermission() == true && chk==0) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myurl));
            request.setDescription("File is being Downloaded..");
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
            DownloadManager dm = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
            dm.enqueue(request);

        }
    }

}
