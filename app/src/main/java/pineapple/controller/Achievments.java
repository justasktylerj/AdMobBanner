package pineapple.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.*;
import android.content.Intent;
import android.graphics.Color;
import pineapple.model.SaveState;


public class Achievments extends AppCompatActivity
{
    private TextView trophy1;
    private TextView trophy2;
    private TextView trophy3;
    private TextView trophy4;
    private TextView trophy5;

    private Button homeButton;
    private SaveState mySave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(pineapple.controller.R.layout.activity_achievments);

        trophy1 = (TextView) findViewById(pineapple.controller.R.id.trophy1);
        trophy2 = (TextView) findViewById(pineapple.controller.R.id.trophy2);
        trophy3 = (TextView) findViewById(pineapple.controller.R.id.trophy3);
        trophy4 = (TextView) findViewById(pineapple.controller.R.id.trophy4);
        trophy5 = (TextView) findViewById(pineapple.controller.R.id.trophy5);
        homeButton = (Button) findViewById(pineapple.controller.R.id.homeButton);
        mySave = (SaveState) getApplication();


        setUpListeners();
        trophies();
    }


//when achivement earned turns it to black
    public void trophies()
    {
        if (mySave.isGoal1() == true)
        {
            trophy1.setTextColor(Color.rgb(0, 0, 0));
        }
        if (mySave.isGoal2())
        {
            trophy2.setTextColor(Color.rgb(0, 0, 0));
        }
        if (mySave.isGoal3())
        {
            trophy3.setTextColor(Color.rgb(0, 0, 0));
        }
        if (mySave.isGoal4())
        {
            trophy4.setTextColor(Color.rgb(0, 0, 0));
        }
        if (mySave.isGoal5())
        {
            trophy5.setTextColor(Color.rgb(0, 0, 0));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(pineapple.controller.R.menu.menu_achievments, menu);
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
        if (id == pineapple.controller.R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//change screen button
    private void setUpListeners()
    {
        homeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                Intent myIntent = new Intent(buttonView.getContext(), MyActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
