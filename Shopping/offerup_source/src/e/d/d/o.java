// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.c.a;
import e.j;

final class o
    implements a
{

    private final j a;
    private final Object b;

    private o(j j1, Object obj)
    {
        a = j1;
        b = obj;
    }

    o(j j1, Object obj, byte byte0)
    {
        this(j1, obj);
    }

    public final void a()
    {
        try
        {
            a.a(b);
        }
        catch (Throwable throwable)
        {
            a.a(throwable);
            return;
        }
        a.a();
    }
}
