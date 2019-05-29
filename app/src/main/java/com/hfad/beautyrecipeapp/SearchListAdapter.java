package com.hfad.beautyrecipeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchViewHolder> implements Filterable {
    private Context context;
    private List<Recipe> recipeList;
    private List<Recipe> recipeListFiltered;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }


    public void setListener(Listener listener) {
        this.listener = listener;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{
        ImageView searchImageView;
        TextView searchTitleTextView;
        TextView searchCategoryTextView;

        public SearchViewHolder(@NonNull View searchView) {
            super(searchView);
            searchImageView = searchView.findViewById(R.id.recipe_list_image);
            searchTitleTextView = searchView.findViewById(R.id.recipe_list_title);
            searchCategoryTextView = searchView.findViewById(R.id.recipe_list_category);

        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
        }
    }


    public SearchListAdapter(List<Recipe> recipeList) {
        context = context;
        this.recipeList = recipeList;
        recipeListFiltered = new ArrayList<>(recipeList);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_recipe_list, parent, false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, final int position) {
        Recipe currentRecipe = recipeList.get(position);

        holder.searchImageView.setImageResource(currentRecipe.getImage_res_id());
        holder.searchTitleTextView.setText(currentRecipe.getTitle());
        holder.searchCategoryTextView.setText(currentRecipe.getCategory());

        holder.setOnClickListener(new View.OnClickListener() {
            private int position;

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Recipe> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(recipeListFiltered);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Recipe recipe : recipeListFiltered) {
                    if (recipe.getTitle().toLowerCase().contains(filterPattern)
                            || recipe.getCategory().toLowerCase().contains(filterPattern)) {
                        filteredList.add(recipe);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            recipeList.clear();
            recipeList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}


