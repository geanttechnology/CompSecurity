// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.c.b;
import e.g;
import e.h;
import e.j;

// Referenced classes of package e.d.d:
//            o

final class n
    implements b
{

    private final g a;
    private final Object b;

    n(g g1, Object obj)
    {
        a = g1;
        b = obj;
    }

    public final void call(Object obj)
    {
        obj = (j)obj;
        h h1 = a.a();
        ((j) (obj)).a(h1);
        h1.a(new o(((j) (obj)), b, (byte)0));
    }
}
