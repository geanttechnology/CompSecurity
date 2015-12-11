// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.am;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

public final class ed extends am
{

    private MyOffersActivity a;

    public ed(MyOffersActivity myoffersactivity, aa aa)
    {
        a = myoffersactivity;
        super(aa);
    }

    public final Fragment a(int i)
    {
        return a.e(i);
    }

    public final int b()
    {
        return 3;
    }

    public final CharSequence b(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return "Selling";

        case 1: // '\001'
            return "Buying";

        case 2: // '\002'
            return "Watching";
        }
    }
}
