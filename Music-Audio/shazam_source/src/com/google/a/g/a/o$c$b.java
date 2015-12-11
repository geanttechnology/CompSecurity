// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.g;
import com.google.a.a.m;

// Referenced classes of package com.google.a.g.a:
//            a, o

private static final class b extends a
    implements Runnable
{

    private final Runnable b;

    public final void run()
    {
        try
        {
            b.run();
            return;
        }
        catch (Throwable throwable)
        {
            a(throwable);
            throw m.a(throwable);
        }
    }

    public (Runnable runnable)
    {
        b = (Runnable)g.a(runnable);
    }
}
