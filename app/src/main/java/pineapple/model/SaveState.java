package pineapple.model;

import android.app.Application;

/**
 * Created by tjar2074 on 11/18/15.
 */
public class SaveState extends Application
{

    private boolean goal1;

    public boolean isGoal2()
    {
        return goal2;
    }

    public void setGoal2(boolean goal2)
    {
        this.goal2 = goal2;
    }

    public boolean isGoal1()
    {
        return goal1;
    }

    public void setGoal1(boolean goal1)
    {

        this.goal1 = goal1;
    }

    private boolean goal2;
}
