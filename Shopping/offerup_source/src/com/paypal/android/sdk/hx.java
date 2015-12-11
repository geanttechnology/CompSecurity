// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, iz, hn, 
//            hq, kq

final class hx extends hb
{

    private int a;
    private kq b;
    private int c;
    private hr d;

    transient hx(hr hr1, String s, Object aobj[], int i, kq kq, int j, boolean flag)
    {
        d = hr1;
        a = i;
        b = kq;
        c = j;
        super(s, aobj);
    }

    public final void c()
    {
        hr.j(d).a(b, c);
        d.i.a(a, hn.h);
        synchronized (d)
        {
            hr.k(d).remove(Integer.valueOf(a));
        }
        return;
        exception;
        hr1;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
