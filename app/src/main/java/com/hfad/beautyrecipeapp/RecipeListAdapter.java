package com.hfad.beautyrecipeapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    private String[] titles;
    private String[] categories;
    private int[] imageIds;

    private Listener listener;

    private Context context;

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    public RecipeListAdapter(String[] titles, String[] categories, int[] imageIds) {
        this.titles = titles;
        this.categories = categories;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount(){
        return titles.length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_recipe_list, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.recipe_list_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(titles[position]);

        TextView titleTextView = (TextView) cardView.findViewById(R.id.recipe_list_title);
        titleTextView.setText(titles[position]);

        TextView categoryTextView = (TextView) cardView.findViewById(R.id.recipe_list_category);
        categoryTextView.setText(categories[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
