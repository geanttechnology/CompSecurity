// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;


// Referenced classes of package io.presage.utils:
//            i

final class k
    implements Runnable
{

    final Runnable a;
    final i b;

    k(i j, Runnable runnable)
    {
        b = j;
        a = runnable;
        super();
    }

    public final void run()
    {
        a.run();
        b.b();
        return;
        Exception exception;
        exception;
        b.b();
        throw exception;
    }
}
