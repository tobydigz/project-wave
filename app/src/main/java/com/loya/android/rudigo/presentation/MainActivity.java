package com.loya.android.rudigo.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loya.android.rudigo.R;
import com.loya.android.rudigo.data.model.Idea;
import com.loya.android.rudigo.presentation.ideaslist.adapter.IdeaAdapter;
import com.loya.android.rudigo.presentation.ideaslist.adapter.IdeaDelegateAdapter;
import com.loya.android.rudigo.presentation.newidea.NewThreadActivity;
import com.loya.android.rudigo.presentation.userprofile.UserProfileActivity;

public class MainActivity extends AppCompatActivity implements IdeaDelegateAdapter.onViewSelectedListener {
    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    private IdeaAdapter ideaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds the recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Create Navigation drawer and inflate layout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_more_vert_black);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Adds a toggle button to the Main Activity that displays the navigation bar
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        // Set behavior of Navigation drawer
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);
                        // TODO: handle navigation
                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        // Adding Floating Action Button to bottom right of main view
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an AlertDialog.Builder object
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                //inflate the MainActivity with the new_thread Activity
                View mView = getLayoutInflater().inflate(R.layout.activity_new_thread, null);
                EditText ideaEditText = (EditText) mView.findViewById(R.id.idea_editText);
                EditText rationalEditText = (EditText) mView.findViewById(R.id.rational_editText);
                EditText effectEditText = (EditText) mView.findViewById(R.id.effect_editText);
                Button btnSubmit = (Button) mView.findViewById(R.id.submit_button);

                //set the view for the layout
                mBuilder.setView(mView);
                //create a dialog
                AlertDialog dialog = mBuilder.create();
                //show the dialog
                dialog.show();

//                btnSubmit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(NewThreadActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                });

//
//                Intent intent = new Intent(MainActivity.this, NewThreadActivity.class);
//                startActivity(intent);

            }
        });

    }

    private void initialiseRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ideaAdapter = new IdeaAdapter(this);
        recyclerView.setAdapter(ideaAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void profileOnclick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
        startActivity(intent);
    }


    public void newThreadOnclick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, NewThreadActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(@NonNull Idea idea) {

    }

    @Override
    public void onDownVoteClicked(long commentId, boolean action) {

    }

    @Override
    public void onUpVoteClicked(long commentId, boolean action) {

    }

    @Override
    public void onFavoriteClicked(long commentId, boolean action) {

    }
}
