// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.view.View;

public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{
    public static interface Delegate
    {

        public abstract void setActionBarDescription(int i);
    }

    static interface DrawerToggle
    {

        public abstract void setPosition(float f);
    }


    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private boolean mDrawerIndicatorEnabled;
    private final int mOpenDrawerContentDescRes;
    private DrawerToggle mSlider;

    public void onDrawerClosed(View view)
    {
        mSlider.setPosition(0.0F);
        if (mDrawerIndicatorEnabled)
        {
            setActionBarDescription(mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view)
    {
        mSlider.setPosition(1.0F);
        if (mDrawerIndicatorEnabled)
        {
            setActionBarDescription(mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f)
    {
        mSlider.setPosition(Math.min(1.0F, Math.max(0.0F, f)));
    }

    public void onDrawerStateChanged(int i)
    {
    }

    void setActionBarDescription(int i)
    {
        mActivityImpl.setActionBarDescription(i);
    }
}
