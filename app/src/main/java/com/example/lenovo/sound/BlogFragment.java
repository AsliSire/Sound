package com.example.lenovo.sound;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlogFragment extends Fragment {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blog, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        viewPager = (ViewPager) view.findViewById(R.id.viewPagerBlog);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        //adding Pages
        adapter.AddFragment(new LastAddedFragment(), "SON EKLENENLER");
        adapter.AddFragment(new AlzTestFragment(), "TESTLER");
        adapter.AddFragment(new AboutAlzFragment(), "ALZPEDIA");

        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
