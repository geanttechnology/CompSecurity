// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.Executor;

// Referenced classes of package a:
//            h, i, p, g

final class j
    implements h
{

    private p a;
    private h b;
    private Executor c;
    private g d;

    j(i k, p p, h h1, Executor executor, g g)
    {
        a = p;
        b = h1;
        c = executor;
        d = g;
        super();
    }

    public final Object then(i k)
    {
        i.b(a, b, k, c, d);
        return null;
    }
}
