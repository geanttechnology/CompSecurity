// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.GameFeaturedFragment;
import com.aio.downloader.fragments.GameGlobalNewFragment;
import com.aio.downloader.fragments.GameGlobalTopFragment;
import com.aio.downloader.fragments.GameIndiaNewFragment;
import com.aio.downloader.fragments.GameIndiaTopFragment;

// Referenced classes of package com.aio.downloader.activity:
//            GameActivity1

public class this._cls0 extends FragmentPagerAdapter
{

    private final String TITLES[] = {
        "FEATURED", "GLOBAL TOP", "GLOBAL NEW", "LOCAL TOP", "LOCAL NEW"
    };
    final GameActivity1 this$0;

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
            return new GameFeaturedFragment();

        case 1: // '\001'
            return new GameGlobalTopFragment();

        case 2: // '\002'
            return new GameGlobalNewFragment();

        case 3: // '\003'
            return new GameIndiaTopFragment();

        case 4: // '\004'
            return new GameIndiaNewFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = GameActivity1.this;
        super(fragmentmanager);
    }
}
