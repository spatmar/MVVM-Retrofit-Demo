package com.spatmar.mvvmretrofitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.spatmar.mvvmretrofitdemo.R;
import com.spatmar.mvvmretrofitdemo.databinding.ResultListItemBinding;
import com.spatmar.mvvmretrofitdemo.model.Result;
import com.spatmar.mvvmretrofitdemo.view.MovieDetailsActivity;

import java.util.ArrayList;

public class ResultAdapter
        extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private Context context;
    private ArrayList<Result> results;

    public ResultAdapter(Context context, ArrayList<Result> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ResultListItemBinding resultListItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.result_list_item, parent, false);
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.result_list_item, parent, false);
        return new ResultViewHolder(resultListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {

//        holder.titleTextView.setText(results.get(position).getTitle());
//        holder.popularityTextView.setText(results.get(position).getReleaseDate());

        Result result = results.get(position);
        holder.resultListItemBinding.setResult(result);
//        Glide.with(context)
//                .load(imagePath)
//                .placeholder(R.drawable.progress_circle)
//                .into(holder.movieImageView);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        private ResultListItemBinding resultListItemBinding;

        public ResultViewHolder(@NonNull ResultListItemBinding resultListItemBinding) {
            super(resultListItemBinding.getRoot());
            this.resultListItemBinding = resultListItemBinding;


            resultListItemBinding.getRoot()
                    .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {

                        Result result = results.get(position);
                        Intent intent = new Intent(context, MovieDetailsActivity.class);
                        intent.putExtra("movieData", result);
                        context.startActivity(intent);

                    }

                }
            });
        }
    }
}
