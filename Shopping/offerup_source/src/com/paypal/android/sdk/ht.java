// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, hq

final class ht extends hb
{

    private int a;
    private long b;
    private hr c;

    transient ht(hr hr1, String s, Object aobj[], int i, long l)
    {
        c = hr1;
        a = i;
        b = l;
        super(s, aobj);
    }

    public final void c()
    {
        try
        {
            c.i.a(a, b);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
