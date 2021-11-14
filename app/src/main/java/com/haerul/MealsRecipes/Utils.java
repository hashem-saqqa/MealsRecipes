
package com.haerul.MealsRecipes;

import android.app.AlertDialog;
import android.content.Context;

import com.haerul.MealsRecipes.api.FoodApi;
import com.haerul.MealsRecipes.api.FoodClient;

public class Utils {

    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
