// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity, e

class c extends FragmentPagerAdapter
{

    final MainActivity a;

    public c(MainActivity mainactivity, FragmentManager fragmentmanager)
    {
        a = mainactivity;
        super(fragmentmanager);
    }

    public int getCount()
    {
        return MainActivity.i(a).size();
    }

    public Fragment getItem(int i)
    {
        return ((e)MainActivity.i(a).get(i)).a();
    }
}
