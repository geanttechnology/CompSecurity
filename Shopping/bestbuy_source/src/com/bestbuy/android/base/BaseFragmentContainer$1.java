// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Referenced classes of package com.bestbuy.android.base:
//            BaseFragmentContainer

class c
    implements Runnable
{

    final boolean a;
    final Fragment b;
    final String c;
    final BaseFragmentContainer d;

    public void run()
    {
        FragmentTransaction fragmenttransaction = d.getChildFragmentManager().beginTransaction();
        if (a)
        {
            fragmenttransaction.addToBackStack(null);
        }
        fragmenttransaction.replace(0x7f0c009e, b, c);
        fragmenttransaction.commitAllowingStateLoss();
        d.getChildFragmentManager().executePendingTransactions();
    }

    (BaseFragmentContainer basefragmentcontainer, boolean flag, Fragment fragment, String s)
    {
        d = basefragmentcontainer;
        a = flag;
        b = fragment;
        c = s;
        super();
    }
}
