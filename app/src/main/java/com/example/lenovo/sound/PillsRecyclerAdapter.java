package com.example.lenovo.sound;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class PillsRecyclerAdapter extends RecyclerView.Adapter<PillsRecyclerAdapter.MyViewHolder> {

    ArrayList<PillFragment.Pill> mPillList;
    LayoutInflater inflater;

    public PillsRecyclerAdapter(PillFragment context, ArrayList<PillFragment.Pill> pills) {
        inflater = LayoutInflater.from(context.getContext());
        this.mPillList = pills;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pill_row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PillFragment.Pill selectedPill = mPillList.get(position);
        holder.setData(selectedPill, position);

    }

    @Override
    public int getItemCount() {
        return mPillList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView pillName;
        ImageView pillImage, deletepill;

        public MyViewHolder(View itemView) {
            super(itemView);
            pillImage = (ImageView) itemView.findViewById(R.id.pill_row_img);
            pillName = (TextView) itemView.findViewById(R.id.pill_row_text);
         /*   deletepill = (ImageView) itemView.findViewById(R.id.imgRecycleBin);
            deletepill.setOnClickListener(this);*/

        }

        public void setData(PillFragment.Pill selectedPill, int position) {

            this.pillName.setText(selectedPill.getPillName());
            this.pillImage.setImageResource(selectedPill.getImageID());

        }

        @Override
        public void onClick(View v) {

        }
    }
}