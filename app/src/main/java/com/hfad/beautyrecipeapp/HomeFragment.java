package com.hfad.beautyrecipeapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recipeRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_home, container, false);

        String[] recipeTitles = new String[Recipe.recipes.length];
        for (int i = 0; i < recipeTitles.length; i++) {
            recipeTitles[i] = Recipe.recipes[i].getTitle();
        }

        String[] recipeCategories = new String[Recipe.recipes.length];
        for (int i = 0; i < recipeCategories.length; i++) {
            recipeCategories[i] = Recipe.recipes[i].getCategory();
        }

        int[] recipeImages = new int[Recipe.recipes.length];
        for (int i = 0; i < recipeImages.length; i++) {
            recipeImages[i] = Recipe.recipes[i].getImage_res_id();
        }

        RecipeListAdapter adapter = new RecipeListAdapter(recipeTitles, recipeCategories, recipeImages);
        recipeRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recipeRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new RecipeListAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
                intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, position);
                getActivity().startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return recipeRecycler;
    }

}
