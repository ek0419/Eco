package com.example.eco;

import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Omy on 20,julio,2020
 */
public class BaseActivity  extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean accion = false;
        Log.d(TAG, "empezando on key down");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                if (getSupportFragmentManager().getFragments().get(i) instanceof BaseFragment) {
                    BaseFragment fragment = (BaseFragment) getSupportFragmentManager().getFragments().get(i);
                    accion = accion || fragment.onBackPressed();
                }
            }
        }
        Log.d(TAG, " accion = " + accion);
        return accion || super.onKeyDown(keyCode, event);
    }
}
