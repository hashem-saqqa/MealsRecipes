package com.haerul.MealsRecipes.view.category;

import com.haerul.MealsRecipes.model.Meals;

import java.util.List;

public interface CategoryView {
    void showLoading();
    void hideLoading();
    void setMeals(List<Meals.Meal> meals);
    void onErrorLoading(String message);
}
