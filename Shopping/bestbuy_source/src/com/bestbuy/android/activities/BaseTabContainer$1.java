// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package com.bestbuy.android.activities:
//            BaseTabContainer

class b
    implements Runnable
{

    final boolean a;
    final Fragment b;
    final BaseTabContainer c;

    public void run()
    {
        FragmentTransaction fragmenttransaction = c.getChildFragmentManager().beginTransaction();
        if (a)
        {
            fragmenttransaction.addToBackStack(null);
        }
        fragmenttransaction.replace(0x7f0c009e, b);
        fragmenttransaction.commitAllowingStateLoss();
        c.getChildFragmentManager().executePendingTransactions();
    }

    (BaseTabContainer basetabcontainer, boolean flag, Fragment fragment)
    {
        c = basetabcontainer;
        a = flag;
        b = fragment;
        super();
    }
}
