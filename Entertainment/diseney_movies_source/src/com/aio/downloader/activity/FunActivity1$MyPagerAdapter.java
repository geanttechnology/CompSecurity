// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.FunTrendingFragment;
import com.aio.downloader.fragments.FunadultFragment;
import com.aio.downloader.fragments.FunallFragment;
import com.aio.downloader.fragments.FungagFragment;
import com.aio.downloader.fragments.FungifFragment;
import com.aio.downloader.fragments.FunpopularFragment;
import com.aio.downloader.fragments.FunvideoFragment;

// Referenced classes of package com.aio.downloader.activity:
//            FunActivity1

public class this._cls0 extends FragmentPagerAdapter
{

    private final String TITLES[] = {
        "new", "Trending", "Popular", "Adult", "Gag", "Gif", "Video"
    };
    final FunActivity1 this$0;

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
            return new FunallFragment();

        case 1: // '\001'
            return new FunTrendingFragment();

        case 2: // '\002'
            return new FunpopularFragment();

        case 3: // '\003'
            return new FunadultFragment();

        case 4: // '\004'
            return new FungagFragment();

        case 5: // '\005'
            return new FungifFragment();

        case 6: // '\006'
            return new FunvideoFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = FunActivity1.this;
        super(fragmentmanager);
    }
}
