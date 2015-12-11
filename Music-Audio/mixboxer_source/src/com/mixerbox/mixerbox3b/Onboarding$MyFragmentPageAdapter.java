// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.mixerbox.mixerbox3b.classes.MyFragment;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            Onboarding

public class this._cls0 extends FragmentPagerAdapter
{

    final Onboarding this$0;

    public int getCount()
    {
        return 3;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return MyFragment.newInstance(i);

        case 1: // '\001'
            return MyFragment.newInstance(i);

        case 2: // '\002'
            return MyFragment.newInstance(i);
        }
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = Onboarding.this;
        super(fragmentmanager);
    }
}
