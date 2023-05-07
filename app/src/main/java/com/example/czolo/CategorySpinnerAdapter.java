package com.example.czolo;

import android.view.Gravity;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CategorySpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<List<String>> categoriesList;
    private List<String> labelsList;

    public CategorySpinnerAdapter(Context context, List<List<String>> categoriesList, List<String> labelsList) {
        this.context = context;
        this.categoriesList = categoriesList;
        this.labelsList = labelsList;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoriesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView categoryTextView = convertView.findViewById(android.R.id.text1);
        categoryTextView.setText(labelsList.get(position));
        categoryTextView.setTextSize(25);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView categoryTextView = convertView.findViewById(android.R.id.text1);
        categoryTextView.setText(labelsList.get(position));
        categoryTextView.setTextSize(25);

        return convertView;
    }
}
