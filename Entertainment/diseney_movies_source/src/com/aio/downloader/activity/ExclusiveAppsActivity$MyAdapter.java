// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.ExclusiveAppsFragment;

// Referenced classes of package com.aio.downloader.activity:
//            ExclusiveAppsActivity

class this._cls0 extends FragmentPagerAdapter
{

    final ExclusiveAppsActivity this$0;

    public int getCount()
    {
        return 1;
    }

    public Fragment getItem(int i)
    {
        ExclusiveAppsFragment exclusiveappsfragment = null;
        if (i == 0)
        {
            exclusiveappsfragment = new ExclusiveAppsFragment();
        }
        return exclusiveappsfragment;
    }

    public A(FragmentManager fragmentmanager)
    {
        this$0 = ExclusiveAppsActivity.this;
        super(fragmentmanager);
    }
}
