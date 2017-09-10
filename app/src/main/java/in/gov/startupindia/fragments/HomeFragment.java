package in.gov.startupindia.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import in.gov.startupindia.R;
import io.fabric.sdk.android.Fabric;


public class HomeFragment extends Fragment {

    static String hashtag = null;
    public HomeFragment() {
        // Required empty public constructor
    }

    private static final String TAG = "TWITTER_PRUEBA";
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        listView = (ListView) view.findViewById(R.id.ListView);
        initFabric(getActivity());

        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(getActivity());
        hashtag = sharedPrefs.getString(getString(R.string.twitter_hashtag_key),getString(R.string.twitter_hashtag_default));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TweetTimelineListAdapter adapter = retrieveTimeLineByHashtag(getActivity(), hashtag);
        listView.setAdapter(adapter);
    }


    public static void initFabric(Context context){

        Log.d(TAG, "Initializing Fabric");

        if(!Fabric.isInitialized()) {


            TwitterAuthConfig authConfig = new TwitterAuthConfig("pFNkofhzNQjaPg0RRE9Hqklse", "yiWdHvdeNXRwzwfNc2eotJ5R1WOYe95Rz8InMuKTALwCwUxWgc");
            Fabric.with(context, new Twitter(authConfig));


        }else{
            Log.d(TAG, "Fabric already initialized");
        }
    }

    public static TweetTimelineListAdapter retrieveTimeLineByHashtag(Context context, String hashtag){
        Log.d(TAG, "Loading tweets with hashtag " + hashtag);
        SearchTimeline searchTimeline = new SearchTimeline.Builder().query(hashtag).build();
        return new TweetTimelineListAdapter.Builder(context).setTimeline(searchTimeline).build();
    }

    public static TweetTimelineListAdapter retrieveTimeLineByAccount(Context context, String account){
        Log.d(TAG, "Loading tweets from user " + account);
        UserTimeline userTimeline = new UserTimeline.Builder().screenName(account).build();
        return new TweetTimelineListAdapter.Builder(context).setTimeline(userTimeline).build();
    }


}

