package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/meal")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals() {
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
         return ResponseEntity.ok("2 + 2 = 4");
    }
    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        // Assuming you have a service that provides a list of Meal objects
        List<Meal> meals = MealService.getAllMeals();
        return meals;
    }
    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable String name) {
        // Assuming you have a service that provides a Meal object by name
        Meal meal = MealService.getMealByName(name);
        return meal;
    }
    @GetMapping("/meal/description-match/{phrase}")
    public Meal getMealByDescriptionMatch(@PathVariable String phrase) {

        Meal meal = MealService.getMealByDescriptionMatch(phrase);
        return meal;
    }
    @GetMapping("/meal/price")
    public List<Meal> getMealsByPriceRange(
            @RequestParam(name = "min") double minPrice,
            @RequestParam(name = "max") double maxPrice) {

        List<Meal> meals = MealService.getMealsByPriceRange(minPrice, maxPrice);
        return meals;
    }

}
