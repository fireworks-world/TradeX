package com.example.tradex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;

public class Home extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FrameLayout frameLayout = findViewById(R.id.frmlyout);
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);
        loadFragment(new TradeXHomeView());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment=null;
                switch (menuItem.getItemId())
                {
                    case R.id.home:

                        fragment=new TradeXHomeView();

                        break;
                    case R.id.activity:


                        break;
                    case R.id.profile_pic:

                        break;

                    default:
                        return false;
                }
                return loadFragment(fragment);

            }
        });
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frmlyout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
