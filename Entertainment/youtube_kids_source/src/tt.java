// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class tt
    implements bhv
{

    private ts a;

    tt(ts ts1)
    {
        a = ts1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        a.n = null;
        a.a(new cse(csf.d, true, a.e.a(exception), exception));
        a.s = a.t;
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (cpv)obj1;
        a.n = null;
        int i = a.o.length;
        a.o = (String[])Arrays.copyOf(a.o, a.o.length + ((cpv) (obj)).c.size());
        for (obj1 = ((cpv) (obj)).c.iterator(); ((Iterator) (obj1)).hasNext();)
        {
            ced ced1 = (ced)((Iterator) (obj1)).next();
            a.o[i] = ced1.b;
            i++;
        }

        if (((cpv) (obj)).c.isEmpty() || ((cpv) (obj)).b == null)
        {
            a.m = null;
        } else
        {
            a.m = bzi.a(((cpv) (obj)).b, a.m);
        }
        if (a.t >= a.o.length && a.m != null)
        {
            a.v();
            return;
        } else
        {
            ts.a(a);
            return;
        }
    }
}
