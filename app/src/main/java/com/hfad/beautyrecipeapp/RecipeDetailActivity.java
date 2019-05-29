package com.hfad.beautyrecipeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;



public class RecipeDetailActivity extends AppCompatActivity {
    public static final String EXTRA_RECIPE_ID = "recipeId";
    private ActionBar toolbar;
    private ShareActionProvider shareActionProvider;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //Set the toolbar as the activity's app bar
        toolbar = getSupportActionBar();
        toolbar.setTitle("Face mask recipe");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        toggleButton = (ToggleButton) findViewById(R.id.myToggleButton);

        final int recipeId = (Integer)getIntent().getExtras().get(EXTRA_RECIPE_ID);
        String recipeTitle = Recipe.recipes[recipeId].getTitle();
        TextView textViewTitle = (TextView)findViewById(R.id.recipe_detail_title);
        textViewTitle.setText(recipeTitle);

        String recipeCategory = Recipe.recipes[recipeId].getCategory();
        TextView textViewCat = (TextView)findViewById(R.id.recipe_detail_category);
        textViewCat.setText(recipeCategory);

        String recipeUseTime = Recipe.recipes[recipeId].getUse_time();
        TextView textViewUseTime = (TextView)findViewById(R.id.recipe_detail_use_time);
        textViewUseTime.setText(recipeUseTime);

        String recipeIngredients = Recipe.recipes[recipeId].getIngredients();
        TextView textViewIngredients = (TextView) findViewById(R.id.recipe_detail_ingredients);
        textViewIngredients.setText(recipeIngredients);


        String recipeDescription = Recipe.recipes[recipeId].getDescription();
        TextView textViewDescription = (TextView)findViewById(R.id.recipe_detail_description);
        textViewDescription.setText(recipeDescription);

        int recipeImage = Recipe.recipes[recipeId].getImage_res_id();
        ImageView imageView = (ImageView)findViewById(R.id.recipe_detail_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, recipeImage));
        imageView.setContentDescription(recipeTitle);

        boolean favorite = readState(recipeId);
        Log.d("favorite"," id "+recipeId + " has state of favorite: "+favorite);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d("is the button checked", "button");
                    // The toggle is enabled
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_black_24dp));
                    Toast.makeText(getApplicationContext(),"Added to Favorites",Toast.LENGTH_SHORT).show();
                }else {
                    // The toggle is disabled
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border_black_24dp));
                    Toast.makeText(getApplicationContext(), "Removed from Favorites", Toast.LENGTH_SHORT).show();
                }
                saveState(recipeId,isChecked);
            }
        });
        toggleButton.setChecked(favorite);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("");
        return super.onCreateOptionsMenu(menu);
    }

    //share intent
    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        int recipeId = (Integer)getIntent().getExtras().get(EXTRA_RECIPE_ID);
        String recipeTitle = Recipe.recipes[recipeId].getTitle();
        String recipeCategory = Recipe.recipes[recipeId].getCategory();
        String recipeUseTime = Recipe.recipes[recipeId].getUse_time();
        String recipeIngredients = Recipe.recipes[recipeId].getIngredients();
        String recipeDescription = Recipe.recipes[recipeId].getDescription();
        intent.putExtra(Intent.EXTRA_TEXT,  recipeTitle + '\n'
                + "Category: " + recipeCategory + '\n'
                +  "Use for: " + recipeUseTime + '\n'
                +  "Ingredients: " + recipeIngredients + '\n'
                +  "How to do: " + recipeDescription);
        shareActionProvider.setShareIntent(intent);
    }

    //save state of toggle button
    private void saveState(int id, boolean isFavorite) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferences.edit().putBoolean("State_"+id, isFavorite).commit();
        boolean state = sharedPreferences.getBoolean("State", false);
        Log.d("State read:",state + "");
    }
    private boolean readState(int id) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPreferences.getBoolean("State_" + id, false);
    }

}
