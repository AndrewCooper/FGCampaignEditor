package me.andrewcooper.fgcampaigns;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void campaignOpenButton(View v)
    {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
        Log.d("MainActivity", "Button1 was clicked ");
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent resultData)
    {
        if( requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK )
        {
            Uri uri = null;
            if( resultData != null) {
                uri = resultData.getData();
                Log.i("FGCE", "Uri: " + uri.toString());

            }
        }
    }
}
