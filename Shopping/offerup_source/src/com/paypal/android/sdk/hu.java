// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, fn

final class hu extends hb
{

    private boolean a;
    private int b;
    private int c;
    private fn d;
    private hr e;

    transient hu(hr hr1, String s, Object aobj[], boolean flag, int i, int j, fn fn)
    {
        e = hr1;
        a = true;
        b = i;
        c = j;
        d = null;
        super(s, aobj);
    }

    public final void c()
    {
        try
        {
            hr.a(e, a, b, c, d);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
