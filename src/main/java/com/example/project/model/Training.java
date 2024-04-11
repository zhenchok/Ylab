package com.example.project.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Training {
    private Date date;
    private int durationInMinutes;
    private Map<String, Integer> exercises;
    private String additionalInfo;

    public Training(Date date, int durationInMinutes, String additionalInfo) {
        this.date = date;
        this.durationInMinutes = durationInMinutes;
        this.additionalInfo = additionalInfo;
        this.exercises = new HashMap<>();
    }


    public void addExercise(String exercise, int caloriesPerMinute) {
        exercises.put(exercise, caloriesPerMinute);
    }

    public Date getDate() {
        return date;
    }

    public Map<String, Integer> getExercises() {
        return exercises;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }


    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return durationInMinutes == training.durationInMinutes &&
                Objects.equals(date, training.date) &&
                Objects.equals(exercises, training.exercises) &&
                Objects.equals(additionalInfo, training.additionalInfo);
    }

    public int hashCode() {
        return Objects.hash(date, exercises, durationInMinutes, additionalInfo);
    }

    public String toString() {
        return STR."Тренировка: Дата = \{date} ; Упражнение = \{exercises} ; Продолжительность тренировки (мин) = \{durationInMinutes} ; Дополнительная информация = \{additionalInfo}";
    }
}