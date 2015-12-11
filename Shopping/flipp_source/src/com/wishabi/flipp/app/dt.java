// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.support.v7.widget.v;
import com.wishabi.flipp.widget.ck;

// Referenced classes of package com.wishabi.flipp.app:
//            PrintCouponFragment

final class dt extends v
{

    final int b;
    final PrintCouponFragment c;

    dt(PrintCouponFragment printcouponfragment, int i)
    {
        c = printcouponfragment;
        b = i;
        super();
    }

    public final int a(int i)
    {
        if (PrintCouponFragment.a(c) == null)
        {
            return b;
        }
        if (PrintCouponFragment.a(c).a(i) == 3)
        {
            return 1;
        } else
        {
            return b;
        }
    }
}
