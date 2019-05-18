package com.example.lenovo.sound;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class AddToGuideFragment extends Fragment {

    private FragmentActivity context;
      FragmentManager fragmentManager;
      RelativeLayout lyAddToGuide;
      LinearLayout lyPersonOne;
      LinearLayout lyPersonTwo;
      LinearLayout lyPersonThree;




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (FragmentActivity) context;
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_to_guide, container, false);
        //Password Layout onClickmetod
        lyPersonOne =v.findViewById(R.id.lyPersonOne);
        lyPersonTwo =v.findViewById(R.id.lyPersonTwo);
        lyPersonThree =v.findViewById(R.id.lyPersonThree);
        lyPersonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAddToGuideDialogFragment newFragment =new UpdateAddToGuideDialogFragment();
                newFragment.show(getFragmentManager(), "personone");
            }
        });

        lyPersonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAddToGuideDialogFragment newFragment =new UpdateAddToGuideDialogFragment();
                newFragment.show(getFragmentManager(), "persontwo");
            }
        });

        lyPersonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAddToGuideDialogFragment newFragment =new UpdateAddToGuideDialogFragment();
                newFragment.show(getFragmentManager(), "personthree");
            }
        });




        return v;




    }


}
