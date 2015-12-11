// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            u

final class ct
    implements Runnable
{

    final Exception a;
    final ption b;

    public final void run()
    {
        throw new RuntimeException(a);
    }

    ption(ption ption, Exception exception)
    {
        b = ption;
        a = exception;
        super();
    }
}
