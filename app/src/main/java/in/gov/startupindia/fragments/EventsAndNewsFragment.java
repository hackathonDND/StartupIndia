package in.gov.startupindia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.gov.startupindia.R;

public class EventsAndNewsFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_and_news, container, false);

        ImageView imageView1 = (ImageView)view.findViewById(R.id.ennext1);
        ImageView imageView2 = (ImageView)view.findViewById(R.id.ennext2);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsAndNewsParts.class);
                URLassignment.setId(view.getId());
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsAndNewsParts.class);
                URLassignment.setId(view.getId());
                startActivity(intent);
            }
        });

        return view;
    }
}
