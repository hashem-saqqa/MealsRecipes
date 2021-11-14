package com.haerul.MealsRecipes.view.detail;

import com.haerul.MealsRecipes.model.Meals;

public interface DetailView {
    void showLoading();

    void hideLoading();

    void setMeal(Meals.Meal meal);

    void onErrorLoading(String message);
}
