// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.AdultDatingFragment;
import com.aio.downloader.fragments.AdultFeaturedFragment;
import com.aio.downloader.fragments.AdultGamesFragment;
import com.aio.downloader.fragments.AdultVideoFragment;

// Referenced classes of package com.aio.downloader.activity:
//            AdultActivity1

public class this._cls0 extends FragmentPagerAdapter
{

    private final String TITLES[] = {
        "FEATURED", "GAMES", "DATING", "VIDEO"
    };
    final AdultActivity1 this$0;

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
            return new AdultFeaturedFragment();

        case 1: // '\001'
            return new AdultGamesFragment();

        case 2: // '\002'
            return new AdultDatingFragment();

        case 3: // '\003'
            return new AdultVideoFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = AdultActivity1.this;
        super(fragmentmanager);
    }
}
