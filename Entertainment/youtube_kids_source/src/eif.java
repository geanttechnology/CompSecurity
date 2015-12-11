// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class eif extends eic
{

    private final transient eic a;
    private final transient int c;

    eif(eic eic1)
    {
        a = eic1;
        c = eic1.size();
    }

    static int a(eif eif1, int i)
    {
        return eif1.b(i);
    }

    private int b(int i)
    {
        return c - 1 - i;
    }

    public final eic a(int i, int j)
    {
        f.a(i, j, c);
        return a.a(c - j, c - i).m_();
    }

    public final eln a(int i)
    {
        f.b(i, c);
        return new eig(this, a.a(c - i));
    }

    final boolean a()
    {
        return a.a();
    }

    public final boolean contains(Object obj)
    {
        return a.contains(obj);
    }

    public final boolean containsAll(Collection collection)
    {
        return a.containsAll(collection);
    }

    public final Object get(int i)
    {
        f.a(i, c);
        return a.get(b(i));
    }

    public final int indexOf(Object obj)
    {
        int i = a.lastIndexOf(obj);
        if (i >= 0)
        {
            return b(i);
        } else
        {
            return -1;
        }
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final Iterator iterator()
    {
        return super.b();
    }

    public final int lastIndexOf(Object obj)
    {
        int i = a.indexOf(obj);
        if (i >= 0)
        {
            return b(i);
        } else
        {
            return -1;
        }
    }

    public final ListIterator listIterator()
    {
        return super.d();
    }

    public final ListIterator listIterator(int i)
    {
        return a(i);
    }

    public final eic m_()
    {
        return a;
    }

    public final int size()
    {
        return c;
    }

    public final List subList(int i, int j)
    {
        return a(i, j);
    }
}
