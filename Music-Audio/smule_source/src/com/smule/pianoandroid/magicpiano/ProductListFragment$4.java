// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a
    implements Runnable
{

    final ProductListFragment a;

    public void run()
    {
        if (ProductListFragment.c(a) == null) goto _L2; else goto _L1
_L1:
        a.e(ProductListFragment.c(a));
_L4:
        ProductListFragment.a(a, null);
        ProductListFragment.b(a, null);
        ProductListFragment.c(a, null);
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        if (fragmentactivity != null)
        {
            fragmentactivity.findViewById(0x1020004).setVisibility(8);
        }
        return;
_L2:
        if (ProductListFragment.d(a) != null && ProductListFragment.e(a) != null)
        {
            a.b(ProductListFragment.e(a), ProductListFragment.d(a));
        } else
        if (ProductListFragment.d(a) != null)
        {
            a.c(ProductListFragment.d(a));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (ProductListFragment productlistfragment)
    {
        a = productlistfragment;
        super();
    }
}
