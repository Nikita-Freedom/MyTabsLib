package net.smallacademy.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.LibForumNew.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import net.smallacademy.tabs.Activities.LoginActivity;
import net.smallacademy.tabs.Place.PlaceActivity;


public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private ViewPager pager;
    private TabLayout mTabLayout;
    private TabItem firstItem,secondItem,thirdItem;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);

        firstItem = findViewById(R.id.firstItem);
        secondItem = findViewById(R.id.secondItem);
        thirdItem = findViewById(R.id.thirditem);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTabLayout.getTabCount());
        pager.setAdapter(adapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.menuTab){
            Intent intent = new Intent(MainActivity.this, PlaceActivity.class);
            startActivity(intent);
            //Toast.makeText(this, "Btn is clicked.", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.menuTab1){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            //Toast.makeText(this, "Btn is clicked111.", Toast.LENGTH_SHORT).show();
        }
        //if(item.getItemId() == R.id.menuTab2){
        //    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        //    startActivity(intent);
        //    //Toast.makeText(this, "Btn is clicked111.", Toast.LENGTH_SHORT).show();
        //}
        if(item.getItemId() == R.id.menuTab3){
            Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
            startActivity(intent);
            //Toast.makeText(this, "Btn is clicked111.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
