// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class ehf extends eic
{

    static final ehf a = new ehf();
    private static final long serialVersionUID = 0L;

    private ehf()
    {
    }

    public final eic a(int i, int j)
    {
        f.a(i, j, 0);
        return this;
    }

    public final eln a(int i)
    {
        f.b(i, 0);
        return ejj.a;
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return ejj.a;
    }

    public final boolean contains(Object obj)
    {
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        return collection.isEmpty();
    }

    public final eln d()
    {
        return ejj.a;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof List)
        {
            return ((List)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public final Object get(int i)
    {
        f.a(i, 0);
        throw new AssertionError("unreachable");
    }

    public final int hashCode()
    {
        return 1;
    }

    public final int indexOf(Object obj)
    {
        return -1;
    }

    public final boolean isEmpty()
    {
        return true;
    }

    public final Iterator iterator()
    {
        return ejj.a;
    }

    public final int lastIndexOf(Object obj)
    {
        return -1;
    }

    public final ListIterator listIterator()
    {
        return ejj.a;
    }

    public final ListIterator listIterator(int i)
    {
        return a(i);
    }

    public final eic m_()
    {
        return this;
    }

    final Object readResolve()
    {
        return a;
    }

    public final int size()
    {
        return 0;
    }

    public final List subList(int i, int j)
    {
        f.a(i, j, 0);
        return this;
    }

    public final Object[] toArray()
    {
        return eka.a;
    }

    public final Object[] toArray(Object aobj[])
    {
        if (aobj.length > 0)
        {
            aobj[0] = null;
        }
        return aobj;
    }

    public final String toString()
    {
        return "[]";
    }

}
