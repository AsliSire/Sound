package com.example.lenovo.sound;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PillFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pills, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recylerviewilac);

        PillsRecyclerAdapter productAdapter = new PillsRecyclerAdapter(this, new Pill().getData());
        recyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    class Pill {

        private String pillName;
        private int imageID;

    public Pill() {
        }

    public Pill(int imageID, String pillName) {
            this.imageID = imageID;
            this.pillName = pillName;
        }



        //    Getter and setter
        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }


        public String getPillName() {
            return pillName;
        }

        public void setPillName(String pillName) {
            this.pillName = pillName;
        }


        public ArrayList<Pill> getData() {
            ArrayList<Pill> pillList = new ArrayList<Pill>();
            int pillImages[] = {R.drawable.ic_add};
            String[] pillNames = {"Aspirin", "Majezik"};

            for (int i = 0; i < pillImages.length; i++) {
                Pill temp = new Pill();
                temp.setImageID(pillImages[i]);
                temp.setPillName(pillNames[i]);


                pillList.add(temp);

            }


            return pillList;


        }

    }

}
