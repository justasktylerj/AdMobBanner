package pineapple.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import pineapple.model.SaveState;
import android.widget.*;



import pineapple.controller.R;

public class ShopActivity extends AppCompatActivity
{
    private Button mainButton;
    private Button colorChangeTextBuy;
    private SaveState mySave;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mainButton = (Button) findViewById(pineapple.controller.R.id.mainButton);
        colorChangeTextBuy = (Button) findViewById(pineapple.controller.R.id.colorChangeTextBuy);
        mySave = (SaveState) getApplication();
        if (mySave.goal5 == true)
        {
            colorChangeTextBuy.setVisibility(View.GONE);
        }
        setUpListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpListeners()
    {
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                Intent myIntent = new Intent(buttonView.getContext(), MyActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        colorChangeTextBuy.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                if (mySave.PineCoins >= 50)
                {

                    mySave.PineCoins = -50 + mySave.PineCoins;
                    colorChangeTextBuy.setVisibility(View.GONE);
                    mySave.setGoal5(true);


                }
                else
                {

                }
            }
        });
    }
}
