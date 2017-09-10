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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import in.gov.startupindia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadFragment extends Fragment {

    static boolean net;
    static int chk;
    String nameOfFile,myurl;
    public DownloadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_download, container, false);
        String[] text={"For reservation of your company's name you need to fill INC-1 form and upload it online on Ministry of Corporate Affairs site or you can visit their office to submit your application.",
                       "For Incorporation of One Person Company you need to fill Spice MOA,Spice AOA and Spice New form but these forms are not available for time being as they hae been recently introduced so we are providing you form INC-7(Form for Companies other than OPC) and if you want Spice forms you can visit their office.",
                       "For Incorporation of Company(Part I Company and Company with more than Seven Subscribers) you need to fill INC-7 form and upload it online on Ministry of Corporate Affairs site or you can visit their office to submit your application.",
                       "For Particulars of appointment of Directors and the key managerial personnel and the changes among them you need to fill DIR-12 form and upload it online on Ministry of Corporate Affairs site or you can visit their office to submit your application."};
        TextView info=(TextView)layout.findViewById(R.id.forminfo);
        if(URLassignment.getCheckURL()==1)
        {
            info.setText(text[0]);
        }
        else if(URLassignment.getCheckURL()==2)
        {
            info.setText(text[1]);
        }
        else if(URLassignment.getCheckURL()==3)
        {
            info.setText(text[2]);
        }
        else if(URLassignment.getCheckURL()==4)
        {
            info.setText(text[3]);
        }
        else{}
        Button bt=(Button)layout.findViewById(R.id.downloadbutton);
        if(URLassignment.getCheckForm()==1)
        {
            bt.setText("View Form");
        }
        else
        {
            bt.setText("Download Form");
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(URLassignment.getCheckURL()==1)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-1/Form_INC-1_help.pdf";
                else if(URLassignment.getCheckURL()==2)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-7/Form_INC-7_help.pdf";
                else if(URLassignment.getCheckURL()==3)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-7/Form_INC-7_help.pdf";
                else if(URLassignment.getCheckURL()==4)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/DIR-12/Form_DIR-12_help.pdf";
                else{}
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
                    if (net == true) {
                        isStoragePermissionGranted();
                        if (URLassignment.isStoragePermission() == true) {
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myurl));
                            request.setDescription("File is being Downloaded..");
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
                            DownloadManager dm = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }
            }
        });
        Button bt1=(Button)layout.findViewById(R.id.downloadbutton1);
        if(URLassignment.getCheckHelp()==1)
        {
            bt1.setText("View Instructions");
        }
        else
        {
            bt1.setText("Download Instructions");
        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(URLassignment.getCheckURL()==1)
                   myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-1/Form_INC-1_help.pdf";
                else if(URLassignment.getCheckURL()==2)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-7/Form_INC-7_help.pdf";
                else if(URLassignment.getCheckURL()==3)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/inc-7/Form_INC-7_help.pdf";
                else if(URLassignment.getCheckURL()==4)
                    myurl="https://raw.githubusercontent.com/techfreakworm/startupIndiaAppForms/master/DIR-12/Form_DIR-12_help.pdf";
                else{}
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
                    if (net == true) {
                        isStoragePermissionGranted();
                        if (URLassignment.isStoragePermission() == true) {
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myurl));
                            request.setDescription("File is being Downloaded..");
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
                            DownloadManager dm = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }
            }
        });
        return layout;
    }
    // Checking storage permission
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
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            URLassignment.setIsStoragePermission(true);
        }
        else
        {
            URLassignment.setIsStoragePermission(false);
        }
    }
    public void checkInternet()
    {
        ConnectivityManager cManager=(ConnectivityManager)getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo nInfo=cManager.getActiveNetworkInfo();
        if(nInfo!=null && (nInfo.isConnected()))
        {
            net=true;
        }
        else
        {
            Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            net=false;
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
