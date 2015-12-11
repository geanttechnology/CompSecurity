// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.support.v7.widget.v;
import com.wishabi.flipp.widget.an;

// Referenced classes of package com.wishabi.flipp.app:
//            CouponFragment

final class w extends v
{

    final int b;
    final int c;
    final int d;
    final CouponFragment e;

    w(CouponFragment couponfragment, int i, int j, int k)
    {
        e = couponfragment;
        b = i;
        c = j;
        d = k;
        super();
    }

    public final int a(int i)
    {
        if (CouponFragment.a(e) == null)
        {
            return 1;
        }
        switch (CouponFragment.a(e).a(i))
        {
        default:
            return d;

        case 0: // '\0'
            return b;

        case 1: // '\001'
            return c;

        case 2: // '\002'
            return b;
        }
    }
}
