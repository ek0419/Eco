package com.example.eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eco.navegador.NavegadorFragment;
import com.example.eco.utilerias.UTUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzarNavegadorWE();
    }

    private void lanzarNavegadorWE() {
        UTUtils.lanzarFragment(getSupportFragmentManager(),R.id.container, new NavegadorFragment(),false);
    }

}