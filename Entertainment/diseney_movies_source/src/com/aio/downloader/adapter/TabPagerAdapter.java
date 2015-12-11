// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.BackedUpFragment;
import com.aio.downloader.fragments.BackupAvailableFragment;

public class TabPagerAdapter extends FragmentPagerAdapter
{

    private final String mContent[] = {
        "One", "Two"
    };
    private Context mContext;
    private String mTitles[];

    public TabPagerAdapter(Context context, FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        mContext = context;
        mTitles = mContext.getResources().getStringArray(0x7f060000);
    }

    public int getCount()
    {
        return mTitles.length;
    }

    public Fragment getItem(int i)
    {
        BackupAvailableFragment backupavailablefragment = null;
        if (i == 0)
        {
            backupavailablefragment = new BackupAvailableFragment();
        } else
        if (i == 1)
        {
            return new BackedUpFragment();
        }
        return backupavailablefragment;
    }

    public CharSequence getPageTitle(int i)
    {
        return mTitles[i];
    }
}
