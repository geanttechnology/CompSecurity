// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

final class ehh extends eiz
{

    private final transient eje a;

    ehh(Comparator comparator)
    {
        a = eje.a(comparator);
    }

    public final eiz a(Object obj, boolean flag)
    {
        f.b(obj);
        return this;
    }

    public final eiu b()
    {
        return eiu.g();
    }

    public final eiz b(Object obj, boolean flag)
    {
        f.b(obj);
        return this;
    }

    final eiu c()
    {
        throw new AssertionError("should never be called");
    }

    public final eiu d()
    {
        return a;
    }

    final boolean e()
    {
        return false;
    }

    public final Set entrySet()
    {
        return eiu.g();
    }

    public final ehr f()
    {
        return eic.g();
    }

    public final Object get(Object obj)
    {
        return null;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Set keySet()
    {
        return a;
    }

    public final eje n_()
    {
        return a;
    }

    public final int size()
    {
        return 0;
    }

    public final String toString()
    {
        return "{}";
    }

    public final Collection values()
    {
        return eic.g();
    }
}
