// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.c.d;
import e.g;
import e.g.f;
import e.g.k;
import e.j;

// Referenced classes of package e.d.a:
//            p, q

public final class o
    implements d
{

    private final g a;

    public o(g g)
    {
        a = g;
    }

    public final Object a(Object obj)
    {
        for (obj = (j)obj; (a instanceof f) || (a instanceof k);)
        {
            return obj;
        }

        obj = new p(a, ((j) (obj)));
        ((p) (obj)).a.a(((p) (obj)).c);
        ((p) (obj)).a.a(new q(((p) (obj))));
        ((p) (obj)).a.a(((p) (obj)).b);
        ((p) (obj)).a.a(((e.k) (obj)));
        return obj;
    }
}
