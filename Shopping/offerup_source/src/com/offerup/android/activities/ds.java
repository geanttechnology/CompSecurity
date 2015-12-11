// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.ViewPager;
import android.support.v4.view.co;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class ds
    implements co
{

    private MyOffersActivity a;

    ds(MyOffersActivity myoffersactivity)
    {
        a = myoffersactivity;
        super();
    }

    public final void a(int i)
    {
        a.a = i;
        a.d.setCurrentItem(a.a);
        a.supportInvalidateOptionsMenu();
    }

    public final void a(int i, float f, int j)
    {
    }

    public final void b(int i)
    {
    }
}
