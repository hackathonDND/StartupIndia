package in.gov.startupindia.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import in.gov.startupindia.R;

public class Child1HomeFragment extends Fragment {

    Timer timer;
    int page = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company_registration, container, false);

        RemindTask remindTask = new RemindTask();

        return view;
    }

    String[] imURL = {"http://www.examveda.com/images/theory-image/current-affairs/2016/april/1459498688-union-government-launches-startup-india-portal-and-mobile-app.jpg",
            "http://2.bp.blogspot.com/-T6gE4JhAJ5Y/VptG0KTQV1I/AAAAAAAAA0M/s48eJCqhTkM/s1600/Startup%2BIndia.jpg",
            "http://i0.wp.com/thetechindia.in/wp-content/uploads/2016/03/independence-day-Modi-Speech-2.jpg?fit=800%2C445&resize=350%2C200",
            "http://www.startupindia.gov.in/assets/images/banner-1.jpg"};

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 5000); // delay
        // in
        // milliseconds
    }

    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        public ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            getActivity().runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 4) { // In my case the number of pages are 5
                        timer.cancel();
                        Toast.makeText(getActivity(), "Timer stoped",
                                Toast.LENGTH_LONG).show();
                    } else {
                        new DownloadImageTask((ImageView)
                                getView().findViewById(R.id.image)).execute(imURL[page++]);
                    }
                }
            });

        }
    }

}