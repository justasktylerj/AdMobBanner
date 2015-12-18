package pineapple.model;

import android.app.Application;

/**
 * Created by tjar2074 on 11/18/15.
 */
public class SaveState extends Application
{
//saves info across screens

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

    public boolean isGoal3()
    {
        return goal3;
    }

    public void setGoal3(boolean goal3)
    {
        this.goal3 = goal3;
    }

    private boolean goal3;

    public boolean isGoal4()
    {
        return goal4;
    }

    public void setGoal4(boolean goal4)
    {
        this.goal4 = goal4;
    }

    private boolean goal4;

    public boolean isGoal5()
    {
        return goal5;
    }

    public void setGoal5(boolean goal5)
    {
        this.goal5 = goal5;
    }

    public boolean goal5;

    public int PineCoins;

    public int getPineCoins()
    {
        return PineCoins;
    }

    public void setPineCoins(int pineCoins)
    {
        PineCoins = pineCoins;
    }

    public int PineTotal;


    public int getPineTotal()
    {
        return PineTotal;
    }

    public void setPineTotal(int pineTotal)
    {
        PineTotal = pineTotal;
    }

}
