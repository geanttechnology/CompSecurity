// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.Executor;

// Referenced classes of package a:
//            g, h, o

final class l
    implements g
{

    final o a;
    final g b;
    final Executor c;
    final h d;

    l(h h1, o o, g g1, Executor executor)
    {
        d = h1;
        a = o;
        b = g1;
        c = executor;
        super();
    }

    public final Object then(h h1)
    {
        h.b(a, b, h1, c);
        return null;
    }
}
