// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, hn

final class hs extends hb
{

    private int a;
    private hn b;
    private hr c;

    transient hs(hr hr1, String s, Object aobj[], int i, hn hn)
    {
        c = hr1;
        a = i;
        b = hn;
        super(s, aobj);
    }

    public final void c()
    {
        try
        {
            c.b(a, b);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
