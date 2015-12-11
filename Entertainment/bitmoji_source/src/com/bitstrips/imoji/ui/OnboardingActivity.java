// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.astuetz.PagerSlidingTabStrip;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.ui.adapters.OnboardingPagerAdapter;

public class OnboardingActivity extends FragmentActivity
{

    private static final String TAG = "OnboardingActivity";
    AnalyticsService analyticsService;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;

    public OnboardingActivity()
    {
    }

    public void onBackPressed()
    {
        if (viewPager.getCurrentItem() != 0)
        {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        setContentView(0x7f030059);
        viewPager = (ViewPager)findViewById(0x7f0b00e9);
        pagerAdapter = new OnboardingPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        ((PagerSlidingTabStrip)findViewById(0x7f0b00ea)).setViewPager(viewPager);
    }

    public void onStart()
    {
        super.onStart();
        analyticsService.reportStart(this);
    }

    public void onStop()
    {
        super.onStop();
        analyticsService.reportStop(this);
    }

    public void onboardingContinueClicked(View view)
    {
        finish();
    }
}
