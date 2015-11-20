/*
 * Copyright (C) 2013 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pineapple.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.widget.ImageView;
import android.content.Intent;
import pineapple.model.SaveState;
import android.graphics.Color;
import android.widget.TextView;



/**
 * Main Activity. Inflates main activity xml and child fragments.
 */
public class MyActivity extends Activity
{

    private AdView myAdView;
    private Button pineApples;
    private ImageView pinePic;
    private Button AchieveButton;
    private SaveState mySave;
    private TextView count;
    private Button shop;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(pineapple.controller.R.layout.activity_my);

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml
        pineApples = (Button) findViewById(pineapple.controller.R.id.pineApples);
        myAdView = (AdView) findViewById(pineapple.controller.R.id.ad_view);
        pinePic = (ImageView) findViewById(pineapple.controller.R.id.pinePic);
        AchieveButton = (Button) findViewById(pineapple.controller.R.id.AchieveButton);
        mySave = (SaveState) getApplication();
        count = (TextView) findViewById(pineapple.controller.R.id.count);
        shop = (Button) findViewById(pineapple.controller.R.id.shop);


        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        myAdView.loadAd(adRequest);

        count.setTextColor(Color.rgb(255, 255, 255));

        setUpListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(pineapple.controller.R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == pineapple.controller.R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Called when leaving the activity */
    @Override
    public void onPause()
    {
        if (myAdView != null)
        {
            myAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume()
    {
        super.onResume();
        if (myAdView != null)
        {
            myAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy()
    {
        if (myAdView != null)
        {
            myAdView.destroy();
        }
        super.onDestroy();
    }

    //if the pineapple is there, it disappears when button clicked, if gone the pineapple appears when button is clicked
    private void setUpListeners()
    {
        AchieveButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                Intent myIntent = new Intent(buttonView.getContext(), Achievments.class);
                startActivityForResult(myIntent, 0);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View buttonView) {
                Intent myIntent = new Intent(buttonView.getContext(), ShopActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        pineApples.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                if (pinePic.getVisibility() == View.INVISIBLE)
                {
                    pinePic.setVisibility(View.VISIBLE);
                    pineApples.setText("Eat pineapple");

                }

                else
                {
                    pinePic.setVisibility(View.INVISIBLE);
                    pineApples.setText("Click for pineapples");
                    count.setText("PineApples:" + mySave.PineCoins);

                    mySave.PineCoins = 1 + mySave.PineCoins;
                    mySave.PineTotal = 1 + mySave.PineTotal;
                }

//achievments statments

                if (mySave.PineTotal == 11)
                {
                   mySave.setGoal1(true);
                    pineApples.setText("Achievment earned");
                    mySave.PineCoins = 11;

                }
                if (mySave.PineTotal == 51)
                {
                    mySave.setGoal2(true);
                    pineApples.setText("Achievment earned");
                    mySave.PineTotal = 51;
                }
                if (mySave.PineTotal == 251)
                {
                    mySave.setGoal3(true);
                    pineApples.setText(" Super Achievment earned");
                    mySave.PineTotal = 251;

                }
                if (mySave.PineTotal == 1001)
                {
                    mySave.setGoal4(true);
                    pineApples.setText(" Super Achievment earned");
                    mySave.PineTotal = 1001;
                }
            }
        });
    }
}
