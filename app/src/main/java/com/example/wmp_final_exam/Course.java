package com.example.wmp_final_exam;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int credits;
    private boolean selected;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.selected = false;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}