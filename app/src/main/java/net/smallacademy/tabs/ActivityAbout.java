package net.smallacademy.tabs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.LibForumNew.R;


public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
