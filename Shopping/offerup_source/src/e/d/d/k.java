// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.a;
import e.c.b;
import e.c.d;
import e.j;

// Referenced classes of package e.d.d:
//            i, l

final class k
    implements b
{

    private d a;
    private i b;

    k(i i1, d d1)
    {
        b = i1;
        a = d1;
        super();
    }

    public final void call(Object obj)
    {
        obj = (j)obj;
        a a1 = (a)a.a(e.d.d.i.a(b));
        if (a1.getClass() == e/d/d/i)
        {
            ((j) (obj)).a(e.d.d.i.a((i)a1));
            ((j) (obj)).a();
            return;
        } else
        {
            a1.a(new l(this, ((j) (obj)), ((j) (obj))));
            return;
        }
    }
}
