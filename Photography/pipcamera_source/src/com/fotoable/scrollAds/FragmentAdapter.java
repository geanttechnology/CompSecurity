// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.scrollAds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter
{

    List a;

    public int getCount()
    {
        return a.size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)a.get(i);
    }
}
