// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class ehi extends eje
{

    ehi(Comparator comparator)
    {
        super(comparator);
    }

    final int a(Object obj)
    {
        return -1;
    }

    final eje a(Object obj, boolean flag)
    {
        return this;
    }

    final eje a(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return this;
    }

    final boolean a()
    {
        return false;
    }

    final eje b(Object obj, boolean flag)
    {
        return this;
    }

    public final elm b()
    {
        return ejj.a();
    }

    public final eic c()
    {
        return eic.g();
    }

    public final boolean contains(Object obj)
    {
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        return collection.isEmpty();
    }

    public final elm e()
    {
        return ejj.a();
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Set)
        {
            return ((Set)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public final Object first()
    {
        throw new NoSuchElementException();
    }

    public final int hashCode()
    {
        return 0;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Iterator iterator()
    {
        return ejj.a();
    }

    public final Object last()
    {
        throw new NoSuchElementException();
    }

    public final int size()
    {
        return 0;
    }

    public final Object[] toArray()
    {
        return eka.a;
    }

    public final Object[] toArray(Object aobj[])
    {
        return eic.g().toArray(aobj);
    }

    public final String toString()
    {
        return "[]";
    }
}
