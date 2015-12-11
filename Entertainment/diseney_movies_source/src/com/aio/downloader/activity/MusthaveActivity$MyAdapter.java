// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aio.downloader.fragments.MusthaveFragment;

// Referenced classes of package com.aio.downloader.activity:
//            MusthaveActivity

class this._cls0 extends FragmentPagerAdapter
{

    final MusthaveActivity this$0;

    public int getCount()
    {
        return 1;
    }

    public Fragment getItem(int i)
    {
        MusthaveFragment musthavefragment = null;
        if (i == 0)
        {
            musthavefragment = new MusthaveFragment();
        }
        return musthavefragment;
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = MusthaveActivity.this;
        super(fragmentmanager);
    }
}
