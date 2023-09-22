package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.dao.MealDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private Double MIN_SUMMER_TEMP = 20.0;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal) {
        mealDao.save(meal);
    }

    public List<Meal> getMeals() {
        return mealDao.findAll();
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }

    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }

    public List<Meal> getSummerMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();

        if (currentTemperatureInCentigrade < MIN_SUMMER_TEMP) return new ArrayList<>();

        return mealDao.findByIsSummerMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=16.00&longitude=30.0&current_weather=true")
                    .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }
    private static List<Meal> mealList = new ArrayList<>();

    static {



        mealList.add(new Meal("Chicken Curry", "Delicious chicken curry with rice", 1.5, true));

    }

    public static List<Meal> getAllMeals() {
        return mealList;
    }
    public static Meal getMealByName(String name) {

        for (Meal meal : mealList) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return meal;
            }
        }
        return null;
    }
    public static Meal getMealByDescriptionMatch(String phrase) {

        for (Meal meal : mealList) {
            String[] words = meal.getDescription().split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(phrase)) {
                    return meal;
                }
            }
        }
        return null;
    }

}
