package com.haerul.MealsRecipes.view.home;

import com.haerul.MealsRecipes.model.Categories;
import com.haerul.MealsRecipes.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
