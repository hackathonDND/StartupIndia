package in.gov.startupindia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import in.gov.startupindia.R;

public class IncubatorRecognitionFragment extends Fragment {

    public CardView cardView1;
    public CardView cardView2;
    public CardView cardView3;
    URLassignment urLassignment = new URLassignment();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_incubator_recognition, container, false);

        cardView1 = (CardView)view.findViewById(R.id.card_ir1);
        cardView2 = (CardView)view.findViewById(R.id.card_ir2);
        cardView3 = (CardView)view.findViewById(R.id.card_ir3);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urLassignment.setId(v.getId());
                Toast.makeText(getActivity(), "Web_View displaying webpages", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}