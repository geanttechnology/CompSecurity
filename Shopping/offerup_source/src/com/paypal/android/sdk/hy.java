// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, iz, hn

final class hy extends hb
{

    private int a;
    private hr b;

    transient hy(hr hr1, String s, Object aobj[], int i, hn hn)
    {
        b = hr1;
        a = i;
        super(s, aobj);
    }

    public final void c()
    {
        hr.j(b).c();
        synchronized (b)
        {
            hr.k(b).remove(Integer.valueOf(a));
        }
        return;
        exception;
        hr1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
