package com.knoxpo.palak.bunk_recorder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BunkFragment extends Fragment {
    private RecyclerView mListRV;
    private List<Bunk> mBunks;
    private TextView mTotalBunks;
    int count =0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bunk, container, false);
        init(v);
        mTotalBunks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        BunkAdapter adapter = new BunkAdapter();
        mListRV.setAdapter(adapter);
        mListRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    private void init(View v) {
        mListRV = v.findViewById(R.id.recycler_view_id);
        mTotalBunks=v.findViewById(R.id.total_no_bunks);
        mBunks = new ArrayList<>();


        int totalDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i <= totalDay; i++) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.DATE, i);
            Date date = cal.getTime();
            Bunk bunk = new Bunk(date);
            mBunks.add(bunk);

        }
    }

    private class BunkAdapter extends RecyclerView.Adapter<BunkVH> {
        private LayoutInflater mLayoutInflater;

        BunkAdapter() {
            mLayoutInflater = LayoutInflater.from(getActivity());
        }

        @NonNull
        @Override
        public BunkVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(R.layout.fragment_bunk_list, parent, false);
            return new BunkVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BunkVH holder, int position) {
            holder.bindBunk(mBunks.get(position));
        }

        @Override
        public int getItemCount() {
            return mBunks.size();
        }
    }

    private class BunkVH extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
        private TextView mTextView;
        private CheckBox mCheckbox;
        private Bunk mBunk;

        public BunkVH(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.TextView1);
            mCheckbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }

        public void bindBunk(Bunk bunk) {
            mBunk = bunk;

            mTextView.setText(bunk.getDate().toString());
            mCheckbox.setChecked(bunk.isBunked());
            mCheckbox.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mBunk.setBunked(isChecked);

            count = 0;

            for(int i=0;i<mBunks.size();i++)
            {
                if(mBunks.get(i).isBunked()==true){
                    count ++;
                }
                mTotalBunks.setText("total no. of bunks:"+count);
            }


        }

    }

}