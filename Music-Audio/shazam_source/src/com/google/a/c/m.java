// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;
import java.util.NavigableSet;

// Referenced classes of package com.google.a.c:
//            am, aw, bk

final class m extends am
{

    private final am c;

    m(am am1)
    {
        super(aw.a(am1.comparator()).a());
        c = am1;
    }

    final am a(Object obj, boolean flag)
    {
        return c.d(obj, flag).c_();
    }

    final am a(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return c.b(obj1, flag1, obj, flag).c_();
    }

    public final bk a()
    {
        return c.c();
    }

    final am b(Object obj, boolean flag)
    {
        return c.c(obj, flag).c_();
    }

    public final bk c()
    {
        return c.a();
    }

    public final am c_()
    {
        return c;
    }

    public final Object ceiling(Object obj)
    {
        return c.floor(obj);
    }

    final am d()
    {
        throw new AssertionError("should never be called");
    }

    public final Iterator descendingIterator()
    {
        return c.a();
    }

    public final volatile NavigableSet descendingSet()
    {
        return c;
    }

    final boolean e()
    {
        return c.e();
    }

    public final Object floor(Object obj)
    {
        return c.ceiling(obj);
    }

    public final Object higher(Object obj)
    {
        return c.lower(obj);
    }

    public final Iterator iterator()
    {
        return c.c();
    }

    public final Object lower(Object obj)
    {
        return c.higher(obj);
    }

    public final int size()
    {
        return c.size();
    }
}
