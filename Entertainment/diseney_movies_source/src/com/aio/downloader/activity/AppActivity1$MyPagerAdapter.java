// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.AppFeaturedFragment;
import com.aio.downloader.fragments.AppGlobalNewFragment;
import com.aio.downloader.fragments.AppGlobalTopFragment;
import com.aio.downloader.fragments.AppIndiaNewFragment;
import com.aio.downloader.fragments.AppIndiaTopFragment;

// Referenced classes of package com.aio.downloader.activity:
//            AppActivity1

public class this._cls0 extends FragmentPagerAdapter
{

    private final String TITLES[] = {
        "FEATURED", "GLOBAL TOP", "GLOBAL NEW", "LOCAL TOP", "LOCAL NEW"
    };
    final AppActivity1 this$0;

    public int getCount()
    {
        return TITLES.length;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new AppFeaturedFragment();

        case 1: // '\001'
            return new AppGlobalTopFragment();

        case 2: // '\002'
            return new AppGlobalNewFragment();

        case 3: // '\003'
            return new AppIndiaTopFragment();

        case 4: // '\004'
            return new AppIndiaNewFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = AppActivity1.this;
        super(fragmentmanager);
    }
}
