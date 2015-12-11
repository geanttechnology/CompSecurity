// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hr, iz, hn, 
//            hq

final class hw extends hb
{

    private int a;
    private hr b;

    transient hw(hr hr1, String s, Object aobj[], int i, List list, boolean flag)
    {
        b = hr1;
        a = i;
        super(s, aobj);
    }

    public final void c()
    {
        hr.j(b).b();
        b.i.a(a, hn.h);
        synchronized (b)
        {
            hr.k(b).remove(Integer.valueOf(a));
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
