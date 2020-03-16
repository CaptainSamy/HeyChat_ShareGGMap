package com.example.heychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UpDataAddress {


    FragmentManager fragmentManager;
    MapFrament mapFrament;
    ChatFrament chatFrament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Log.w("Size", fragmentManager.getFragments().size() + "");
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment instanceof ChatFrament) {
                chatFrament = (ChatFrament) fragment;
            }
            if (fragment instanceof MapFrament) {
                mapFrament = (MapFrament) fragment;
            }
        }
    }


    @Override
    public void UpDataChat(Location location) {

    }

    @Override
    public void UpDataMap(Location location) {
        chatFrament.updateAddress(location);
    }
}
