// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.h;

import e.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class a
    implements k
{

    private static AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(e/h/a, "a");
    volatile int a;
    private final e.c.a b;

    public a()
    {
        b = null;
    }

    private a(e.c.a a1)
    {
        b = a1;
    }

    public static a a()
    {
        return new a();
    }

    public static a a(e.c.a a1)
    {
        return new a(a1);
    }

    public final void b()
    {
        if (c.compareAndSet(this, 0, 1) && b != null)
        {
            b.a();
        }
    }

    public final boolean c()
    {
        return a != 0;
    }

}
