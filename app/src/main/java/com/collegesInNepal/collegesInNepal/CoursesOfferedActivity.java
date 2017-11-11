package com.collegesInNepal.collegesInNepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import sap.collegesInNepal.R;

/**
 * Created by h on 8/19/16.
 */
public class CoursesOfferedActivity extends AppCompatActivity {

    TextView faculty, facultyText, firstSem, secondSem, thirdSem, fourthSem, fifthSem, sixthSem, seventhSem, eightSem;
    ImageView imgFaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_courses_offered);

        faculty = (TextView) findViewById(R.id.tvFaculty);
        facultyText = (TextView) findViewById(R.id.tvFacultyText);
        imgFaculty = (ImageView) findViewById(R.id.imageFaculty);
        firstSem = (TextView) findViewById(R.id.tvSemOne);
        secondSem = (TextView) findViewById(R.id.tvSemTwo);
        thirdSem = (TextView) findViewById(R.id.tvSemThree);
        fourthSem = (TextView) findViewById(R.id.tvSemFour);
        fifthSem = (TextView) findViewById(R.id.tvSemFive);
        sixthSem = (TextView) findViewById(R.id.tvSemSix);
        seventhSem = (TextView) findViewById(R.id.tvSemSeven);
        eightSem = (TextView) findViewById(R.id.tvSemEight);


        Intent intent = getIntent();
        String faculty = intent.getStringExtra("Faculty");

        if (faculty.equalsIgnoreCase("IT")) {
            Log.e("data inserted", "it is it");

        } else if (faculty.equalsIgnoreCase("Civil")) {
            assignCivilSubjects();

        } else if (faculty.equalsIgnoreCase("Computer")) {
            assignComputerSubjects();

        } else if (faculty.equalsIgnoreCase("Electronics")) {
            assignElectronicSubjects();
        }


    }

    private void assignCivilSubjects() {
        faculty.setText(getResources().getText(R.string.civFaculty));
        facultyText.setText(getResources().getText(R.string.civText));
        imgFaculty.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_civil));
        firstSem.setText(getResources().getText(R.string.civFirst));
        secondSem.setText(getResources().getText(R.string.civSecond));
        thirdSem.setText(getResources().getText(R.string.civThird));
        fourthSem.setText(getResources().getText(R.string.civFourth));
        fifthSem.setText(getResources().getText(R.string.civFifth));
        sixthSem.setText(getResources().getText(R.string.civSixth));
        seventhSem.setText(getResources().getText(R.string.civSeventh));
        eightSem.setText(getResources().getText(R.string.civEighth));
    }

    private void assignElectronicSubjects() {
        faculty.setText(getResources().getText(R.string.elxFaculty));
        facultyText.setText(getResources().getText(R.string.elxText));
        imgFaculty.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_elx));
        firstSem.setText(getResources().getText(R.string.elxFirst));
        secondSem.setText(getResources().getText(R.string.elxSecond));
        thirdSem.setText(getResources().getText(R.string.elxThird));
        fourthSem.setText(getResources().getText(R.string.elxFourth));
        fifthSem.setText(getResources().getText(R.string.elxFifth));
        sixthSem.setText(getResources().getText(R.string.elxSixth));
        seventhSem.setText(getResources().getText(R.string.elxSeventh));
        eightSem.setText(getResources().getText(R.string.elxEighth));

    }

    private void assignComputerSubjects() {
        faculty.setText(getResources().getText(R.string.bceFaculty));
        facultyText.setText(getResources().getText(R.string.textBce));
        imgFaculty.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_comp));
        firstSem.setText(getResources().getText(R.string.bceFirst));
        secondSem.setText(getResources().getText(R.string.bceSecond));
        thirdSem.setText(getResources().getText(R.string.bceThird));
        fourthSem.setText(getResources().getText(R.string.bceFourth));
        fifthSem.setText(getResources().getText(R.string.bceFifth));
        sixthSem.setText(getResources().getText(R.string.bceSixth));
        seventhSem.setText(getResources().getText(R.string.bceSeventh));
        eightSem.setText(getResources().getText(R.string.bceEighth));

    }
}
