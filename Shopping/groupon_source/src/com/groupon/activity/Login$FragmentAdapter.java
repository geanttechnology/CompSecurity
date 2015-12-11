// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

// Referenced classes of package com.groupon.activity:
//            Login

protected class dapter extends FragmentStatePagerAdapter
{

    final Login this$0;

    public int getCount()
    {
        return 2;
    }

    public Fragment getItem(int i)
    {
        if (i == 0)
        {
            return Login.access$000(Login.this);
        } else
        {
            return Login.access$100(Login.this);
        }
    }

    public CharSequence getPageTitle(int i)
    {
        if (i == 0)
        {
            return getString(0x7f08025a);
        } else
        {
            return getString(0x7f08025b);
        }
    }

    public dapter(FragmentManager fragmentmanager)
    {
        this$0 = Login.this;
        super(fragmentmanager);
    }
}
