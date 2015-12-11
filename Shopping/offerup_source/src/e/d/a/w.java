// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.c.a;

// Referenced classes of package e.d.a:
//            x, v

final class w
    implements a
{

    final v a;
    private e.a b;

    w(v v1, e.a a1)
    {
        a = v1;
        b = a1;
        super();
    }

    public final void a()
    {
        Thread thread = Thread.currentThread();
        b.a(new x(this, a.a, thread));
    }
}
