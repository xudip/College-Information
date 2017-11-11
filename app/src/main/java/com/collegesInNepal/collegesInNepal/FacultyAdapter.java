package com.collegesInNepal.collegesInNepal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import sap.collegesInNepal.R;

/**
 * Created by h on 8/21/16.
 */
public class FacultyAdapter extends BaseAdapter {
    private Context context;
    private String[] faculties;

    private int[] imageFaculties = {R.drawable.ic_it,R.drawable.ic_civil,R.drawable.ic_comp,R.drawable.ic_elx};

    public FacultyAdapter(MainActivity mainActivity, String[] faculties) {
        this.context = mainActivity;
        this.faculties = faculties;
    }

    @Override
    public int getCount() {
        return faculties.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = new View(context);
        gridView = inflater.inflate(R.layout.grid_item, null);
        TextView faculty = (TextView) gridView.findViewById(R.id.tvFacultyName);
        LinearLayout imgFaculty = (LinearLayout) gridView.findViewById(R.id.imageFaculty);

        faculty.setText(faculties[i]);
        imgFaculty.setBackgroundDrawable(context.getResources().getDrawable(imageFaculties[i]));
        return gridView;
    }
}
