// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

// Referenced classes of package com.google.a.c:
//            an, bi, aw, q, 
//            ao, m, bk, ap

public abstract class am extends an
    implements bi, NavigableSet
{

    private static final Comparator c;
    private static final am d;
    final transient Comparator a;
    transient am b;

    am(Comparator comparator1)
    {
        a = comparator1;
    }

    static am a(Comparator comparator1)
    {
        if (c.equals(comparator1))
        {
            return d;
        } else
        {
            return new q(comparator1);
        }
    }

    abstract am a(Object obj, boolean flag);

    abstract am a(Object obj, boolean flag, Object obj1, boolean flag1);

    public abstract bk a();

    abstract am b(Object obj, boolean flag);

    public final am b(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        g.a(obj);
        g.a(obj1);
        boolean flag2;
        if (a.compare(obj, obj1) <= 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        g.a(flag2);
        return a(obj, flag, obj1, flag1);
    }

    public final am c(Object obj, boolean flag)
    {
        return a(g.a(obj), flag);
    }

    public abstract bk c();

    public am c_()
    {
        am am2 = b;
        am am1 = am2;
        if (am2 == null)
        {
            am1 = d();
            b = am1;
            am1.b = this;
        }
        return am1;
    }

    public Object ceiling(Object obj)
    {
        return ao.b(d(obj, true));
    }

    public Comparator comparator()
    {
        return a;
    }

    am d()
    {
        return new m(this);
    }

    public final am d(Object obj, boolean flag)
    {
        return b(g.a(obj), flag);
    }

    public Iterator descendingIterator()
    {
        return c();
    }

    public NavigableSet descendingSet()
    {
        return c_();
    }

    public Object first()
    {
        return a().next();
    }

    public Object floor(Object obj)
    {
        return ap.d(c(obj, true).c());
    }

    public NavigableSet headSet(Object obj, boolean flag)
    {
        return c(obj, flag);
    }

    public SortedSet headSet(Object obj)
    {
        return c(obj, false);
    }

    public Object higher(Object obj)
    {
        return ao.b(d(obj, false));
    }

    public Iterator iterator()
    {
        return a();
    }

    public Object last()
    {
        return c().next();
    }

    public Object lower(Object obj)
    {
        return ap.d(c(obj, false).c());
    }

    public final Object pollFirst()
    {
        throw new UnsupportedOperationException();
    }

    public final Object pollLast()
    {
        throw new UnsupportedOperationException();
    }

    public NavigableSet subSet(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return b(obj, flag, obj1, flag1);
    }

    public SortedSet subSet(Object obj, Object obj1)
    {
        return b(obj, true, obj1, false);
    }

    public NavigableSet tailSet(Object obj, boolean flag)
    {
        return d(obj, flag);
    }

    public SortedSet tailSet(Object obj)
    {
        return d(obj, true);
    }

    static 
    {
        c = aw.b();
        d = new q(c);
    }
}
