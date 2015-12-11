// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.Executor;

// Referenced classes of package a:
//            g, h, o

final class k
    implements g
{

    final o a;
    final g b;
    final Executor c;
    final h d;

    k(h h1, o o, g g1, Executor executor)
    {
        d = h1;
        a = o;
        b = g1;
        c = executor;
        super();
    }

    public final Object then(h h1)
    {
        h.a(a, b, h1, c);
        return null;
    }
}
