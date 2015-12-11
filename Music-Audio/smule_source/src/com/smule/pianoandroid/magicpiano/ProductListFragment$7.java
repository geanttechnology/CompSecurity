// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListFragment

class a
    implements Runnable
{

    final ProductListFragment a;

    public void run()
    {
        aa.a(ProductListFragment.d(), (new StringBuilder()).append("Jumping to jam section ").append(ProductListFragment.f(a)).toString());
        if (ProductListFragment.f(a) != null && !ProductListFragment.f(a).equals(""))
        {
            a.c(ProductListFragment.f(a));
        }
    }

    (ProductListFragment productlistfragment)
    {
        a = productlistfragment;
        super();
    }
}
