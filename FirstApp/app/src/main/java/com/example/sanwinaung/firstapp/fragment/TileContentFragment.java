package com.example.sanwinaung.firstapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanwinaung.firstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TileContentFragment extends Fragment {

    public TileContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tile, container, false);
    }

    public static class TileContentAdapter extends RecyclerView.Adapter<TileContentAdapter.TileViewHolder>{

        private static final int LENGTH = 18;

        @Override
        public TileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tile,parent,false);
            return new TileViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TileViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }

        public static class TileViewHolder extends RecyclerView.ViewHolder{

            public TileViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
