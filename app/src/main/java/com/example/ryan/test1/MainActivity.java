package com.example.ryan.test1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    MainActivity.this.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fg, new fragment1(), null)
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    MainActivity.this.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fg, new fragment2(), null)
                            .addToBackStack(null)
                            .commit();

                    return true;
                case R.id.navigation_notifications:
                    MainActivity.this.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fg, new fragment3(), null)
                            .addToBackStack(null)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MainActivity.this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fg, new fragment1(), null)
                .addToBackStack(null)
                .commit();

    }

}
