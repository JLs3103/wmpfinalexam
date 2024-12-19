package com.example.wmp_final_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Course> coursesList;

    public CourseAdapter(Context context, ArrayList<Course> coursesList) {
        this.context = context;
        this.coursesList = coursesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = coursesList.get(position);
        holder.textViewCourseName.setText(course.getName());
        holder.textViewCredits.setText(course.getCredits() + " SKS");
        holder.checkBox.setChecked(course.isSelected());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            course.setSelected(isChecked);
            ((EnrollmentActivity) context).updateTotalCredits();
        });
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCourseName, textViewCredits;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourseName = itemView.findViewById(R.id.textViewCourseName);
            textViewCredits = itemView.findViewById(R.id.textViewCredits);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}