// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.gotv.crackle.fragments.BrowseMoviesFragment;
import com.gotv.crackle.fragments.BrowseShowsFragment;
import com.gotv.crackle.fragments.HomeFragment;
import com.gotv.crackle.fragments.WatchlistsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter
{

    public TabsPagerAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public int getCount()
    {
        return 4;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new HomeFragment();

        case 1: // '\001'
            return new BrowseMoviesFragment();

        case 2: // '\002'
            return new BrowseShowsFragment();

        case 3: // '\003'
            return new WatchlistsFragment();
        }
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }
}
