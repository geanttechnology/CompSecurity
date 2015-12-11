// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

final class eky extends eic
{

    private transient Object a;

    eky(Object obj)
    {
        a = f.b(obj);
    }

    public final eic a(int i, int j)
    {
        f.a(i, j, 1);
        Object obj = this;
        if (i == j)
        {
            obj = ehf.a;
        }
        return ((eic) (obj));
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return ejj.a(a);
    }

    public final boolean contains(Object obj)
    {
        return a.equals(obj);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof List)
            {
                if (((List) (obj = (List)obj)).size() != 1 || !a.equals(((List) (obj)).get(0)))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i)
    {
        f.a(i, 1);
        return a;
    }

    public final int hashCode()
    {
        return a.hashCode() + 31;
    }

    public final int indexOf(Object obj)
    {
        return !a.equals(obj) ? -1 : 0;
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final Iterator iterator()
    {
        return ejj.a(a);
    }

    public final int lastIndexOf(Object obj)
    {
        return indexOf(obj);
    }

    public final eic m_()
    {
        return this;
    }

    public final int size()
    {
        return 1;
    }

    public final List subList(int i, int j)
    {
        return a(i, j);
    }

    public final Object[] toArray()
    {
        return (new Object[] {
            a
        });
    }

    public final Object[] toArray(Object aobj[])
    {
        if (aobj.length != 0) goto _L2; else goto _L1
_L1:
        Object aobj1[] = eka.a(aobj, 1);
_L4:
        aobj1[0] = a;
        return aobj1;
_L2:
        aobj1 = aobj;
        if (aobj.length > 1)
        {
            aobj[1] = null;
            aobj1 = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        String s = a.toString();
        return (new StringBuilder(s.length() + 2)).append('[').append(s).append(']').toString();
    }
}
