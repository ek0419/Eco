package com.example.eco.utilerias;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.eco.R;

/**
 * Created by Omy on 17,julio,2020
 */
public class UTUtils {

    public static void mostrarToas(Context context, String mensaje, boolean largaDuracion) {
        if (largaDuracion)
            Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public static void lanzarFragment(FragmentManager manager, int container, Fragment fragment, Boolean addToBackStack) {
        if (addToBackStack) {
            manager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).add(container, fragment).addToBackStack(null).commit();
            return;
        }
        manager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).add(container, fragment).commit();
    }

    public static void remplazarFragment(FragmentManager manager, int container, Fragment fragment, boolean addToBackStack) {
        if (addToBackStack) {
            manager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(container, fragment).addToBackStack(null).commit();
            return;
        }
        manager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(container, fragment).addToBackStack(null).commit();

    }


    private void lanzarActivity(Context context, Class<?> clsy, boolean finish) {
        Intent intent = new Intent(context, clsy);
        context.startActivity(intent);
        if (finish) {

        }
    }

}
