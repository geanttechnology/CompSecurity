// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.bitstrips.imoji.ui.OnboardingFragment;

public class OnboardingPagerAdapter extends FragmentStatePagerAdapter
    implements com.astuetz.PagerSlidingTabStrip.IconTabProvider
{

    private static final int slides[] = {
        0x7f03005a, 0x7f03005b, 0x7f03005c
    };

    public OnboardingPagerAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public int getCount()
    {
        return slides.length;
    }

    public Fragment getItem(int i)
    {
        i = slides[i];
        Bundle bundle = new Bundle();
        bundle.putInt("layout", i);
        OnboardingFragment onboardingfragment = new OnboardingFragment();
        onboardingfragment.setArguments(bundle);
        return onboardingfragment;
    }

    public int getPageIconResId(int i)
    {
        return 0x7f0200bc;
    }

}
