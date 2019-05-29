package com.hfad.beautyrecipeapp;

import java.util.Arrays;

public class Recipe {

    private int id;
    private String title;
    private String category;
    private String ingredients;
    private String description;
    private String use_time;
    private int image_res_id;
    private int isFav;


    public Recipe() {
        super();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", use_time='" + use_time + '\'' +
                ", image_res_id=" + image_res_id +
                ", isFav=" + isFav +
                '}';
    }

    public static final Recipe[] recipes = {
            new Recipe(1, "Remove shine", "Hydrating", "Banana, Organic honey, Fresh-squeezed orange juice", "First mash 1 fully ripe banana in a mixing bowl then add 2 tablespoons of organic honey and mix thoroughly. Stir in 1 teaspoon of fresh-squeezed orange juice. To put this hydrating mask to use, first wash your face with lukewarm water. Then massage the mask into your skin, making sure to completely cover your T-zone. Leave it on your face for 20 minutes to get all the hydrating benefits. Rinse the mask off with lukewarm water and pat your skin dry with a soft towel.", "20 minutes", R.drawable.recipe1, 0),
            new Recipe(2, "Treat acne with oatmeal", "Acne", "Dried oats, Organic honey, Whole milk", "First measure 3 tablespoons of dried oats into a blender and add 1 tablespoon of whole milk. Mix until you’ve made a paste and then drizzle 1 tablespoon of organic honey. When you’ve blended enough to make a smooth paste, remove the mix from the blender and apply it to your face. Be sure to cover your skin evenly. Let the mask dry for 20 minutes and then wash it off with clean water. Finish the process by patting your skin dry with a soft towel.", "20 minutes", R.drawable.recipe2, 0),
            new Recipe(3, "Brighten your skin", "Brightening", "Strawberries, Greek yogurt, Honey", "Using a blender, mash 3 ripe, medium-sized strawberries in a mixing bowl. Add 2 teaspoons of Greek yogurt and continue to mix. Mix in 1 teaspoon of honey to combine the mixture. Stir until the ingredients have a smooth consistency. You can leave this mask on for anywhere from 10 to 15 minutes. If you have a dry skin type, 10 minutes is probably best, whereas up to 15 minutes is better for women with an oily skin type.", "10-15 minutes", R.drawable.recipe3, 0),
            new Recipe(4, "Fight wrinkles with papaya", "Anti-aging", "Papaya, Milk, Honey", "First scoop half of the papaya into a blender or food processor and puree it. Then mix the papaya puree into a bowl with 1 tablespoon of honey and 2 teaspoons of milk. Stir the ingredients together until smooth and evenly mixed. Apply the mask and let it sit for about thirty minutes. Wash it off with warm water to reveal smoother skin!", "30 minutes", R.drawable.recipe4, 0),
            new Recipe(5, "Avocado for glowing skin", "Brightening", "1 ripe avocado, 1 tablespoon honey", "First peel the avocado and remove the seed. Mash the pulp properly so that no lumps remain. Add the honey to this pulp and mix well. Apply this all over the face and leave it on for 10 to 15 minutes. Rinse with lukewarm water.", "10-15 minutes", R.drawable.recipe5, 0),
            new Recipe(6, "Honey for acne-prone skin", "Acne", "1 tablespoon lemon juice, 1 tablespoon honey, 1 tablespoon baking soda", "Add lemon juice, honey and baking soda to a small bowl. Mix well and apply over the face and neck. Avoid the area near your eyes. Don’t turn this into a scrub by rubbing it into your skin. After 15 minutes, remove the mask with warm water, then with cold water.", "15 minutes", R.drawable.recipe6, 0),
            new Recipe(7, "Honey for dry skin", "Hydrating", "1 tablespoon jojoba oil, 1 tablespoon honey, ¼ mashed avocado, 2 tablespoons finely ground almonds", "Add honey and avocado to a small bowl and mash together. Stir in the ground almonds. Spread over the face and neck and after 20-25 minutes, rinse with warm water.", "25 minutes", R.drawable.recipe7, 0),
            new Recipe(8, "Honey and lavender", "Anti-aging", "3 tablespoons yogurt, 1 tablespoon honey, ¼ mashed avocado, 2 drops lavender oil", "When it comes to essential oils that help turn back time, lavender tops the list. This powerful purple plant creates a regenerative oil that assists with signs of aging and calms frayed nerves. A natural and powerful antibacterial, honey literally sweetens the deal as it’s loaded with antioxidants to help perfect and protect against aging aggressors. Combine all the ingredients in a bowl and apply a thick layer to the skin. Leave on for 15 minutes, then rinse clean with warm water.", "15 minutes", R.drawable.recipe8, 0),
            new Recipe(9, "Banana and honey mask", "Hydrating", "Banana, Organic honey, Fresh-squeezed orange juice", "First mash 1 fully ripe banana in a mixing bowl then add 2 tablespoons of organic honey and mix thoroughly. Stir in 1 teaspoon of fresh-squeezed orange juice. To put this hydrating mask to use, first wash your face with lukewarm water. Then massage the mask into your skin, making sure to completely cover your T-zone. Leave it on your face for 20 minutes to get all the hydrating benefits. Rinse the mask off with lukewarm water and pat your skin dry with a soft towel.", "20 minutes", R.drawable.recipe1, 0),
            new Recipe(10, "Oatmeal, honey mask", "Acne", "Dried oats, Organic honey, Whole milk", "First measure 3 tablespoons of dried oats into a blender and add 1 tablespoon of whole milk. Mix until you’ve made a paste and then drizzle 1 tablespoon of organic honey. When you’ve blended enough to make a smooth paste, remove the mix from the blender and apply it to your face. Be sure to cover your skin evenly. Let the mask dry for 20 minutes and then wash it off with clean water. Finish the process by patting your skin dry with a soft towel.", "20 minutes", R.drawable.recipe2, 0),
            new Recipe(11, "Strawberry and yogurt", "Brightening", "Strawberries, Greek yogurt, Honey", "Using a blender, mash 3 ripe, medium-sized strawberries in a mixing bowl. Add 2 teaspoons of Greek yogurt and continue to mix. Mix in 1 teaspoon of honey to combine the mixture. Stir until the ingredients have a smooth consistency. You can leave this mask on for anywhere from 10 to 15 minutes. If you have a dry skin type, 10 minutes is probably best, whereas up to 15 minutes is better for women with an oily skin type.", "10-15 minutes", R.drawable.recipe3, 0),
            new Recipe(12, "Papaya anti-aging", "Anti-aging", "Papaya, Milk, Honey", "First scoop half of the papaya into a blender or food processor and puree it. Then mix the papaya puree into a bowl with 1 tablespoon of honey and 2 teaspoons of milk. Stir the ingredients together until smooth and evenly mixed. Apply the mask and let it sit for about thirty minutes. Wash it off with warm water to reveal smoother skin!", "30 minutes", R.drawable.recipe4, 0),
            new Recipe(13, "Remove glowing", "Brightening", "1 ripe avocado, 1 tablespoon honey", "First peel the avocado and remove the seed. Mash the pulp properly so that no lumps remain. Add the honey to this pulp and mix well. Apply this all over the face and leave it on for 10 to 15 minutes. Rinse with lukewarm water.", "10-15 minutes", R.drawable.recipe5, 0),
            new Recipe(14, "Fight acne", "Acne", "1 tablespoon lemon juice, 1 tablespoon honey, 1 tablespoon baking soda", "Add lemon juice, honey and baking soda to a small bowl. Mix well and apply over the face and neck. Avoid the area near your eyes. Don’t turn this into a scrub by rubbing it into your skin. After 15 minutes, remove the mask with warm water, then with cold water.", "15 minutes", R.drawable.recipe6, 0),
            new Recipe(15, "No more dry skin", "Hydrating", "1 tablespoon jojoba oil, 1 tablespoon honey, ¼ mashed avocado, 2 tablespoons finely ground almonds", "Add honey and avocado to a small bowl and mash together. Stir in the ground almonds. Spread over the face and neck and after 20-25 minutes, rinse with warm water.", "25 minutes", R.drawable.recipe7, 0),
            new Recipe(16, "Lavender and yogurt", "Anti-aging", "3 tablespoons yogurt, 1 tablespoon honey, ¼ mashed avocado, 2 drops lavender oil", "When it comes to essential oils that help turn back time, lavender tops the list. This powerful purple plant creates a regenerative oil that assists with signs of aging and calms frayed nerves. A natural and powerful antibacterial, honey literally sweetens the deal as it’s loaded with antioxidants to help perfect and protect against aging aggressors. Combine all the ingredients in a bowl and apply a thick layer to the skin. Leave on for 15 minutes, then rinse clean with warm water.", "15 minutes", R.drawable.recipe8, 0)

    };


    private Recipe(int id, String title, String category, String ingredients, String description, String use_time, int image_res_id, int isFav) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.ingredients = ingredients;
        this.description = description;
        this.use_time = use_time;
        this.image_res_id = image_res_id;
        this.isFav = isFav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }

    public int getImage_res_id() {
        return image_res_id;
    }

    public void setImage_res_id(int image_res_id) {
        this.image_res_id = image_res_id;
    }

    public int getIsFav(){
        return isFav;
    }

    public void setIsFav(int isFav){
        this.isFav = isFav;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipe other = (Recipe) obj;
        if (id != other.id)
            return false;
        return true;
    }
}


