// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;


// Referenced classes of package com.a.b:
//            ag

final class ah
    implements Runnable
{

    final Exception a;
    final ag b;

    ah(ag ag, Exception exception)
    {
        b = ag;
        a = exception;
        super();
    }

    public final void run()
    {
        throw new RuntimeException(a);
    }
}
