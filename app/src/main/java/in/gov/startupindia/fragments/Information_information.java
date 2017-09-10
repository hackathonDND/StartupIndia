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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;

import java.io.File;

import in.gov.startupindia.R;

import static in.gov.startupindia.fragments.DownloadFragment.net;

public class Information_information extends AppCompatActivity {

    String nameOfFile, myurl;
    int chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_information);

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        mytoolbar.setTitleTextColor(0xFFFFFFFF);
        getSupportActionBar().setTitle("Information");


        CardView cardView1 = (CardView)findViewById(R.id.card1);
        CardView cardView2 = (CardView)findViewById(R.id.card2);
        CardView cardView3 = (CardView)findViewById(R.id.card3);
        CardView cardView4 = (CardView)findViewById(R.id.card4);
        CardView cardView5 = (CardView)findViewById(R.id.card5);
        CardView cardView6 = (CardView)findViewById(R.id.card6);
        CardView cardView7 = (CardView)findViewById(R.id.card7);
        CardView cardView8 = (CardView)findViewById(R.id.card8);
        CardView cardView9 = (CardView)findViewById(R.id.card9);
        CardView cardView10 = (CardView)findViewById(R.id.card10);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_incubators.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.ipcindia.nic.in/writereaddata/images/pdf/startups_IPRFacilitation_22April2016.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/pdf/Startup_India_FAQs.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_facilitators_for_trademarks.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_facilitators_for_patents.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_sebi_registered_funds.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_central_government_clearances.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/list_of_state_government_clearances.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/application_form_for_financial_assistance_for_organising_startup_events.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
        cardView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myurl="http://www.startupindia.gov.in/uploads/other/guidelines_for_corporates_to_set_up_incubators.pdf";

                nameOfFile= URLUtil.guessFileName(myurl,null, MimeTypeMap.getFileExtensionFromUrl(myurl));
                File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/"+nameOfFile);
                if(f.exists())
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(f),"application/pdf");
                    startActivity(intent);
                    chk=1;
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
                            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                            dm.enqueue(request);
                        }
                    }
                }

            }
        });
    }

    public void isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
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
        ConnectivityManager cManager = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && (nInfo.isConnected())) {
            net = true;
        } else {
            Toast.makeText(this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
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
            DownloadManager dm = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
            dm.enqueue(request);

        }
    }
}
