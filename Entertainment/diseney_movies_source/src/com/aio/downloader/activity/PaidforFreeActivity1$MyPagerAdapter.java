// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.PaidFeaturedFragment;
import com.aio.downloader.fragments.PaidHotAppsFragment;
import com.aio.downloader.fragments.PaidHotGamesFragment;
import com.aio.downloader.fragments.PaidNewAppsFragment;
import com.aio.downloader.fragments.PaidNewGamesFragment;

// Referenced classes of package com.aio.downloader.activity:
//            PaidforFreeActivity1

public class this._cls0 extends FragmentPagerAdapter
{

    private final String TITLES[] = {
        "FEATURED", "HOT GAMES", "NEW GAMES", "HOT APPS", "NEW APPS"
    };
    final PaidforFreeActivity1 this$0;

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
            return new PaidFeaturedFragment();

        case 1: // '\001'
            return new PaidHotGamesFragment();

        case 2: // '\002'
            return new PaidNewGamesFragment();

        case 3: // '\003'
            return new PaidHotAppsFragment();

        case 4: // '\004'
            return new PaidNewAppsFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = PaidforFreeActivity1.this;
        super(fragmentmanager);
    }
}
