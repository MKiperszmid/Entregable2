package com.martin.kiperszmid.entregable.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

public class MainActivity extends AppCompatActivity implements FragmentRecetas.NotificarResetaActivity {
    private ActionBarDrawerToggle drawerToggle;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final DrawerLayout drawerLayout = findViewById(R.id.drawerlayoutMain);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Abrir, R.string.Cerrar);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigationviewMain);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.itemRecetas:
                        fragment = new FragmentRecetas();
                        break;
                    case R.id.itemAboutus:
                        fragment = new FragmentAboutUS();
                        break;
                }
                cargarFragment(fragment);

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void cargarFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragmentHolder, fragment);
        transaction.commit();

    }

    @Override
    public void notificarReseta(Receta receta) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalleReceta.RECETA_KEY, receta);
        FragmentDetalleReceta detalleReceta = new FragmentDetalleReceta();
        detalleReceta.setArguments(bundle);
        cargarFragment(detalleReceta);
    }
}
