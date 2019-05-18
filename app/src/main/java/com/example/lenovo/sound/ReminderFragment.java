package com.example.lenovo.sound;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReminderFragment extends Fragment {


    private FragmentActivity context;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_reminder);

        }

    public List<ReminderFragment.ColumnItem> Column1() {
        List<ReminderFragment.ColumnItem> column1 = new ArrayList<>();
        column1.add(new ColumnItem("1"));
        column1.add(new ColumnItem("2"));
        column1.add(new ColumnItem("3"));
        column1.add(new ColumnItem("4"));
        column1.add(new ColumnItem("5"));
        column1.add(new ColumnItem("6"));
        column1.add(new ColumnItem("7"));
        column1.add(new ColumnItem("8"));
        column1.add(new ColumnItem("9"));
        column1.add(new ColumnItem("10"));
        column1.add(new ColumnItem("15"));
            return column1;
    }

    public List<ReminderFragment.ColumnItem> Column2() {
        List<ReminderFragment.ColumnItem> column2 = new ArrayList<>();
        column2.add(new ColumnItem("Dakikada"));
        column2.add(new ColumnItem("Saatte"));
        column2.add(new ColumnItem("Günde"));
        column2.add(new ColumnItem("Haftada"));
        column2.add(new ColumnItem("Ayda"));
        column2.add(new ColumnItem("Yılda"));
        return column2;
    }

    public List<ReminderFragment.ColumnItem> Column3() {
        List<ReminderFragment.ColumnItem> column3 = new ArrayList<>();
        column3.add(new ColumnItem("1"));
        column3.add(new ColumnItem("2"));
        column3.add(new ColumnItem("3"));
        column3.add(new ColumnItem("4"));
        column3.add(new ColumnItem("5"));
        return column3;
    }

    private void setContentView(int fragment_reminder) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_reminder, container, false);

        RecyclerView recyclerViewfirst = (RecyclerView) v.findViewById(R.id.recylerview);
        RecyclerView recyclerViewsecond = (RecyclerView) v.findViewById(R.id.recylerviewtwo);
        RecyclerView recyclerViewthird = (RecyclerView) v.findViewById(R.id.recylerviewthree);


        ReminderRecyclerAdapterColumn1 adapterfirst = new ReminderRecyclerAdapterColumn1(getActivity(), Column1(), this.context.getSupportFragmentManager());
        ReminderRecyclerAdapterColumn2 adaptersecond = new ReminderRecyclerAdapterColumn2(getActivity(), Column2(), this.context.getSupportFragmentManager());
        ReminderRecyclerAdapterColumn3 adapterthird = new ReminderRecyclerAdapterColumn3(getActivity(), Column3(), this.context.getSupportFragmentManager());

        return v;
    }



    class ColumnItem{
            String title;

        ColumnItem(String title){
            this.title=title;

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }





    }


}