// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class ekl extends eic
{

    private final transient int a;
    private final transient int c;
    private final transient Object d[];

    ekl(Object aobj[])
    {
        this(aobj, 0, aobj.length);
    }

    private ekl(Object aobj[], int i, int j)
    {
        a = i;
        c = j;
        d = aobj;
    }

    public final eln a(int i)
    {
        return ejj.a(d, a, c, i);
    }

    final boolean a()
    {
        return a != 0 || c != d.length;
    }

    final eic b(int i, int j)
    {
        return new ekl(d, a + i, j - i);
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof List))
        {
            return false;
        }
        List list = (List)obj;
        if (size() != list.size())
        {
            return false;
        }
        int i = a;
        if (obj instanceof ekl)
        {
            obj = (ekl)obj;
            for (int j = ((ekl) (obj)).a; j < ((ekl) (obj)).a + ((ekl) (obj)).c;)
            {
                if (!d[i].equals(((ekl) (obj)).d[j]))
                {
                    return false;
                }
                j++;
                i++;
            }

        } else
        {
            for (obj = list.iterator(); ((Iterator) (obj)).hasNext();)
            {
                Object obj1 = ((Iterator) (obj)).next();
                if (!d[i].equals(obj1))
                {
                    return false;
                }
                i++;
            }

        }
        return true;
    }

    public final Object get(int i)
    {
        f.a(i, c);
        return d[a + i];
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final ListIterator listIterator(int i)
    {
        return a(i);
    }

    public final int size()
    {
        return c;
    }

    public final Object[] toArray()
    {
        Object aobj[] = new Object[size()];
        System.arraycopy(((Object) (d)), a, ((Object) (aobj)), 0, c);
        return aobj;
    }

    public final Object[] toArray(Object aobj[])
    {
        if (aobj.length >= c) goto _L2; else goto _L1
_L1:
        Object aobj1[] = eka.a(aobj, c);
_L4:
        System.arraycopy(((Object) (d)), a, ((Object) (aobj1)), 0, c);
        return aobj1;
_L2:
        aobj1 = aobj;
        if (aobj.length > c)
        {
            aobj[c] = null;
            aobj1 = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        StringBuilder stringbuilder = ehc.a(size()).append('[').append(d[a]);
        for (int i = a + 1; i < a + c; i++)
        {
            stringbuilder.append(", ").append(d[i]);
        }

        return stringbuilder.append(']').toString();
    }
}
