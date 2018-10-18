package kono.mobiuni.View.Classes;

public class Lesson {
    double rating;
    String name;
    String categoryImg;
    String lessonId;

    public String getLessonId() {
        return lessonId;
    }

    public Lesson(double rating, String name, String categoryImg) {
        this.rating = rating;
        this.name = name;
        this.categoryImg = categoryImg;
    }

    public Lesson(double rating, String name, String categoryImg, String lessonId) {
        this.rating = rating;
        this.name = name;
        this.categoryImg = categoryImg;
        this.lessonId = lessonId;
    }

    public double getRating() {
        return rating;

    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }
}
