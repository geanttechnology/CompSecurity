// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            ak, am, aj, ad, 
//            aw, z

final class p extends ak
{

    private final transient am a;

    p(Comparator comparator)
    {
        a = am.a(comparator);
    }

    private p(Comparator comparator, ak ak1)
    {
        super(ak1);
        a = am.a(comparator);
    }

    public final ak a(Object obj)
    {
        com.google.a.a.g.a(obj);
        return this;
    }

    public final aj b()
    {
        return com.google.a.c.aj.g();
    }

    public final ak b(Object obj)
    {
        com.google.a.a.g.a(obj);
        return this;
    }

    final aj c()
    {
        throw new AssertionError("should never be called");
    }

    public final volatile aj d()
    {
        return a;
    }

    final boolean e()
    {
        return false;
    }

    public final Set entrySet()
    {
        return com.google.a.c.aj.g();
    }

    public final z f()
    {
        return ad.d();
    }

    public final am f_()
    {
        return a;
    }

    final ak g()
    {
        return new p(aw.a(comparator()).a(), this);
    }

    public final Object get(Object obj)
    {
        return null;
    }

    public final NavigableMap headMap(Object obj, boolean flag)
    {
        com.google.a.a.g.a(obj);
        return this;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final volatile Set keySet()
    {
        return a;
    }

    public final int size()
    {
        return 0;
    }

    public final NavigableMap tailMap(Object obj, boolean flag)
    {
        com.google.a.a.g.a(obj);
        return this;
    }

    public final String toString()
    {
        return "{}";
    }

    public final Collection values()
    {
        return ad.d();
    }
}
