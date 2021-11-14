package com.haerul.MealsRecipes.view.home;

import android.util.Log;

import androidx.annotation.NonNull;

import com.haerul.MealsRecipes.Utils;
import com.haerul.MealsRecipes.model.Categories;
import com.haerul.MealsRecipes.model.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getMeals() {
        Log.d("TAG", "getMeals: the start");
        view.showLoading();

        Call<Meals> mealsCall = Utils.getApi().getMeal();
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                Log.d("TAG", "onResponse: the second step");

                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    Log.d("TAG", "onResponse: true " + response.message());

                    view.setMeal(response.body().getMeals());

                } else {
                    view.onErrorLoading(response.message());
                    Log.d("TAG", "onResponse: false " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
                Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
                Log.d("TAG", "onFailure2: " + t.getMessage());
            }
        });
    }


    void getCategories() {

        view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {

                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {

                    view.setCategory(response.body().getCategories());

                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
