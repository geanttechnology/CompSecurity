// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.ftue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class PagedFragmentViewAdapter extends FragmentPagerAdapter
{

    private final List fragments;

    public PagedFragmentViewAdapter(FragmentManager fragmentmanager, List list)
    {
        super(fragmentmanager);
        fragments = list;
    }

    public int getCount()
    {
        return fragments.size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)fragments.get(i);
    }
}
