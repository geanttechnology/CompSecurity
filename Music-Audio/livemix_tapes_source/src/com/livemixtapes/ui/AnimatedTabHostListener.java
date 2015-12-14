// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;

public class AnimatedTabHostListener
    implements android.widget.TabHost.OnTabChangeListener
{

    private static final int ANIMATION_TIME = 240;
    private int currentTab;
    private View currentView;
    private View previousView;
    private TabHost tabHost;

    public AnimatedTabHostListener(TabHost tabhost)
    {
        tabHost = tabhost;
        previousView = tabhost.getCurrentView();
    }

    private Animation inFromLeftAnimation()
    {
        return setProperties(new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F));
    }

    private Animation inFromRightAnimation()
    {
        return setProperties(new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F));
    }

    private Animation outToLeftAnimation()
    {
        return setProperties(new TranslateAnimation(2, 0.0F, 2, -1F, 2, 0.0F, 2, 0.0F));
    }

    private Animation outToRightAnimation()
    {
        return setProperties(new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F));
    }

    private Animation setProperties(Animation animation)
    {
        animation.setDuration(240L);
        animation.setInterpolator(new AccelerateInterpolator());
        return animation;
    }

    public void onTabChanged(String s)
    {
        Log.d("AnimatedTabHost", "Tab switching...");
        currentView = tabHost.getCurrentView();
        if (tabHost.getCurrentTab() > currentTab)
        {
            previousView.setAnimation(outToLeftAnimation());
            currentView.setAnimation(inFromRightAnimation());
        } else
        {
            previousView.setAnimation(outToRightAnimation());
            currentView.setAnimation(inFromLeftAnimation());
        }
        previousView = currentView;
        currentTab = tabHost.getCurrentTab();
    }
}
