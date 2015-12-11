// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.tapjoy.internal:
//            dg, dh

final class <init> extends dg
{

    final dh a;

    private Unit a(long l, TimeUnit timeunit)
    {
        try
        {
            timeunit = (Unit)super.get(l, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            throw new TimeoutException(a.toString());
        }
        return timeunit;
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return a(l, timeunit);
    }

    private Unit(dh dh1)
    {
        a = dh1;
        super();
    }

    nit>(dh dh1, byte byte0)
    {
        this(dh1);
    }
}
