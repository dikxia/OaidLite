package com.river.oaidlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.river.oaidlite.helpers.DevicesIDsHelper;

public class MainActivity extends AppCompatActivity implements DevicesIDsHelper.AppIdsUpdater {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DevicesIDsHelper helper = new DevicesIDsHelper(this);
        helper.getOAID(this);
    }

    @Override
    public void OnIdsAvalid(@NonNull String ids) {
        Log.d("MainActivity", "OAID=" + ids);
    }
}
